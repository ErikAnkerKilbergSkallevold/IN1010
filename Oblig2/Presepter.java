public class Presepter extends HvitResept{
  private int pris;


  public Presepter(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){
    super(legemiddel, utskrivendeLege, pasientId, 3);
    this.pris = pris;
  }
  public String farge(){
    return "Hvit";
  }

  @Override
  public boolean bruk(){
    return true;
  }

  public int prisAaBetale(){
    pris = legemiddel.hentPris();
    if (pris < 108) {
      pris = 0;
    } else {
      pris = pris - 108;
    }
    return pris;
  }
}
