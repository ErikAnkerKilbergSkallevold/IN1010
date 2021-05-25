import java.util.ArrayList;
class SortRute extends Rute {

    public SortRute(int kol, int rad, Labyrint lab) {
        super(kol, rad, lab);
    }

    protected char ruteTegn(){
        return '#';
    }

    public void gaa(ArrayList<Tuppel> vei) {
        vaertDer = true;
    }
}
