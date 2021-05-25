import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataklynge{
  //arrayliste er mye bedre for å ekspandere
  ArrayList<Rack> listeOverRacks = new ArrayList<Rack>();
  private int plasserIgjen = 0;
  private int noder = 0;
  private int Rackteller = 0;
  int antNode;

  //konstruktor
  public Dataklynge(String filnavn){
    try{
      File plassering = new File(filnavn);
      Scanner lesFil = new Scanner(plassering);
      antNode = Integer.valueOf(lesFil.nextLine());
      while(lesFil.hasNextLine()){
        String[] bit = lesFil.nextLine().split(" ");
        int mengde = Integer.valueOf(bit[0]);
        int menRAM = Integer.valueOf(bit[1]);
        int menCPU = Integer.valueOf(bit[2]);
        for (int i = 0; i < mengde; i++){
          //System.out.println(i +" "+" "+ menRAM +" "+" "+ menCPU);
          this.mineNoder(new Node(menRAM, menCPU));
        }
      }

    }
    catch (FileNotFoundException filtester){
      System.out.println("Filen har feil navn, finnes ikke eller er korrupt");
      filtester.printStackTrace();
    }
  }

  public void mineNoder(Node enNode){
    boolean sattInn = false;
    for (int i = 0; i < listeOverRacks.size(); i++) {
      //System.out.println(plasserIgjen > 0);
      //System.out.println(listeOverRacks.get(i).getAntNoder());
      if (plasserIgjen > 0 && listeOverRacks.get(i).getAntNoder() < antNode) {
        System.out.println("Det er plass!");
        listeOverRacks.get(i).settInn(enNode);
        plasserIgjen --;
        sattInn = true;
        //System.out.println(plasserIgjen);
      }
    }


    if (!sattInn) {
      //System.out.println("Lager ny rack!");
      Rack nyRack = new Rack(antNode);
      plasserIgjen += antNode;
      Rackteller++;
      nyRack.settInn(enNode);
      listeOverRacks.add(nyRack);
    }
  }

    public int antProssesorer(){
      int prosTeller = 0;
      for (Rack rack : listeOverRacks){
        //System.out.println(prosTeller + " klynge");
        prosTeller += rack.antallProssesorer();

    }

    return prosTeller;
  }

  public int noderMedNokMinne(int paakrevdMinne){
    int minneTeller = 0;
    for (Rack rack : listeOverRacks){
      minneTeller += rack.noderMedNokMinne(paakrevdMinne);

    }
    return minneTeller;
  }

  public int antRacks(){
    return Rackteller;
  }
}
