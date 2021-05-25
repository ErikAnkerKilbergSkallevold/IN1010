import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

public class LesMedTraad_unik implements Runnable{
  static int subLengde = 3;
  String filNavn;
  String erSyk;
  VirusHoved_unik1 monitor;

  public LesMedTraad_unik(String innfilNavn, String innErSyk, VirusHoved_unik1 innMonitor){
    filNavn = innfilNavn;
    erSyk = innErSyk;
    monitor = innMonitor;
  }

  public void run(){
    HashMap<String, SubSequence> subSeqHash = new HashMap<String, SubSequence>();
    String subStreng;
    String linje;
    try {
      Scanner leser = new Scanner(new File("C:\\Users\\ErikS\\OneDrive\\UIO\\Oblig\\IN1010\\Oblig5\\Oblig5 test\\TestData\\"+filNavn)); //Denne må endres til din filepath
      System.out.println(" Virussjekker leser fil   " + filNavn );
      while(leser.hasNextLine()) {
        linje = leser.nextLine();
        //System.out.println(linje);
        linje = linje.trim();
        //System.out.println(linje);
        for (int ind = 0; ind + subLengde <= linje.length(); ind ++) {
            subStreng = linje.substring(ind,ind+subLengde);
            subSeqHash.putIfAbsent(subStreng,new SubSequence(subStreng));
          }
        monitor.leggTilListe(subSeqHash, erSyk);
      }

    }  catch  (IOException e) {
        System.out.println(e.getMessage());
        System.exit(1);
    }
  }
}
