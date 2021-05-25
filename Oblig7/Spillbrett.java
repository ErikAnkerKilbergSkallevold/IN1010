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

public class Spillbrett extends JPanel {
  JButton sluttknapp;
  JLabel statustekst;
  Labyrint lab;

  public Spillbrett(Labyrint innLab) {
    lab = innLab;
  }

  public void initGUI () {
    lab.initGUI();
    add(lab);

    statustekst = new JLabel("Velg en rute");
    add(statustekst);

    sluttknapp = new JButton("Exit");
    class Stoppbehandler implements ActionListener {
      @Override
      public void actionPerformed (ActionEvent e) {
        System.exit(0);
      }
    }
    sluttknapp.addActionListener(new Stoppbehandler());
    add(sluttknapp);
  }
}
