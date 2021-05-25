//Oblig 4

public class HvitResept extends Resept{
    
    //Enkel konstruktør som mater inn i super
    public HvitResept(Legemiddel innLegemiddelRef, Lege legeRef, Pasient pasient, int innReit){
        super(innLegemiddelRef, legeRef, pasient, innReit);
    }
    
    //Nedenfor gjor funksjonene det de heter
    
    @Override
    public String farge(){
        return "hvit";
    }
    
    @Override
    public int prisAaBetale(){
        return legemiddelRef.hentPris();
    }
}