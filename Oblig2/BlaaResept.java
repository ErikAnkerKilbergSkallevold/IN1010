public class BlaaResept extends Resept{
  private int pris;

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, reit);
    this.pris = pris;
  }

  public String farge(){
    return "Blaa";
  }

  public int prisAaBetale(){
    pris = legemiddel.hentPris();
    pris = (pris/100)*25;
    return pris;
  }

}
