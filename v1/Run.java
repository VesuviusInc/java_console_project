package Klasse_12.AEP.Eichner.SWProjekt.v1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int cli_num = 111;
        int id_interpret = 1;
        int id_album = 1;

        Scanner ein = new Scanner(System.in);
        String file = "/Users/michaelhosl/Desktop/Klasse_12/AEP/Eichner/SWProjekt/v1/data.txt";

        ArrayList<Interpret> interpretList = new ArrayList<>();
        ArrayList<Album> albumList = new ArrayList<>();

        do{
            System.out.println("\n------------------------------"); 
            System.out.println("Neuen Interpret hinzufügen: 1");
            System.out.println("Alle Informationen eines Interpretens anzeigen: 2");
            System.out.println("Alle Interpreten anzeigen: 3");
            System.out.println("Album hinzufügen: 4");
            System.out.println("Alle Alben ausgeben: 5");
            System.out.println("Song einem Album hinzufügen: 6");
            System.out.println("Alle Songs eines Albums ausgeben: 7");
            System.out.println("Player starten: 8");
            System.out.println("Alle Daten speichern: 9");
            System.out.println("Daten aus dem Speicher lesen: 10");
            System.out.println("Abbruch: 0");
            System.out.println("------------------------------"); 
            System.out.print("\nAuswahl: "); 
            cli_num = 111;
            try{
                cli_num = ein.nextInt();
            }catch(InputMismatchException e){
                if( cli_num != 111){
                    System.out.println("\nBitte gültige ID eingeben!");
                }
            }
            catch(NoSuchElementException e){}
            ein.nextLine();

            switch (cli_num) {
                case 1:
                    //Eingabe der Daten für  den Interpreten
                    System.out.print("\nVorname des Interpreten: ");
                    String vname = ein.nextLine();
                    System.out.print("Nachname des Interpreten: ");
                    String nname = ein.nextLine();
                    interpretList.add(new Interpret(vname, nname, id_interpret));
                    id_interpret++;
                    break;

                // Ausgabe aller Inforamtionen eines bestimmten Interpreten
                case 2:
                    Boolean help = false;
                    // Ausgabe aller Interpreten
                    System.out.println("ID's und Namen der Interpreten: ");
                    for(Interpret interpret : interpretList){
                        System.out.println(interpret.getID() + ") " + interpret.getName());
                        help = true;
                    }
                    // Überprüfung, ob Interpreten überhaupt existieren
                    if(!help){
                        System.out.println("Bitte erst Interpreten erstellen!");
                    }
                    // Auswahl des Interpreten
                    else{
                        System.out.print("\nBitte ID des Interpreten angeben (Abbruch: 0): ");
                    }
                    int id2 = 0;
                    while(help){
                        try{
                            id2 = ein.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("\nBitte gültige ID eingeben!");
                            help = false;
                        }
                        // Ausgabe aller Informationen des usgewählten Interpreten
                        ein.nextLine();
                        for(Interpret interpret : interpretList){
                            if(interpret.getID() == id2){
                                System.out.println("\n" + interpret.getName() + "\nAnzahl Songs: " + interpret.getAnzahlSongs() + "\nAnzahl Alben: " + interpret.getAnzahlAlben());
                                help = false;
                            }
                        }
                        // Ausgabe, falls für die eingegebene ID kein Interpret existiert
                        if(help && id2 != 0){
                            System.out.print("\nBitte existierende ID des Interpreten angeben (Abbruch: 0): ");
                        }
                        // Abruch der Auswahl, falls 0 eingegeben wird
                        if(id2 == 0){
                            help = false;
                        }
                    }
                    break;

                // Ausgabe aller Interpreten
                case 3:
                    System.out.println("");
                    for(Interpret interpret : interpretList){
                        System.out.println(interpret.getName());
                    }
                    System.out.println("");
                    break;
                
                // Hinzufügen eines Albums
                case 4:
                    // Eingabe der Informationen für das Album
                    System.out.print("\nName des Albums: ");
                    String name = ein.nextLine();
                    Boolean help21 = false;

                    // Ausgabe aller Interpreten
                    System.out.println("\nID's und Namen der Interpreten: ");
                    for(Interpret interpret : interpretList){
                        System.out.println(interpret.getID() + ") " + interpret.getName());
                        help21 = true;
                    }
                    // Ausgabe, falls kein Interpret existiert
                    if(!help21){
                        System.out.println("Bitte erst einen Interpreten erstellen!");
                        break;
                    }
                    // Auswahl des Interpreten mit der ID
                    Interpret interpretAuswahl = null;
                    Boolean help2 = false;
                    System.out.print("\nBitte ID des Interpreten angeben: ");
                    int id4 = 0;
                    do{
                        try{
                            id4 = ein.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("\nBitte gültige ID eingeben!");
                        }
                        ein.nextLine();
                        for(Interpret interpret : interpretList){
                            if(interpret.getID() == id4){
                                interpretAuswahl = interpret;
                                help2 = true;
                            }
                        }
                        // Überprüfung, ob Interpret mit der gegebenen ID existiert
                        if(!help2 && id4 != 0){
                            System.out.print("Bitte neue ID eingeben oder Abbruch mit 0: ");
                        }
                        if(help2){
                            albumList.add(new Album(name, interpretAuswahl, id_album));
                            id_album++;
                            interpretAuswahl.addAlbum();
                            help2 = true;
                        }
                        // Abbruch, falls 0 eingegeben wird
                        if(id4 == 0){
                            help2 = true;
                        }
                    }
                    while(!help2);
                    break;

                // Alle Alben ausgeben
                case 5:
                    System.out.println("");
                    for(Album album : albumList){
                        System.out.println(album.getName());
                    }
                    System.out.println("");
                    break;

                // Song einem Album hinzufügen
                case 6:
                    Boolean help3 = false;
                    Boolean help4 = true;
                    // Ausgabe aller Alben
                    System.out.println("\nID's und Namen der Alben: ");
                    for(Album album : albumList){
                        album.getNameAndID();
                        help3 = true;
                    }
                    // Ausgabe, falls kein Album existiert
                    if(!help3){
                        System.out.println("Bitte ersten ein Album erstellen!");
                        System.out.println("");
                    }
                    else{
                        // Eingabe der ID des Albums, dem man einen Song hinzufügen möchte
                        System.out.println("");
                        System.out.print("Bitte ID des Albums angeben (Abbruch: 0): ");
                        
                        Album albumAuswahl1;
                        Interpret interpretAuswahl2 = null;
                        float laengeSong = 0;
                        int id = 0;
                        while(help3){
                            try{
                                id = ein.nextInt();
                            }
                            catch(InputMismatchException e){
                                System.out.println("\nBitte gültige ID eingeben!");
                                help4 = false;
                                help3 = false;
                            }
                            ein.nextLine();
                            for(Album album : albumList){
                                if(album.getID() == id){
                                    // Informationen des Songs eingeben
                                    albumAuswahl1 = album;
                                    System.out.println("\nBitte Name des Songs: ");
                                    String nameSong = ein.nextLine();
                                    System.out.println("\nBitte Laenge des Songs: ");
                                    try{
                                        laengeSong = ein.nextFloat();
                                    }
                                    catch(InputMismatchException e){
                                        System.out.println("\nBitte gültige Länge eingeben!");
                                        help4 = false;
                                        help3 = false;
                                        break;
                                    }
                                    // Ausgabe aller Interpreten
                                    if(help4){
                                        System.out.println("\n\nID's und Namen der Interpreten: ");
                                        for(Interpret interpret : interpretList){
                                            System.out.println(interpret.getID() + ") " + interpret.getName());
                                        }
                                        // Auswahl des Interpreten
                                        System.out.print("\nBitte ID des Interpreten angeben: ");
                                    }
                                    int idInterpret = -1;
                                    while(help4 && idInterpret != 0){
                                        try{
                                            idInterpret = ein.nextInt();
                                        }catch(InputMismatchException e){
                                            System.out.println("\nBitte gültige ID eingeben!");
                                            help4 = false;
                                            help3 = false;
                                        }
                                        ein.nextLine();
                                        for(Interpret interpret : interpretList){
                                            if(interpret.getID() == idInterpret){
                                                interpretAuswahl2 = interpret;
                                            }
                                        }
                                        // Ausgabe, falls kein Interpret mit der angegebenen ID existiert
                                        if(interpretAuswahl2 == null){
                                            if(help4 && idInterpret != 0){
                                                System.out.print("Bitte neue ID eingeben oder Abbruch mit 0: ");
                                            }
                                        }
                                        else{
                                            albumAuswahl1.addSong(new Song(nameSong, laengeSong, interpretAuswahl2));
                                            help4 = false;
                                            help3 = false;
                                        }
                                        if(idInterpret == 0){
                                            help4 = false;
                                            help3= false;
                                        }
                                    }
                                }
                                // Ausgabe, falls kein Album mit der übergebenen ID existiert
                                else{
                                    if(help3 && id != 0){
                                        System.out.print("Bitte vorhandene Album ID eingeben! (Abbruch: 0): ");
                                    }
                                }
                                if(id == 0){
                                    help3 = false;
                                }
                            }
                        }
                    }
                    break;

                // Ausgabe aller Songs eines bestimmten Albums
                case 7:
                    // Ausgabe aller Alben
                    Boolean help5 = false;
                    Boolean help51 = false;
                    System.out.println("\nID's und Namen der Alben: ");
                    for(Album album : albumList){
                        album.getNameAndID();
                        help5 = true;
                    }
                    // Ausgabe, falls kein Album existiert
                    if(!help5){
                        System.out.println("Bitte ersten ein Album erstellen!");
                        System.out.println("");
                    }
                    // Auswahl des Albums per ID
                    else{
                        System.out.println("");
                        System.out.print("Bitte ID des Albums angeben (Abbruch: 0): ");
                        int id = 0;
                        do{
                            try{
                                id = ein.nextInt();
                            }catch(InputMismatchException e){
                                System.out.println("\nBitte gültige ID eingeben!");
                            }
                            // Ausgabe aller Songs eines Albums
                            ein.nextLine();
                            if(id != 0){
                                for(Album album : albumList){
                                    if(id == album.getID()){
                                        System.out.println("\nSongs des Albums " + album.getName() + ": ");
                                        album.getSongList();
                                        help51 = true;
                                    }
                                }
                            }
                            // Ausgabe, falls kein Album für die übergebene ID existiert
                            if(!help51 && id != 0){
                                System.out.print("Bitte existierende id des Albums eingeben (Abbruch: 0): ");
                            }
                            // Abbruch, falls 0 eingegeben wird
                            if(id == 0){
                                help51 = true;
                            }
                        }while(!help51);
                    }
                    break;
                // Ein bestimmtes Album abspielen
                case 8:
                    Boolean help81 = false;
                    do{
                        // Ausgabe aller Alben
                        Boolean help8 = false;
                        Boolean help82 = false;
                        System.out.println("\nID's und Namen der Alben: ");
                        int id = 0;
                        for(Album album : albumList){
                            album.getNameAndID();
                            help8 = true;
                        }
                        // Ausgabe, falls kein Album existiert
                        if(!help8){
                            System.out.println("Bitte ersten ein Album erstellen!");
                            System.out.println("");
                        }
                        // Auswahl des Albums per ID
                        else{
                            System.out.println("");
                            System.out.print("Bitte ID des Albums angeben (Abbruch: 0): ");
                            try{
                                id = ein.nextInt();
                            }catch(InputMismatchException e){
                                System.out.println("\nBitte gültige ID eingeben!");
                            }
                            catch(NoSuchElementException e){}
                            try {
                                ein.nextLine();
                            } catch (Exception e) {
                                // TODO: handle exception
                            }

                            Album albumAuswahl;
                            do{
                                if(id != 0){
                                    // Player des eingegebenen Albums wird gestartet
                                    for(Album album : albumList){
                                        if(album.getID() == id){
                                            albumAuswahl = album;
                                            if(albumAuswahl.getAnzahlSongs() == 0){
                                                System.out.println("\nBitte erst Songs für das Album erstellen!");
                                                help81 = false;
                                                help82 = true;
                                                break;
                                            }
                                            boolean runner = true;
                                            int anzahl = albumAuswahl.getAnzahlSongs();
                                            int s_id = 0;
                                            int cli_num1 = 0;
                                            do{
                                                System.out.println("\n........Song................"); 
                                                System.out.print(albumAuswahl.getSongListArray().get(s_id).getName() + " (" + albumAuswahl.getSongListArray().get(s_id).getLaenge() + ")");
                                                System.out.println("\n............................"); 

                                                System.out.println("\n------------------------------"); 
                                                System.out.println("Nächster Song: 1");
                                                System.out.println("Vorheriger Song: 2");
                                                System.out.println("Anderes Album(Abbruch): 3");
                                                System.out.println("\n------------------------------"); 
                                                System.out.print("\nAuswahl: "); 

                                                try{
                                                    cli_num1 = ein.nextInt();
                                                    ein.nextLine();
                                                }catch(InputMismatchException e){
                                                    System.out.println("\nBitte gültige ID eingeben!");
                                                    runner= false;
                                                }
                                                switch (cli_num1) {
                                                    // Nächster Song aus der Liste wird abgespeilt
                                                    case 1:
                                                        if(s_id == anzahl-1){
                                                            s_id = 0;
                                                        }
                                                        else{
                                                            s_id++;
                                                        }
                                                        break;
                                                    
                                                    // Vorheriger Song der Liste wird abgespielt
                                                    case 2:
                                                        if(s_id == 0){
                                                            s_id = anzahl-1;
                                                        }
                                                        else{
                                                            s_id--;
                                                        }
                                                        break;
                                                    
                                                    // Abbruch oder Auswahl eines anderen Albums
                                                    case 3:
                                                        runner = false;
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }while(runner);
                                            help81 = true;
                                            help82 = true;
                                        }
                                    }
                                }
                                // Abbruch, falls 0 eingegeben wird
                                else{
                                    if(id == 0){
                                        help81 = false;
                                        help82 = true;
                                    }
                                }
                                // Ausgabe, falls kein ALbum mit der übergebenen ID exisitiert
                                if(!help82){
                                    System.out.println("");
                                    System.out.print("Bitte existierende ID des Albums angeben (Abbruch: 0): ");
                                    try{
                                        id = ein.nextInt();
                                    }catch(InputMismatchException e){
                                        System.out.println("\nBitte gültige ID eingeben!");
                                    }
                                    ein.nextLine();
                                }
                            }while(!help82);
                        }
                    }while(help81);
                    break;
                // Speichern der Daten in den Speicher
                case 9:
                    ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream(file));
                    ser.writeObject(albumList);
                    ser.writeObject(interpretList);
                    ser.close();
                    break;
                // Auslesen der Daten aus dem Speicher
                case 10:
                    ObjectInputStream deser = new ObjectInputStream(new FileInputStream(file));
                    albumList = (ArrayList<Album>) deser.readObject();
                    interpretList = (ArrayList<Interpret>) deser.readObject();
                    deser.close();
                    break;
                default:
                    break;
            }
        }
        while(cli_num != 0);
        ein.close();
    }
}
