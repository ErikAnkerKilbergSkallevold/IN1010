public class HvitResept extends Resept{
  private int pris;


  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, reit);
    this.pris = pris;
  }

  public String farge(){
    return "Hvit";
  }

  public int prisAaBetale(){
    pris = legemiddel.hentPris();
    return pris;
  }

}
