abstract class Resept{
  protected static int teller = 0;
	protected int id;
	protected Legemiddel legemiddel;
	protected Lege utskrivendeLege;
	protected int pasientId;
	protected int reit;

  public Resept (Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    this.id = teller + 1;
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasientId = pasientId;
    this.reit = reit;
    teller++;
  }

  public String toString(){
    return "Resept ID: " + id + " Type: " + this.getClass() + " LegemiddelNavn: " + legemiddel.hentNavn() + " LegemiddelID: " + legemiddel.hentID() + " ReitIgjen: " + this.reit + " utskrivendeLege: " + hentLege();
  }

  public int hentId(){
    return this.id;
  }

  public String hentLegemiddel(){
    return legemiddel.hentNavn();
  }

  public String hentLege(){
    return utskrivendeLege.hentLegeNavn();
  }

  public int hentPasientId(){
    return this.pasientId;
  }

  public int hentReit(){
    return this.reit;
  }

  public boolean bruk(){
    if (this.reit == 0) {
      System.out.println("Resepten er brukt opp!");
      return false;
    } else {
      this.reit = this.reit - 1;
      return true;
    }
  }

  public abstract String farge();

  public abstract int prisAaBetale();
}
