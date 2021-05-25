import java.util.ArrayList;
class HvitRute extends Rute {

    public HvitRute(int kol, int rad, Labyrint lab) {
        super(kol, rad, lab);
    }

    @Override
    protected char ruteTegn(){
        return '.';
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
