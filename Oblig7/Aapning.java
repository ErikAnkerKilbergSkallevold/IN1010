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
public class Aapning extends HvitRute {
    public Aapning(int kol, int rad, Labyrint lab) {
        super(kol, rad, lab);
    }

    @Override
    public void initGUI() {
      setBorder(BorderFactory.createLineBorder(Color.pink));
      setBackground(Color.pink);
      setFont(new Font("Comic Sans MS", Font.BOLD, 25));
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
    public void gaa(ArrayList<Tuppel> vei) {
        vaertDer = true;

        ArrayList<Tuppel> nyVei = new ArrayList<Tuppel>(vei);

        nyVei.add(new Tuppel(X, Y));
        labyrint.leggTilUtvei(nyVei);
    }

    @Override
    protected char ruteTegn(){
        return '.';
    }

    @Override
    public void resettFarge(){
      setBackground(Color.green);
      setText(" ");
    }

    @Override
    public void losningFarge(int lengde){
      setBackground(Color.pink);
      setText(Integer.toString(lengde));
    }
  }
