//Oblig 4

public class MilitaerResept extends HvitResept{
    
    //Enkel konstruktør som mater inn i super
    public MilitaerResept(Legemiddel innLegemiddelRef, Lege legeRef, Pasient pasient, int innReit){
        super(innLegemiddelRef, legeRef, pasient, innReit);
    }
    
    //Nedenfor gjor funksjonene det de heter
    
    @Override
    public int prisAaBetale(){
        return 0;
    }
    
    @Override
    public String farge(){
        return "militaer";
    }
}