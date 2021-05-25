//Oblig 4

public class BlaaResept extends Resept{
    
    //Enkel konstruktør som mater inn i super
    public BlaaResept(Legemiddel innLegemiddelRef, Lege legeRef, Pasient pasient, int innReit){
        super(innLegemiddelRef, legeRef, pasient, innReit);
    }
    
    //Nedenfor gjor funksjonene det de heter
    
    @Override
    public String farge(){
        return "blaa";
    }
    
    @Override
    public int prisAaBetale(){
        return Math.round(legemiddelRef.hentPris()/4);
    }
}