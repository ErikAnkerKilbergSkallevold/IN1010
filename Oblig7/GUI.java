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
import java.util.Random;

public class GUI{
  public static void main(String[] args) {

    Labyrint lab = null;

    JFileChooser velger = new JFileChooser();
    int resultat = velger.showOpenDialog(null);
    if (resultat != JFileChooser.APPROVE_OPTION){
        System.exit(1);
    }
    File f = velger.getSelectedFile();
    lab = new Labyrint(f);



    JFrame vindu = new JFrame ("Labyrint");
    vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Spillbrett brett = new Spillbrett(lab);

    brett.initGUI();
    vindu.add(brett);

    vindu.pack();
    vindu.setVisible(true);
  }
}
