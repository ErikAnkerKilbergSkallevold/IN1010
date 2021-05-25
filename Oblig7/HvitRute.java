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
public class HvitRute extends Rute {

    public HvitRute(int kol, int rad, Labyrint lab) {
        super(kol, rad, lab);
    }

    @Override
    protected char ruteTegn(){
        return '.';
    }

    @Override
    public void initGUI() {
      setBorder(BorderFactory.createLineBorder(Color.white));
      setBackground(Color.white);
      setFont(new Font("Monospaced", Font.BOLD, 50));
      setPreferredSize(new Dimension(40, 40)); //Hvis den største ikke passer, endre disse til mindre tall!
      setText(" ");
      Rute denneRuten = this;
      class Rutevelger implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
          labyrint.finnUtveiFra(X, Y);
        }
      }
      addActionListener(new Rutevelger());
    }

    @Override
    public void resettFarge(){
      setBackground(Color.white);
      setText(" ");
    }

    public void gaa(ArrayList<Tuppel> vei) {
        vaertDer = true;

        ArrayList<Tuppel> nyVei = new ArrayList<Tuppel>(vei);
        nyVei.add(new Tuppel(X, Y));

        for (Rute r : naboRuter) {
                if (r !=null) {
                    if (r.erBesokt() != true) {
                        r.gaa(nyVei);
                    }
                }
        }
    }
}
