//Oblig 4

public class Vanedannende extends Legemiddel{
    
    int styrke;
    
    //Enkel konstruktør som mater inn i super
    public Vanedannende(String innNavn, int innPris, double innVirkestoff, int innStyrke){
        super(innNavn, innPris, innVirkestoff);
        styrke = innStyrke;
    }
    
    //Nedenfor gjor funksjonene det de heter
    
    public int hentStyrke(){
        return styrke;
    }
    
    public String hentType(){
        return "vanedannende";
    }
    
    @Override
    public String toString(){
        return String.format("Id: %d    Navn: %s    Pris: %d kr Virkestoff: %f mg   Styrke: %d", id, navn, pris, virkestoff, styrke);
    }
}