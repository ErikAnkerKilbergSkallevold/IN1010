//Oblig 4

abstract public class Resept{
    
    int id;
    Legemiddel legemiddelRef;
    Lege legeRef;
    Pasient pasient;
    int reit;
    static int idCounter = 0; //Holder styr på id'en til Resepter
    
    //Enkel konstruktør
    public Resept(Legemiddel innLegemiddelRef, Lege innLegeRef, Pasient innPasient, int innReit){
        id = idCounter;
        legemiddelRef = innLegemiddelRef;
        pasient = innPasient;
        reit = innReit;
        legeRef = innLegeRef;
        idCounter ++;
    }
    
    //Nedenfor gjør funksjonene det de heter
    
    public String toString(){
        return "Resept ID: " + id + " Type: " + this.getClass() + " LegemiddelNavn: " + legemiddelRef.hentNavn() + " LegemiddelID: " + legemiddelRef.hentId() + " ReitIgjen: " + this.hentReit() + " utskrivendeLege: " + legeRef.hentNavn();
    }
    
    public int hentReit0(){
        return reit;
    }
    
    public int hentId(){
        return id;
    }
    
    public Legemiddel hentLegemiddel(){
        return legemiddelRef;
    }
    
    public Lege hentLege(){
        return legeRef;
    }
    
    public int hentPasientId(){
        return pasient.hentId();
    }
    
    public boolean bruk(){
        if (reit > 0){
            reit --;
            return true;
        }
        return false;
    }
    
    public int hentReit(){
        return reit;
    }
    
    abstract public String farge();
    
    abstract public int prisAaBetale();
}