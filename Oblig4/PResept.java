//Oblig 4

public class PResept extends HvitResept{
    
    //Enkel konstruktør som mater inn i super
    public PResept(Legemiddel innLegemiddelRef, Lege legeRef, Pasient pasient){
        super(innLegemiddelRef, legeRef, pasient, 3);
    }
    
    //Nedenfor gjør funksjonene det de heter
    
    @Override
    public int prisAaBetale(){
        if (legemiddelRef.hentPris() > 108){
            return legemiddelRef.hentPris() - 108;
        }
        //Hvis prisen er mindre enn 108 kr så må pasienten betale 0 kr.
        return 0;
    }
    
    @Override
    public String farge(){
        return "p";
    }
    
    public int hentReit0(){
        return -1;
    }
}