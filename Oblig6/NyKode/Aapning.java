import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Aapning extends HvitRute {
    public Aapning(int kol, int rad, Labyrint lab) {
        super(kol, rad, lab);
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
  }
