import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
public class VirusHoved_unik1{

  ReentrantLock lock = new ReentrantLock();
  HashBeholder frisk = new HashBeholder();
  HashBeholder syk = new HashBeholder();
  static final String metadataFilbane = "C:\\Users\\ErikS\\OneDrive\\UIO\\Oblig\\IN1010\\Oblig5\\Oblig5 test\\TestData\\metadata.csv";//Denne må endres til din filepath

  ArrayList<Thread> threadList = new ArrayList<Thread>();

  public static void main(String[] args) {
    String linje;
    String filNavn;
    String erSyk;

    VirusHoved_unik1 overmind = new VirusHoved_unik1();

    try{

        Scanner leser = new Scanner(new File(metadataFilbane));
        System.out.println(" Velkommen til HashBeholder test hovedprogram ");
        leser.nextLine();
        while(leser.hasNextLine()) {

            linje = leser.nextLine();
            filNavn = linje.trim().split(",")[0];
            erSyk = linje.trim().split(",")[1];
            LesMedTraad_unik runnableRef = new LesMedTraad_unik(filNavn, erSyk, overmind);
            Thread newThread = new Thread(runnableRef);
            overmind.threadList.add(newThread);
            newThread.start();



        }
        leser.close();
        while(overmind.traaderKjoorer()){;}
        System.out.println("Frisk: " + overmind.frisk.antall());
        System.out.println("Syk: " + overmind.syk.antall());
    } catch (IOException e) {System.out.println(e.getMessage()); }
  }

  public void leggTilListe(HashMap<String, SubSequence> subInn, String erSyk){
    lock.lock();
    try {
      if (Boolean.parseBoolean(erSyk)) {
        syk.leggTil(subInn);
      }else{
        frisk.leggTil(subInn);
      }
    } finally {
      lock.unlock();
    }
  }

 public boolean traaderKjoorer(){
    boolean retVal = false;
    for (Thread thread : threadList) {
      if (thread.getState() != Thread.State.TERMINATED) {
        retVal = true;
      }
    }
    return retVal;
  }

}
