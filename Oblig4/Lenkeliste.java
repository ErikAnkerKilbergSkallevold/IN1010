//Oblig 4

import java.util.*;

public class Lenkeliste<T> implements Liste<T>{
    
    int size = 0;
    Node head = null;
    
    protected class Node{
        T data;
        Node next;
        int index;
        
        Node(T innData){
            data = innData;
            next = null;
        }
    }
    
    protected class LenkeListeIterator<T> implements Iterator<T> {
        
        private Lenkeliste<T> LL;
        private int pos;
        
        public LenkeListeIterator(Lenkeliste<T> innLL) {
        LL = innLL;
        pos = 0; 
        }
        
        public T next() {
            return LL.hent(pos++);
        }
        
        public boolean hasNext() {
            return (pos < LL.stoerrelse());
        }
        
        public void remove(){
            LL.fjern(pos);
        }
    }
    
    public Iterator<T> iterator(){
        return new LenkeListeIterator<T>(this);
    }
    
    //Printer ut lister python style
    public String toString(){
        Node n = head;
        String ret;
        ret = "[";
        while (n != null) { 
            if (n.next != null){
                ret = ret + n.data + ", "; 
            }else{
                ret = ret + n.data;
            }
            n = n.next; 
        }
        ret = ret + "]";
        return ret;
    }
    
    
    public int stoerrelse(){
        return size;
    }
    
    
    public void leggTil(int pos, T x){
        Node n = head;
        if (pos > size || pos < 0){ //Her kan pos vaere stoerre enn null og mindre enn stoerrelsen til lista.
            throw new UgyldigListeIndeks(pos);
        }
        if (pos == 0){
            Node tmp = new Node(x);
            tmp.next = head;
            head = tmp;
            size ++;
            return;
        }
        //Finner riktig posisjon
        for (int i = 0; i < pos-1; i++){
            n = n.next;
        }
        Node temp = new Node(x);
        temp.next = n.next;
        n.next = temp;
        size++;
        
    }
    
    
    public void leggTil(T x){
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
    
    
    public void sett(int pos, T x){
        Node n = head;
        
        if (pos > size-1 || pos < 0){
            throw new UgyldigListeIndeks(pos);
        }
        //Finner riktig posisjon
        for (int i = 0; i < pos; i++){
            n = n.next;
        }
        n.data = x;
    }
    
    
    public T hent(int pos){
        Node n = head;
        if (pos > size-1 || pos < 0){
            throw new UgyldigListeIndeks(pos);
        }
        //Finner riktig posisjon
        for (int i = 0; i < pos; i++){
            n = n.next;
        }
        return n.data;
    }
    
    
    public T fjern(int pos){
        Node n = head;
        if (pos > size-1 || pos < 0){//Her kan pos vaere stoerre enn null og mindre enn stoerrelsen til lista.
            throw new UgyldigListeIndeks(pos);
        }
        //hvis pos er 0
        if (pos == 0){
            Node ret0 = head;
            head = head.next;
            size--;
            return ret0.data;
        }
        //Hvis pos er den siste indeksen
        if (pos == size-1){
            for (int i = 0; i < pos-1; i++){
                n = n.next;
            }
            Node ret = n.next;
            n.next = null;
            size--;
            return ret.data;
        }
        //Finner riktig posisjon
        for (int i = 0; i < pos-1; i++){
            n = n.next;
        }
        Node ret = n.next;
        n.next = n.next.next;
        size--;
        return ret.data;
    }
    
    
    public T fjern(){
        if (head == null){
            throw new UgyldigListeIndeks(0);
        }
        Node ret = head;
        head = head.next;
        size--;
        return ret.data;
    }
}