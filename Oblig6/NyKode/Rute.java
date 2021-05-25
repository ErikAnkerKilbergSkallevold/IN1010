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

abstract class Rute extends JButton {
    protected int kolonne;
    protected int rad;
    Labyrint labyrint;
    protected ArrayList<Rute> naboRuter = new ArrayList<>();
    protected ArrayList<Rute> besokt = new ArrayList<>();
    protected ArrayList<Tuppel> veiLosning = new ArrayList<>();
    protected boolean vaertDer = false;
    protected int X;
    protected int Y;

    public Rute(int kol, int rad, Labyrint lab) {
        this.kolonne = kol;
        this.rad = rad;
        this.labyrint = lab;
        X = this.rad;
        Y = this.kolonne;
    }


    public void finnNaboRuter(Rute[][] rutenett, int antKol, int antRad) {
      //rutenett[rad][kolonne].ruteTegn() != '#'
      if (true) {
        if (rad != 0) {
          naboRuter.add(rutenett[rad - 1][kolonne]);
        } if (kolonne != 0) {
          naboRuter.add(rutenett[rad][kolonne - 1]);
        } if (rad < rutenett.length - 1) {
          naboRuter.add(rutenett[rad + 1][kolonne]);
        } if (kolonne < rutenett[0].length - 1) {
          naboRuter.add(rutenett[rad][kolonne + 1]);
        }
      }

    }



    public abstract void gaa(ArrayList<Tuppel> vei);

    public void finnUtvei(){
      if (this instanceof SortRute) {
        System.out.println("Oof, du valgte en sort rute :( ");
      } else {
        this.gaa(new ArrayList<Tuppel>());
      }
    }

    public boolean erBesokt() {
        return vaertDer;
    }

    public void resett(){
      vaertDer = false;
    }

    public String toString() {
        return "(" + kolonne + ", " + rad + ")";
    }

    protected abstract char ruteTegn();
}
