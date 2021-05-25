class TestLege{
  public static void main (String[] args){

    //Oppretter legemiddel
    Vanlig v1 = new Vanlig("Astrasenica", 1000,  200);
    Vanlig v2 = new Vanlig("Repsils", 50,  10);
    Vanedannende va1 = new Vanedannende("Strepsils", 56, 55.5, 1);
    Vanedannende va2 = new Vanedannende("Paracept", 120, 100.0, 2);
    Narkotisk n1 = new Narkotisk("Narkotika", 9999, 254.0, 20);
    Narkotisk n2 = new Narkotisk("Smash", 26, 1, 300);

    //Oppretter Leger
    Lege l1 = new Lege("Haakon");
    Lege l2 = new Lege("Erik");
    Lege l3 = new Lege("Hanna");
    Lege l4 = new Lege("Eckholf");
    Spesialist s1 = new Spesialist("Anker", 12345);
    Spesialist s2 = new Spesialist("Per Willy Willson", 54321);

    //Oppretter Resepter
    BlaaResept b1 = new BlaaResept(v1, l1, 1, 3);
    BlaaResept b2 = new BlaaResept(v2, l2, 2, 3);
    MilitaerResepter m1 = new MilitaerResepter(va1, l3, 3, 3);
    MilitaerResepter m2 = new MilitaerResepter(va2, l4, 4, 3);
    Presepter p1 = new Presepter(n1, s1, 5);
    Presepter p2 = new Presepter(n2, s2, 6);

    //Tester Lege

    System.out.println("Tester Lege");

    if (l1.hentLegeNavn() == "Haakon") {
      System.out.println("True, navnet stemmer");
    } else {
      System.out.println("False");
    }

    if (s1.hentKontrollID() == 12345) {
      System.out.println("True IDen stemmer");
    } else{
      System.out.println("False");
    }


  }
}
