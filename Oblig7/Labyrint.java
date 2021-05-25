import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;

public class Labyrint extends JPanel {
    private int antallRader;
    private int antallKolonner;
    private Rute[][] rutenett;
    Rute[][] testArray;
    protected ArrayList<ArrayList<Tuppel>> utveier = new ArrayList<>();


    public Labyrint(File fil) {
      Scanner leser = null;
      try {
        leser = new Scanner(fil);
      } catch(FileNotFoundException e) {
        System.exit(1);
      }

      String nesteLinje = leser.nextLine();
      String[] splittet = nesteLinje.split(" ");

      int antallKolonner = Integer.parseInt(splittet[0]);
      int antallRader = Integer.parseInt(splittet[1]);
      Rute[][] rutenett = new Rute[antallKolonner][antallRader];

      for (int k = 0; k < antallKolonner; k++) {
        splittet = leser.nextLine().split("");
        for (int r = 0; r < antallRader ; r++) {
          if (splittet[r].equals(".")) {
            if (k == 0 || r == 0 || r == antallKolonner - 1 || k == antallRader - 1) {
                rutenett[k][r] = new Aapning(r, k, this);
                //System.out.println("Aapning " + rutenett[k][r].toString());
            } else {
                rutenett[k][r] = new HvitRute(r, k, this);
                //System.out.println("Hvit " + rutenett[k][r].toString());
            }
          } else {
            rutenett[k][r] = new SortRute(r, k, this);
            //System.out.println("Sort " + rutenett[k][r].toString());
          }
        }
      }

      for (Rute[] k : rutenett) {
          for (Rute r : k) {
              r.finnNaboRuter(rutenett, antallKolonner, antallRader);
              //System.out.println(r.toString());
          }
      }
      testArray = rutenett; //Rutenett blir av en eller annen grunn null, men kopien blir ikke det!! Så dette må til for å få programmet til å kjøre :((((((
    }

    public String toString() {
    String utskrift = "";
    for (int aR = 0; aR < antallRader; aR++) {
      for (int aK = 0; aK < antallKolonner; aK++) {
        utskrift = utskrift + rutenett[aR][aK].ruteTegn();
      }
    }
    System.out.println(utskrift);
    return utskrift + "\n";
    }


    public void initGUI(){
      setLayout(new GridLayout(testArray.length, testArray[0].length));
      for (Rute[] k : testArray) {
          for (Rute r : k) {
              r.initGUI();
              add(r);
          }
      }
    }


    public ArrayList<ArrayList<Tuppel>> finnUtveiFra(int kol, int rad) {
        resett();
        testArray[kol][rad].finnUtvei();
        return utveier;
    }

    public void resett(){
      utveier.clear();
      for (Rute[] k : testArray) {
          for (Rute r : k) {
              r.resett();
              r.resettFarge();
          }
      }
    }

    public void leggTilUtvei(ArrayList<Tuppel> vei) {
        for(Tuppel tp : vei){
          testArray[tp.getX()][tp.getY()].losningFarge(vei.size());
        }
        utveier.add(vei);
    }

    public int hentAntallantallRader(){
      return antallRader;
    }

    public int hentAntallantallKolonner(){
      return antallKolonner;
    }

    public Rute[][] hentRutenett() {
        return rutenett;
    }
}
