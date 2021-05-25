public class Node{
  private int prossesorAntall;
  private int minneAntall;
  private int paakrevdMinne;

  public Node(int minne, int antPros){
    prossesorAntall = antPros;
    minneAntall = minne;
  }

  public int antProssesorer(){
    return prossesorAntall;
  }

  public boolean nokMinne(int paakrevdMinne){
    if (minneAntall >= paakrevdMinne){
      return true;
    } else {
      return false;
    }
  }

}
