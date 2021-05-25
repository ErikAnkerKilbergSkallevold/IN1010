//Oblig 4

public class Vanlig extends Legemiddel{
    
    //Enkel konstruktør som mater inn i super
    public Vanlig(String innNavn, int innPris, double innVirkestoff){
        super(innNavn, innPris, innVirkestoff);
    }
    
    public String hentType(){
        return "vanlig";
    }
}