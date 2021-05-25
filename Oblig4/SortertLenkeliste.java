//Oblig 4

public class  SortertLenkeliste<T extends Comparable<T> > extends Lenkeliste<T>{
    
    public void leggTil(T x){
        //Sjekker om det er en tom liste
        if (size == 0){
            head = new Node(x);
        }else{
            Node n = head;
            //Hvis element x er stoerre enn det første elementet
            if (n.data.compareTo(x) > 0){
                Node tmp0 = head;
                head = new Node(x);
                head.next = tmp0;
                size ++;
                return;
            }
            //Finner riktig posisjon
            while (n.next != null){
                if (n.next.data.compareTo(x) < 0){
                    n = n.next;
                }else{
                    break;
                }
            }
            Node tmp = n.next;
            n.next = new Node(x);
            if (n.next != null){
                n.next.next = tmp;
            }
        }
        size ++;
    }
    
    public T fjern(){
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
        //Finner riktig posisjon
        while(n.next != null){
            if (n.next.next != null){
                n = n.next;
            }else{
                break;
            }
        }
        Node ret = n.next;
        n.next = null;
        size--;
        return ret.data;
    }
    
    public void sett(int pos, T x){
        throw new UnsupportedOperationException();
    }
    
    public void leggTil(int pos, T x){
        throw new UnsupportedOperationException();
    }
}