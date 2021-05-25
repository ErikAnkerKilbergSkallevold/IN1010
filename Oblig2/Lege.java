public class Lege{
  protected String navn;

  public Lege (String navn){
    this.navn = navn;
  }

  public String hentLegeNavn() {
    return this.navn;
  }

  public String toString() {
		return "Navn: "+ navn + " Type: " + this.getClass();
	}
}
