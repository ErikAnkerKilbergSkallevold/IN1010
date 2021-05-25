//Oblig 4

public class Spesialist extends Lege implements Godkjenningsfritak{
    
    String kontrollId;
    
    //En enkel konstruktør
    public Spesialist(String innNavn, String innKontrollId){
        super(innNavn);
        kontrollId = innKontrollId;
    }
    
    //Sjekker om legen kan gi ut narkotiske stoffer
    @Override
    protected void sjekkNarkotisk(Legemiddel legemiddel) throws UlovligUtskrift{
        ;
    }
    
    //Nedenfor gjør funksjonene det de heter
    
    @Override
    public String hentKontrollID(){
        return kontrollId;
    }
    
    @Override
    public String toString(){
        return String.format("Navn: %s  KontrollID: %s", navn, kontrollId);
    }
}