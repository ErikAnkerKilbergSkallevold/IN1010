//Oblig 4

public class Lege implements Comparable<Lege>{
    
    String navn;
    Lenkeliste<Resept> utskrevneResepter;
    
    //Enkel konstruktor
    public Lege(String innNavn){
        navn = innNavn;
        utskrevneResepter = new Lenkeliste<Resept>();
    }
    
    public String hentKontrollID(){
        return "0";
    }
    
    @Override
    public int compareTo(Lege lege){
        return this.navn.compareTo(lege.navn);
    }
    
    //Sjekker om legen kan gi ut narkotiske stoffer
    protected void sjekkNarkotisk(Legemiddel legemiddel) throws UlovligUtskrift{
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }
    }
    
    //Legger til resepten hos pasient og lege
    protected void leggTilReseptLegePasient(Resept innData, Pasient pasient){
        utskrevneResepter.leggTil(innData);
        pasient.leggTilResept(innData);
    }
    
    //funksjon for aa skrive resept
    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        sjekkNarkotisk(legemiddel);
        HvitResept ret = new HvitResept(legemiddel, this, pasient, reit);
        leggTilReseptLegePasient(ret, pasient);
        return ret;
    }
    
    //funksjon for aa skrive resept
    public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        sjekkNarkotisk(legemiddel);
        MilitaerResept ret = new MilitaerResept(legemiddel, this, pasient, reit);
        leggTilReseptLegePasient(ret, pasient);
        return ret;
    }
    
    //funksjon for aa skrive resept
    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift{
        sjekkNarkotisk(legemiddel);
        PResept ret = new PResept(legemiddel, this, pasient);
        leggTilReseptLegePasient(ret, pasient);
        return ret;
    }
    
    //funksjon for aa skrive resept
    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        sjekkNarkotisk(legemiddel);
        BlaaResept ret = new BlaaResept(legemiddel, this, pasient, reit);
        leggTilReseptLegePasient(ret, pasient);
        return ret;
    }
    
    //Nedenfor gjor funksjonene det de heter
    
    public Lenkeliste<Resept> hentUtskrevneResepter(){
        return utskrevneResepter;
    }
    
    public String hentNavn(){
        return navn;
    }
    
    public String toString(){
        return navn;
    }
}