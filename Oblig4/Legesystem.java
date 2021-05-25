//Oblig 4

//Importerer masse ting
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.*;


public class Legesystem{ //konstruktoer
    String asciiTekst; //Definerer og initer masse variabler
    static int kjorTeller = 0;
    Lenkeliste<Pasient> pasientListe = new Lenkeliste<Pasient>(); //Oppretter lenkelister for de forskjellige tingene
    Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
    SortertLenkeliste<Lege> legeListe = new SortertLenkeliste<Lege>();
    Lenkeliste<Resept> reseptListe = new Lenkeliste<Resept>();
    static AsciiGenerator acGen = new AsciiGenerator(); //Asciitekst :O

    public static void main(String[] args){ //Main
        boolean run = true;  //If run
        Scanner inputReader = new Scanner(System.in); //Scanner leser input
        Legesystem overmind = new Legesystem(); //Main er statisk saa vi lager et overmind objekt som ikke er det.
        overmind.lesInnFraFil("myeInndata.txt"); //Les inn fra denne filen
        //System.out.println(overmind.pasientListe.stoerrelse());
        while (run){ //While run = true

            if (kjorTeller == 0) {
                overmind.mainMenu();
            }
            int input = inputReader.nextInt();

            switch(input){ //Switch tar input og velger case (som if/elseif)
                case 0 :
                    acGen.asciiGenerator("Avslutter");
                    run = false;
                    break;
                case 1 :
                    overmind.skrivUtAlt();
                    overmind.menu();
                    break;
                case 2 :
                    overmind.leggTilObjekt();
                    overmind.menu();
                    break;
                case 3 :
                    overmind.brukResept();
                    overmind.menu();
                    break;
                case 4 :
                    overmind.statistikk();
                    overmind.menu();
                    break;
                case 5 :
                    overmind.eksporterTilFil();
                    overmind.menu();
                    break;
                case 8 :
                    overmind.clear();
                    break;
                case 9 :
                    overmind.mainMenu();
                    break;
                default:
                    acGen.linjeStrek();
                    System.out.println("Ikke gyldig input");
            }
        }
    }

    public void eksporterTilFil(){  //Eksporterer til fil
        acGen.linjeTom(); //Tommer terminal
        acGen.asciiGenerator("Eksporter"); //Skriver med Ascii
        Scanner strInput = new Scanner(System.in);
        System.out.println("Hva skal eksportfilen hete? (Husk .txt)");
        System.out.print("Input: ");
        String filnavn = strInput.nextLine().strip();
        try{
            File eksportFile = new File(filnavn);
            if (eksportFile.createNewFile()) {
                System.out.println("File created: " + eksportFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println("En feil oppstod");
            e.printStackTrace();
        }
        try{FileWriter skriver = new FileWriter(filnavn); //Skriver til fil med riktig format
            skriver.write("# Pasienter (navn, fnr)" + System.lineSeparator());
            for(Pasient pasient:pasientListe){
                skriver.write(pasient.hentNavn() + "," + pasient.hentFoedselsnummer() + System.lineSeparator());
            }
            skriver.write("# Legemidler (navn,type,pris,virkestoff,[styrke])" + System.lineSeparator());
            for(Legemiddel lg:legemiddelListe){
                skriver.write(lg.hentNavn() + "," + lg.hentType() + "," + lg.hentPris() + "," + lg.hentVirkestoff() + "," + lg.hentStyrke() + System.lineSeparator());
            }
            skriver.write("# Leger (navn,kontrollid / 0 hvis vanlig lege)" + System.lineSeparator());
            for(Lege lege:legeListe){
                skriver.write(lege.hentNavn() + "," + lege.hentKontrollID() + System.lineSeparator());
            }
            skriver.write("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])" + System.lineSeparator() + System.lineSeparator());
            for(Resept r:reseptListe){
                Pasient pasientPeker = null;
                for(Pasient p:pasientListe){
                    if(p.hentId() == r.hentPasientId()){
                        pasientPeker = p;
                        break;
                    }
                }
                String tmp = "";
                if (r.hentReit() > 0){
                    tmp = String.valueOf(r.hentReit());
                }
                skriver.write(r.hentLegemiddel().hentId() + "," + r.hentLege().hentNavn() + "," + pasientPeker.hentId() + "," + r.farge() + "," + tmp + System.lineSeparator());
            }
            skriver.close();

            System.out.println("Fil er eksportert");
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("0 - Avslutt");

    }

    public void statistikk(){ //Printer ut statistikk om prog
        acGen.asciiGenerator("Statistikk");
        int vanedannendeCounter = 0;
        int narkotiskCounter = 0;
        for(Resept resept:reseptListe){
            if (resept.hentLegemiddel() instanceof Vanedannende){
                vanedannendeCounter++;
            }
            if(resept.hentLegemiddel() instanceof Narkotisk){
                //System.out.println(resept.toString());
                narkotiskCounter++;
            }
        }
        acGen.linjeRom(); //Lager litt pusterom i terminal
        System.out.println("Resepter av vanedannende stoffer: " + vanedannendeCounter);
        System.out.println("Resepter av narkotiske stoffer: " + narkotiskCounter);
        acGen.linjeStrek();

        for(Lege lege: legeListe){
            int antNarkotiskeResepter = 0;
            for (Resept resept:lege.hentUtskrevneResepter()){
                if (resept.hentLegemiddel() instanceof Narkotisk){
                    antNarkotiskeResepter++;
                    //System.out.println(resept.toString());
                }
            }
            if (antNarkotiskeResepter > 0){
                System.out.println(lege.hentNavn() + " har skrevet ut " + antNarkotiskeResepter + " antall resepter paa narkotiske legemidler.");
                System.out.println();
            }
        }

        for(Pasient pasient: pasientListe){
            int antNarkotiskePasienter = 0;
            for (Resept resept:pasient.hentReseptStabel()){
                if (resept.hentLegemiddel() instanceof Narkotisk){
                    antNarkotiskePasienter++;
                    //System.out.println(resept.toString());
                }
            }
            if (antNarkotiskePasienter > 0){
                System.out.println(pasient.hentNavn() + " har faatt " + antNarkotiskePasienter + " antall resepter paa narkotiske legemidler.");
                System.out.println();
            }
        }
        acGen.linjeStrek(); //Lager en strek i terminal
        menu();
    }

    public void brukResept(){  //Bruker kan bruke resept based on birthnr.
        Scanner intInput = new Scanner(System.in);
        Scanner strInput = new Scanner(System.in);
        int Runner = 0;
        if (Runner == 0) {
          acGen.linjeTom();
          acGen.asciiGenerator("Bruk resept");
          Runner++;
        }else{
          acGen.asciiGenerator("Bruk resept");
        }

        boolean brukReseptRun = true;
        boolean brukReseptRun2 = false;
        while (brukReseptRun){ //For aa finne resept
            System.out.println("Skriv inn foedselnummer på pasienten.");
            System.out.print("Input: ");
            String fdlInput = strInput.nextLine().strip();
            if (fdlInput.charAt(0) == '0' && fdlInput.length() == 1) { //For at brukeren skal gunne gaa ut hvis de skriver null
                break;
            }
            acGen.linjeStrek();
            Pasient pasientPeker = null;
            for (Pasient pasient : pasientListe){
                if (Long.valueOf(pasient.hentFoedselsnummer()) == Long.parseLong(fdlInput)){
                    pasientPeker = pasient;
                    //System.out.println("Fant pasient" + counter);
                    brukReseptRun2 = true;
                    break;
                }
            }
            if (pasientPeker == null){

                System.out.println("Fant ikke pasient med foedselnummer: " + fdlInput);
                System.out.println("0 - Hovedside");
                acGen.linjeStrek();

            }
            while(brukReseptRun2){ //For aa bruke resept


                System.out.println("Velg og bruk resept - (Skriv tallet til hoeyre for resepten du vil bruke)");
                acGen.linjeStrek();
                for (int i = 1; i < pasientPeker.hentReseptStabel().stoerrelse() + 1 ; i++){
                    System.out.println((i) +". " + pasientPeker.hentReseptStabel().hent(i-1).toString());
                }
                int input = intInput.nextInt();
                if(input == 0){
                    brukReseptRun = false;
                    brukReseptRun2 = false;
                } else {
                    Resept hentetResept = pasientPeker.hentReseptStabel().hent(input-1);
                    if (hentetResept.bruk()){
                        System.out.println("Brukte resept på " + hentetResept.hentLegemiddel().hentNavn() + ", " + hentetResept.hentReit() + " reit igjen.");
                    } else {
                        System.out.println("Kunne ikke bruke resept på " + hentetResept.hentLegemiddel().hentNavn() + " (Ingen gjenvearende reit igjen).");
                    }
                    acGen.linjeStrek();
                    System.out.println("Hovedside - 0");

                }
            }
        }
    }

    public void objektMenu(){
      acGen.linjeRom();
      System.out.println("Hovedside - 0");
      System.out.println("Legg til Pasient - 1");
      System.out.println("Legg til Legemiddel - 2");
      System.out.println("Legg til Lege - 3");
      System.out.println("Legg til Resept - 4");
      System.out.println("Clear - 8");
      System.out.println("Hjelp - 9");
      acGen.linjeRom();
    }

    public void leggTilObjekt(){ //Lar bruker legge til objekter
        Scanner intInput = new Scanner(System.in);
        Scanner strInput = new Scanner(System.in);
        acGen.linjeTom();
        acGen.asciiGenerator("Legg til objekt");
        boolean objectRun = true;
        int runTeller = 0;

        while (objectRun){
            if (runTeller != 0) {
              objektMenu();
              runTeller++;
            }else{
              acGen.asciiGenerator("Legg til objekt");
              objektMenu();
            }

            int input = intInput.nextInt();
            switch(input){
                case 0:
                    objectRun = false;
                    runTeller = 0;
                    break;
                case 1:  //Legger til pasient
                    acGen.linjeTom();
                    acGen.asciiGenerator("Legg til Pasient");
                    System.out.println("Format: navn, fnr");
                    System.out.print("Input: ");
                    String dataPerson = strInput.nextLine().strip();
                    String[] splitDataPerson = dataPerson.split(",");
                    try{
                        String navnPasient = splitDataPerson[0];
                        String foedselsnummer = splitDataPerson[1];
                        Pasient newPasient = new Pasient(navnPasient,foedselsnummer);
                        pasientListe.leggTil(newPasient);
                        System.out.println("La til " + newPasient.toString());
                        acGen.linjeRom();
                    } catch (Exception e){
                        System.out.println("Feil format proev igjen"); //Fuck the user
                        acGen.linjeRom();
                    }
                    break;
                case 2: //Legg til legemiddel
                    acGen.linjeTom();
                    acGen.asciiGenerator("Legg til legemiddel");
                    System.out.println("Format: navn,type,pris,virkestoff,[styrke]");
                    System.out.print("Input: ");
                    String dataLegemiddel = strInput.nextLine().strip();
                    String[] splitDataLegemiddel = dataLegemiddel.split(",");
                    Legemiddel newLegemiddel = null;
                    try{
                        String navnLegemiddel = splitDataLegemiddel[0];
                        String typeLegemiddel = splitDataLegemiddel[1];
                        double prisD = Double.valueOf(splitDataLegemiddel[2]);
                        int pris = (int)prisD;
                        double virkestoff = Double.valueOf(splitDataLegemiddel[3]);
                        if (typeLegemiddel.contains("vanlig")){
                            //System.out.println("Vanlig");
                            newLegemiddel = new Vanlig(navnLegemiddel, pris, virkestoff);
                        } else {
                            int styrke = Integer.valueOf(splitDataLegemiddel[4]);
                            if (typeLegemiddel.contains("narkotisk")){
                                //System.out.println("Narkotisk");
                                newLegemiddel = new Narkotisk(navnLegemiddel, pris, virkestoff, styrke);
                            } else if (typeLegemiddel.contains("vanedannende")){
                                //System.out.println("Vanedannende");
                                newLegemiddel = new Vanedannende(navnLegemiddel, pris, virkestoff, styrke);
                            }

                        }
                        legemiddelListe.leggTil(newLegemiddel);
                        System.out.println("La til " + newLegemiddel.toString());
                        acGen.linjeRom();
                    } catch (Exception e){
                        System.out.println("Feil format proev igjen"); //Fuck the user
                        acGen.linjeRom();
                    }
                    break;
                case 3: //Legg til lege
                    acGen.linjeTom();
                    acGen.asciiGenerator("Legg til lege");
                    System.out.println("Format: navn,kontrollid / 0 hvis vanlig lege");
                    System.out.print("Input: ");
                    String dataLege = strInput.nextLine().strip();
                    String[] splitDataLege = dataLege.split(",");
                    Lege newLege = null;
                    try{
                        String navnLege = splitDataLege[0];
                        String kontrollid = splitDataLege[1];
                        if (Integer.valueOf(kontrollid) > 0){
                            newLege = new Spesialist(navnLege, kontrollid);
                        } else {
                            newLege = new Lege(navnLege);
                        }
                        legeListe.leggTil(newLege);
                        System.out.println("La til " + newLege.toString());
                        acGen.linjeRom();
                    } catch (Exception e){
                        System.out.println("Feil format proev igjen"); //Fuck the user
                        acGen.linjeRom();
                    }
                    break;
                case 4: //Legg til resept
                    acGen.linjeTom();
                    acGen.asciiGenerator("Legg til resept");
                    System.out.println("Format: legemiddelNummer,legeNavn,pasientID,type,[reit]");
                    System.out.print("Input: ");
                    String dataResept = strInput.nextLine().strip();
                    String[] splitDataResept = dataResept.split(",");
                    Resept newResept = null;
                    Lege legePeker = null;
                    Legemiddel legemiddelPeker = null;
                    Pasient pasientPeker = null;
                    try{
                        int legemiddelNummer = Integer.valueOf(splitDataResept[0]);
                        String legeNavn = splitDataResept[1];
                        int pasientId = Integer.valueOf(splitDataResept[2]);
                        String typeResept = splitDataResept[3];
                        //System.out.println(legeNavn + " " + pasientId + " " + typeResept);
                        for (Lege lege: legeListe){
                            if (lege.hentNavn().contains(legeNavn)){
                                legePeker = lege;
                                break;
                            }
                        }
                        for (Legemiddel legemiddel : legemiddelListe){
                            if (legemiddel.hentId() == legemiddelNummer){
                                legemiddelPeker = legemiddel;
                                //System.out.println("Fant legemiddel" + counter);
                                break;
                            }
                        }
                        for (Pasient pasient : pasientListe){
                            if (pasient.hentId() == pasientId){
                                pasientPeker = pasient;
                                //System.out.println("Fant pasient" + counter);
                                break;
                            }
                        }

                        if (legemiddelPeker != null && legePeker != null && pasientPeker != null){
                            if (typeResept.contains("p")){
                                newResept = legePeker.skrivPResept(legemiddelPeker, pasientPeker);
                            } else {
                                int reit = Integer.valueOf(splitDataResept[4]);
                                if (typeResept.contains("blaa")){
                                    newResept = legePeker.skrivBlaaResept(legemiddelPeker, pasientPeker, reit);
                                } else if (typeResept.contains("militaer")){
                                    newResept = legePeker.skrivMilitaerResept(legemiddelPeker, pasientPeker, reit);
                                }else if (typeResept.contains("hvit")){
                                    newResept = legePeker.skrivHvitResept(legemiddelPeker, pasientPeker, reit);
                                }
                            }
                            if (newResept != null){
                                reseptListe.leggTil(newResept);
                                System.out.println("La til " + newResept.toString());
                                acGen.linjeRom();
                            } else {
                                System.out.println("Resept ble null, noe er feil"); //Fuck the user
                                acGen.linjeRom();
                            }
                        } else {
                            System.out.println("Feil format proev igjen"); //Fuck the user
                            acGen.linjeRom();
                        }
                    } catch (UlovligUtskrift e){
                        System.out.println(e);
                    } catch (Exception e){
                        System.out.println("Feil format proev igjen"); //Fuck the user
                        acGen.linjeRom();
                    }
                    break;
                case 8:
                    clear();
                    break;
                case 9: //meny
                    acGen.linjeTom();
                    acGen.asciiGenerator("Legesystem");
                    acGen.linjeRom();
                    System.out.println("Hovedside - 0");
                    System.out.println("Legg til Pasient - 1");
                    System.out.println("Legg til Legemiddel - 2");
                    System.out.println("Legg til Lege - 3");
                    System.out.println("Legg til Resept - 4");
                    System.out.println("Clear - 8");
                    System.out.println("Hjelp - 9");
                    acGen.linjeRom();
                    break;
                default:
                    acGen.linjeStrek();
                    System.out.println("Ikke gyldig input");
            }
        }
    }

    public void clear(){
        acGen.linjeTom();
        acGen.asciiGenerator("Clear");
        try{
            Thread.sleep(1000); //Real shit, I sleep
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        acGen.linjeTom();
        System.out.print(">");
    }

    public void mainMenu(){ //kommer naar programmet kjores for forste gang
        acGen.asciiGenerator("Feilmeldinger");
        acGen.linjeTom();
        acGen.asciiGenerator("Legesystem");
        menu();
        kjorTeller++;
    }

    public void menu(){ //Kommer naar programmet kjores for n+1te (n=0) gang
        acGen.linjeRom();
        System.out.println("Avslutt - 0");
        System.out.println("Skriv ut alt - 1");
        System.out.println("Legg til nytt objekt - 2");
        System.out.println("Bruk resept - 3");
        System.out.println("Skriv ut statistikk - 4");
        System.out.println("Eksporter til fil - 5");
        System.out.println("Clear - 8");
        System.out.println("Hjelp - 9");
        acGen.linjeRom();
    }

    public void skrivUtAlt(){
        acGen.asciiGenerator("Pasienter");
        for (Pasient pasient : this.pasientListe){
            System.out.println(pasient.toString());
        }
        acGen.asciiGenerator("Legemiddler");
        for (Legemiddel legemiddel : this.legemiddelListe){
            System.out.println(legemiddel.toString());
        }
        acGen.asciiGenerator("Leger");
        for (Lege lege : this.legeListe){
            System.out.println(lege.toString());
        }
        acGen.asciiGenerator("Resepter");
        //System.out.println(reseptListe.toString());
        for (Resept resept : this.reseptListe){
            System.out.println(resept.toString());
        }
        acGen.linjeStrek();
        System.out.print(">");
    }


    public void lesInnFraFil(String filnavn){ //Leser inn fra fil (filnavn)

        try{
            File target = new File(filnavn);
            Scanner lesFraFil = new Scanner(target);
            int fatFingerCounter = 0;
            int counter = 1;
            String readType = "";
            String data;
            while(lesFraFil.hasNextLine()){
                data = lesFraFil.nextLine();
                data = data.strip();
                //System.out.println(readType);
                if (data.contains("# Pasienter")){ //If prog finner x, alle data behandles som x
                    readType = "Pasient";
                } else if (data.contains("# Legemidler")){
                    readType = "Legemiddel";
                } else if (data.contains("# Leger")){
                    readType = "Lege";
                } else if (data.contains("# Resepter")){
                    readType = "Resept";
                }
                //System.out.println(data);
                //System.out.println(data.contains("#"));
                if (! data.contains("#")){ //Hvis data er kommentar blir den ignorert
                    if (readType == "Pasient"){
                        //Behandle data som pasient
                        //Behandle data som pasient
                        String[] splitData = data.split(",");
                        try{
                            String navnPasient = splitData[0];
                            String foedselsnummer = splitData[1];
                            Pasient newPasient = new Pasient(navnPasient,foedselsnummer);
                            pasientListe.leggTil(newPasient);
                        } catch (Exception e){
                            System.out.println(String.format("Line %d could not be interpreted and will be ignored", counter));
                            fatFingerCounter++;
                        }

                    } else if (readType == "Legemiddel"){

                        //Behandle data som legemiddel
                        String[] splitData = data.split(",");
                        Legemiddel newLegemiddel = null;
                        try{
                            String navnLegemiddel = splitData[0];
                            String typeLegemiddel = splitData[1];
                            double prisD = Double.valueOf(splitData[2]);
                            int pris = (int)prisD;
                            double virkestoff = Double.valueOf(splitData[3]);
                            if (typeLegemiddel.contains("vanlig")){
                                //System.out.println("Vanlig");
                                newLegemiddel = new Vanlig(navnLegemiddel, pris, virkestoff);
                            } else {
                                int styrke = Integer.valueOf(splitData[4]);
                                if (typeLegemiddel.contains("narkotisk")){
                                    //System.out.println("Narkotisk");
                                    newLegemiddel = new Narkotisk(navnLegemiddel, pris, virkestoff, styrke);
                                } else if (typeLegemiddel.contains("vanedannende")){
                                    //System.out.println("Vanedannende");
                                    newLegemiddel = new Vanedannende(navnLegemiddel, pris, virkestoff, styrke);
                                }

                            }
                            legemiddelListe.leggTil(newLegemiddel);
                        } catch (Exception e){
                            System.out.println(String.format("Line %d could not be interpreted and will be ignored", counter));
                            fatFingerCounter++;
                        }

                    } else if (readType == "Lege"){

                        //Behandle data som lege
                        String[] splitData = data.split(",");
                        Lege newLege = null;
                        try{
                            String navnLege = splitData[0];
                            String kontrollid = splitData[1];
                            if (Integer.valueOf(kontrollid) > 0){
                                newLege = new Spesialist(navnLege, kontrollid);
                            } else {
                                newLege = new Lege(navnLege);
                            }
                            legeListe.leggTil(newLege);
                        } catch (Exception e){
                            System.out.println(String.format("Line %d could not be interpreted and will be ignored", counter));
                            fatFingerCounter++;
                        }

                    } else if (readType == "Resept"){

                        //Behandle data som resept

                        String[] splitData = data.split(",");
                        Resept newResept = null;
                        Lege legePeker = null;
                        Legemiddel legemiddelPeker = null;
                        Pasient pasientPeker = null;
                        try{
                            int legemiddelNummer = Integer.valueOf(splitData[0]);
                            String legeNavn = splitData[1];
                            int pasientId = Integer.valueOf(splitData[2]);
                            String typeResept = splitData[3];
                            //System.out.println(legeNavn + " " + pasientId + " " + typeResept);
                            for (Lege lege: legeListe){
                                if (lege.hentNavn().contains(legeNavn)){
                                    legePeker = lege;
                                    break;
                                }
                            }
                            for (Legemiddel legemiddel : legemiddelListe){
                                if (legemiddel.hentId() == legemiddelNummer){
                                    legemiddelPeker = legemiddel;
                                    //System.out.println("Fant legemiddel" + counter);
                                    break;
                                }
                            }
                            for (Pasient pasient : pasientListe){
                                if (pasient.hentId() == pasientId){
                                    pasientPeker = pasient;
                                    //System.out.println("Fant pasient" + counter);
                                    break;
                                }
                            }

                            if (legemiddelPeker != null && legePeker != null && pasientPeker != null){
                                if (typeResept.contains("p")){
                                    newResept = legePeker.skrivPResept(legemiddelPeker, pasientPeker);
                                } else {
                                    int reit = Integer.valueOf(splitData[4]);
                                    if (typeResept.contains("blaa")){
                                        newResept = legePeker.skrivBlaaResept(legemiddelPeker, pasientPeker, reit);
                                    } else if (typeResept.contains("militaer")){
                                        newResept = legePeker.skrivMilitaerResept(legemiddelPeker, pasientPeker, reit);
                                    }else if (typeResept.contains("hvit")){
                                        newResept = legePeker.skrivHvitResept(legemiddelPeker, pasientPeker, reit);
                                    }
                                }
                                reseptListe.leggTil(newResept);
                            } else {
                                System.out.println(String.format("Line %d could not be interpreted and will be ignored", counter));
                                fatFingerCounter++; //Hvis den som lagde som lagde inputfilen hadde feite fingre og skrev feil. fatFingerdatFinger
                            }
                        } catch (UlovligUtskrift e){
                            System.out.println(e);
                        } catch (Exception e){
                            System.out.println(String.format("Line %d could not be interpreted and will be ignored", counter));
                            fatFingerCounter++;
                        }
                    }

                }
                counter++; //counter++
            }
            System.out.println(String.format("Could not read %d lines of data out of %d lines of data", fatFingerCounter, counter));

        } catch (FileNotFoundException e){
            System.out.println("Fant ikke fil");
            e.printStackTrace();
        }

    }
}
