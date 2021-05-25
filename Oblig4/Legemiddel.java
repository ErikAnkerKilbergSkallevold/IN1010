//Oblig 4

public abstract class Legemiddel{
    
    int id;
    String navn;
    int pris;
    double virkestoff;
    static int idCounter = 0; //Holder styr på id'en til legemidler
    
    //Enkel konstruktør
    public Legemiddel(String innNavn, int innPris, double innVirkestoff){
        id = idCounter;
        navn = innNavn;
        pris = innPris;
        virkestoff = innVirkestoff;
        idCounter ++;
    }
    
    //Nedenfor gjør funksjonene det de heter, eg. hentId henter id'en til legemiddelet
    
    public int hentId(){
        return id;
    }
    
    public String hentType(){
        return "";
    }
    
    public String hentNavn(){
        return navn;
    }
    
    public int hentPris(){
        return pris;
    }
    
    public double hentVirkestoff(){
        return virkestoff;
    }
    
    public void settNyPris(int nyPris){
        pris = nyPris;
    }
    
    public int hentStyrke(){
        return 0;
    }
    
    public String toString(){
        return String.format("Id: %d    Navn: %s    Pris: %d kr Virkestoff: %f mg ", id, navn, pris, virkestoff);
    }
}