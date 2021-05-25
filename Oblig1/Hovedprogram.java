import java.util.ArrayList;
import java.util.HashMap;

class Hovedprogram{
  public static void main(String[] args) {
    Dataklynge k = new Dataklynge("dataklynge.txt");
    System.out.println("Noder med mer enn 31GB minne");
    System.out.println(k.noderMedNokMinne(32));
    System.out.println("Noder med mer enn 63GB minne");
    System.out.println(k.noderMedNokMinne(64));
    System.out.println("Noder med mer enn 127GB minne");
    System.out.println(k.noderMedNokMinne(128));
    System.out.println("Antall prosseserorer");
    System.out.println(k.antProssesorer());
    System.out.println("Antall racks");
    System.out.println(k.antRacks());
  }
}
