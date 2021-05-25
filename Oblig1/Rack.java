import java.util.ArrayList;

public class Rack{
  int antNode;
  Node[] nodes;

  //konstruktor
  public Rack(int antNode){
    this.antNode = antNode;
    nodes = new Node[antNode];
  }

  //setter in enn node
  public void settInn(Node enNode){
    for (int i = 0; i < this.antNode; i++) {
      //System.out.println(this.nodes[i] == null);
      if (this.nodes[i] == null) {
        this.nodes[i] = enNode;
        return;
        //System.out.println("Loren");
      }
    }
  }

  public int getAntNoder(){
    int teller = 0;
    for (Node node : nodes) {
      //System.out.println(node.getClass());
      if(node == null){
        ;
      }else{
        teller++;
      }
    }
    return teller;
  }

  public int antallProssesorer(){
    int Value = 0;
    for (Node node : nodes){
      if (node == null){
        ;
      } else {
        Value += node.antProssesorer();
      }
    }
    //System.out.println(Value + " rack");
    return Value;
  }

  public int noderMedNokMinne(int paakrevdMinne){
    int minneValue = 0;
    for (Node node : nodes){
      if (node == null){
          ;
      }else{
        if (node.nokMinne(paakrevdMinne)) {
          minneValue++;
        }else{
          ;
      }
      }
    }
    return minneValue;
  }

}
