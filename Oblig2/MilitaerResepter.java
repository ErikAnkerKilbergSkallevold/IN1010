public class MilitaerResepter extends HvitResept{
  private int pris;


  public MilitaerResepter(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, reit);
    this.pris = pris;
  }
  public String farge(){
    return "Hvit";
  }

  public int prisAaBetale(){
    pris = legemiddel.hentPris();
    pris = 0;
    return pris;
  }
}
