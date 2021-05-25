//Oblig 4

public class Pasient{
    
    String navn;
    String foedselsnummer;
    Stabel<Resept> reseptStabel;
    int id = 0;
    
    static int antall;
    
    public Pasient(String innNavn, String innFoedselsnummer){
        navn = innNavn;
        foedselsnummer = innFoedselsnummer;
        reseptStabel = new Stabel<Resept>();
        id = antall;
        antall++;
    }
    
    public void leggTilResept(Resept innResept){
        reseptStabel.leggTil(innResept);
    }
    
    public String toString(){
        return "Navn: " + navn + "  Foedselsnummer: " + foedselsnummer + "   ID: " + id;
    }
    
    public Stabel<Resept> hentReseptStabel(){
        return reseptStabel;
    }
    
    public String hentNavn(){
        return navn;
    }
    
    public String hentFoedselsnummer(){
        return foedselsnummer;
    }
    
    public int hentId(){
        return id;
    }
    
}