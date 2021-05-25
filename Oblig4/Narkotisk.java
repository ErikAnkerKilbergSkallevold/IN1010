//Oblig 4

public class Narkotisk extends Legemiddel{
    
    int styrke;
    
    //Enkel konstruktør som mater inn i super
    public Narkotisk(String innNavn, int innPris, double innVirkestoff, int innStyrke){
        super(innNavn, innPris, innVirkestoff);
        styrke = innStyrke;
    }
    
    //Nedenfor gjor funksjonene det de heter
    
    public int hentStyrke(){
        return styrke;
    }
    
    public String hentType(){
        return "narkotisk";
    }
    
    @Override
    public String toString(){
        return String.format("Id: %d    Navn: %s    Pris: %d kr Virkestoff: %f mg   Styrke: %d", id, navn, pris, virkestoff, styrke);
    }
}