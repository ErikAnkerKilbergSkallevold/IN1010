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
public class SortRute extends Rute {

    public SortRute(int kol, int rad, Labyrint lab) {
        super(kol, rad, lab);
    }

    protected char ruteTegn(){
        return '#';
    }

    @Override
    public void initGUI() {
      setBorder(BorderFactory.createLineBorder(Color.white));
      setBackground(Color.black);
      setFont(new Font("Monospaced", Font.BOLD, 50));
      setPreferredSize(new Dimension(40, 40)); //Hvis den største ikke passer, endre disse til mindre tall! 
      setText(" ");
      Rute denneRuten = this;
      class Rutevelger implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
          labyrint.resett();
        }
      }
      addActionListener(new Rutevelger());
    }

    public void gaa(ArrayList<Tuppel> vei) {
        vaertDer = true;
    }

    @Override
    public void resettFarge(){
      setBackground(Color.black);
      setText(" ");
    }
}
