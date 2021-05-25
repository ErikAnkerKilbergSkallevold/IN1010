class TestResept{
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

    //Tester Resept

    System.out.println("Tester Resept");

    if (b1.hentId() == 1) {
      System.out.println("True"+" "+ b1);
    }else{
      System.out.println("False");
    }

    if (b2.hentId() == 2) {
      System.out.println("True" +" "+ b2.hentReit());
    }else{
      System.out.println("False");
    }

    if (m1.hentId() == 3) {
      System.out.println("True" +" "+ m1.hentId());
    }else{
      System.out.println("False");
    }
    if (m2.hentId() == 4) {
      System.out.println("True"+" "+ m2.hentLegemiddel());
    }else{
      System.out.println("False");
    }

    if (p1.hentId() == 5) {
      System.out.println("True" +" "+ p1.hentLege());
    }else{
      System.out.println("False");
    }

    if (p2.hentId() == 6) {
      System.out.println("True" +" "+ p2.hentPasientId());
    }else{
      System.out.println("False");
    }
    //Tester Reit på BlaaResept
    System.out.println("Tester Reit 3/3");
    System.out.println(b2.hentReit());
    System.out.println("Bruker en respet");
    b2.bruk();
    System.out.println(b2.hentReit());
    System.out.println("Bruker en respet");
    b2.bruk();
    System.out.println(b2.hentReit());
    System.out.println("Bruker en respet");
    b2.bruk();
    System.out.println(b2.hentReit());
    System.out.println("Bruker en respet");
    b2.bruk();


    //Tester Presept Reit
    System.out.println("Tester Presept Reit, skal ikke ha reit");
    System.out.println(p1.hentReit());
    System.out.println("Bruker en Presept reit");
    p1.bruk();
    System.out.println(p1.hentReit());
    System.out.println("Bruker en Presept reit");
    p1.bruk();
    System.out.println(p1.hentReit());
    System.out.println("Bruker en Presept reit");
    p1.bruk();
    System.out.println(p1.hentReit());
    System.out.println("Bruker en Presept reit");
    p1.bruk();
  }
}
