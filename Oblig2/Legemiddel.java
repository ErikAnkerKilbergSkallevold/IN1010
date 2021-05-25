abstract class Legemiddel{
  private String navn;
  private int pris;
  private double virkestoff;
  static int IDCounter = 0;
  int counter = 0;

  public Legemiddel (String navn ,int pris, double virkestoff){
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
    IDCounter++;
    counter = IDCounter;
  }

  public String toString() {
		return "Navn: "+ navn + " Type: " + this.getClass();
	}

  public int hentID(){
    return counter;
  }

  public String hentNavn(){
    return this.navn;
  }

  public int hentPris(){
    return this.pris;
  }

  public double hentVirkestoff(){
    return this.virkestoff;
  }

  public void settNyPris(int nyPris){
    this.pris = nyPris;
  }

}
