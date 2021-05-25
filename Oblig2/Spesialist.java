public class Spesialist extends Lege implements Godkjenningsfritak{
  private int kontrollId;
  public Spesialist(String navn, int kontrollId){
    super(navn);
    this.kontrollId = kontrollId;
  }

  public int hentKontrollID(){
    return kontrollId;
  }

  public String toString() {
		return "Navn: "+ navn + " Type: " + this.getClass() + " SpesialistID: " + kontrollId;
	}
}
