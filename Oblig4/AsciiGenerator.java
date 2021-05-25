//Ascii generator
//https://www.codingame.com/playgrounds/18023/we-love-ascii-art/try-me
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.*;

public class AsciiGenerator{
    //Skrev linjetingene selv da :|
    public void linjeStrek(){
      linjeRom();
      System.out.println("------------------------------------------------");
      linjeRom();
    }
    //Skrev linjetingene selv da :3
    public void linjeRom(){
      System.out.println("");
    }
    //Skrev linjetingene selv da >:(
    public void linjeTom(){
      for (int i = 0;i<100 ;i++ ) {
        System.out.println("");
      }
    }

    //Fant koden for en ascii generator på https://www.codingame.com/playgrounds/18023/we-love-ascii-art/try-me
    //ඞඞඞ Litt sus om the crewmates hadde skrevet den selv ඞඞඞ
    public void asciiGenerator(String asciiTekst) {
      linjeStrek();
                 //##################################################
       String T = asciiTekst; // <--- Write your text here #
                 //##################################################

        int longT = T.length();
        int L = 4;
        int H = 5;

        String lettre[] = new String[longT];
        int code[] = new int[longT];
        String ligne[] = new String[H];
        String dessinLettre[] = new String[H];
        String dessinMot[] = new String[H];

          ligne[0] = " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ###     ";
          ligne[1] = "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #     ";
          ligne[2] = "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #      ";
          ligne[3] = "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       ";
          ligne[4] = "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###     ";

        for (int i=0; i<longT; i++){
        lettre[i]  = Character.toString(T.charAt(i));
        code[i] = T.charAt(i);

    if (code[i] > 96 && code[i] < 123){code[i]=code[i]-32;}
    if ((code[i] > 122 || code[i] < 96) && (code[i] < 65 || code[i] > 90)){code[i] = 63;}
       }

       int rang;
       for (int comp=0; comp<H; comp++){dessinMot[comp]="";}
       for (int r=0; r<longT;r++){
       rang = (code[r]-65) * L;
       if (rang<0){rang=26*4;}
       for (int j=0; j < H ; j++ ) {

          dessinLettre[j] = ligne[j].substring(rang,rang+L);
          dessinMot[j] = dessinMot[j] + dessinLettre[j];

        }
        }
          for (int j=0; j < H ; j++ ) {
           System.out.println(dessinMot[j]);
        }
        linjeStrek();
    }
}
