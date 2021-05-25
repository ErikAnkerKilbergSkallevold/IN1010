public class Tuppel{
    int X;
    int Y;
    public Tuppel(int innX, int innY){
        X = innX;
        Y = innY;
    }

    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }

    public String toString(){
        return "("+X+", "+Y+")";
    }
}
