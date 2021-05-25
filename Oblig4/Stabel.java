//Oblig 4

public class Stabel<T> extends Lenkeliste<T>{
    
    //Akkuratt samme kode som i LeggTil(T x) funksjonen, fordi de gjør det samme
    public void leggPaa(T x){
        //Sjekker om det er en tom liste
        if (size == 0){
            head = new Node(x);
        }else{
            //Finner riktig posisjon
            Node n = head;
            while (n.next != null){
                n = n.next;
            }
            n.next = new Node(x);
        }
        size ++;
    }
    
    public T taAv(){
        if (head == null){
            throw new UgyldigListeIndeks(0);
        }
        Node n = head;
        if (size == 1){
            Node ret0 = head;
            head = null;
            size--;
            return ret0.data;
        }
        for (int i = 0; i < size-2; i++){
            n = n.next;
        }
        Node ret = n.next;
        n.next = null;
        size--;
        return ret.data;
    }
}