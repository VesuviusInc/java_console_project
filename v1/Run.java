package Klasse_12.AEP.Eichner.SWProjekt.v1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int cli_num = 0;
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
            System.out.println("Album abspielen: 8");
            System.out.println("Alle Daten speichern: 9");
            System.out.println("Daten aus dem Speicher lesen: 10");
            System.out.println("Abbruch: 0");
            System.out.println("------------------------------"); 
            System.out.print("\nAuswahl: "); 

            cli_num = ein.nextInt();
            ein.nextLine();
            switch (cli_num) {
                case 1:
                    System.out.print("\nVorname des Interpreten: ");
                    String vname = ein.nextLine();
                    System.out.print("Nachname des Interpreten: ");
                    String nname = ein.nextLine();
                    interpretList.add(new Interpret(vname, nname, id_interpret));
                    id_interpret++;
                    break;
                case 2:
                    Boolean help = false;
                    System.out.println("ID's und Namen der Interpreten: ");
                    for(Interpret interpret : interpretList){
                        System.out.println(interpret.getID() + ") " + interpret.getName());
                        help = true;
                    }
                    if(!help){
                        System.out.println("Bitte erst Interpreten erstellen!");
                    }
                    else{
                        System.out.print("\nBitte ID des Interpreten angeben (Abbruch: 0): ");
                    }
                    
                    while(help){
                        int id = ein.nextInt();
                        ein.nextLine();
                        for(Interpret interpret : interpretList){
                            if(interpret.getID() == id){
                                System.out.println(interpret.getName() + "\nAnzahl Songs: " + interpret.getAnzahlSongs() + "\nAnzahl Alben: " + interpret.getAnzahlAlben());
                                help = false;
                            }
                            else{
                                System.out.println("--ID nicht gefunden!--");
                                System.out.print("Bitte erneut ID des Interpreten angeben (Abbruch: 0): ");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("");
                    for(Interpret interpret : interpretList){
                        System.out.println(interpret.getName());
                    }
                    System.out.println("");
                    break;
                case 4:
                    System.out.print("\nName des Albums: ");
                    String name = ein.nextLine();

                    System.out.println("\nID's und Namen der Interpreten: ");
                    for(Interpret interpret : interpretList){
                        System.out.println(interpret.getID() + ") " + interpret.getName());
                    }

                    Interpret interpretAuswahl = null;
                    Boolean help2 = true;

                    do{
                        System.out.print("\nBitte ID des Interpreten angeben: ");
                        int id = ein.nextInt();
                        ein.nextLine();
                        for(Interpret interpret : interpretList){
                            if(interpret.getID() == id){
                                interpretAuswahl = interpret;
                            }
                        }
                        if(interpretAuswahl == null){
                            System.out.print("Bitte neue ID eingeben oder Abbruch mit 0: ");
                            id = ein.nextInt();
                            ein.nextLine();
                            if(id == 0){
                                help2 = false;
                            }
                        }
                        else{
                            albumList.add(new Album(name, interpretAuswahl, id_album));
                            id_album++;
                            interpretAuswahl.addAlbum();
                            help2 = false;
                        }
                    }
                    while(help2);
                    break;
                case 5:
                    System.out.println("");
                    for(Album album : albumList){
                        System.out.println(album.getName());
                    }
                    System.out.println("");
                    break;
                case 6:
                    Boolean help3 = false;
                    Boolean help4 = true;
                    System.out.println("\nID's und Namen der Alben: ");
                    for(Album album : albumList){
                        album.getNameAndID();
                        help3 = true;
                    }
                    if(!help3){
                        System.out.println("Bitte ersten ein Album erstellen!");
                        System.out.println("");
                    }
                    else{
                        System.out.println("");
                        System.out.print("Bitte ID des Albums angeben (Abbruch: 0): ");
                        int id = ein.nextInt();
                        ein.nextLine();
                        Album albumAuswahl;
                        Interpret interpretAuswahl2 = null;
                        while(help3 && id != 0){
                            for(Album album : albumList){
                                if(album.getID() == id){
                                    albumAuswahl = album;
                                    System.out.println("\nBitte Name des Songs: ");
                                    String nameSong = ein.nextLine();
                                    System.out.println("\nBitte Laenge des Songs: ");
                                    float laengeSong = ein.nextFloat();
                                    System.out.println("\n\nID's und Namen der Interpreten: ");
                                    for(Interpret interpret : interpretList){
                                        System.out.println(interpret.getID() + ") " + interpret.getName());
                                    }
                                    do{
                                        System.out.print("\nBitte ID des Interpreten angeben: ");
                                        int idInterpret = ein.nextInt();
                                        ein.nextLine();
                                        for(Interpret interpret : interpretList){
                                            if(interpret.getID() == idInterpret){
                                                interpretAuswahl2 = interpret;
                                            }
                                        }
                                        if(interpretAuswahl2 == null){
                                            System.out.print("Bitte neue ID eingeben oder Abbruch mit 0: ");
                                            id = ein.nextInt();
                                            ein.nextLine();
                                            if(id == 0){
                                                help4 = false;
                                            }
                                        }
                                        else{
                                            albumAuswahl.addSong(new Song(nameSong, laengeSong, interpretAuswahl2));
                                            interpretAuswahl2.addSong();
                                            help4 = false;
                                            help3 = false;
                                        }
                                    }
                                    while(help4);
                                }
                            }
                        }

                    }
                    break;    
                case 7:
                    Boolean help5 = false;
                    System.out.println("\nID's und Namen der Alben: ");
                    for(Album album : albumList){
                        album.getNameAndID();
                        help5 = true;
                    }
                    if(!help5){
                        System.out.println("Bitte ersten ein Album erstellen!");
                        System.out.println("");
                    }
                    else{
                        System.out.println("");
                        System.out.print("Bitte ID des Albums angeben (Abbruch: 0): ");
                        int id = ein.nextInt();
                        ein.nextLine();
                        if(id != 0){
                            for(Album album : albumList){
                                album.getSongList();
                            }
                        }
                    }
                    break;
                case 8:
                    Boolean help8 = false;
                    Boolean help81 = false;
                    System.out.println("\nID's und Namen der Alben: ");
                    for(Album album : albumList){
                        album.getNameAndID();
                        help5 = true;
                    }
                    if(!help8){
                        System.out.println("Bitte ersten ein Album erstellen!");
                        System.out.println("");
                    }
                    else{
                        System.out.println("");
                        System.out.print("Bitte ID des Albums angeben (Abbruch: 0): ");
                        int id = ein.nextInt();
                        ein.nextLine();
                        while(id != 0){
                            Album albumAuswahl;
                            if(id != 0){
                                for(Album album : albumList){
                                    if(album.getID() == id){
                                        albumAuswahl = album;
                                        help81 = true;
                                    }
                                }
                                if(help81){

                                }
                            }
                        }
                    }
                    break;
                case 9:
                    ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream(file));
                    ser.writeObject(albumList);
                    ser.writeObject(interpretList);
                    ser.close();
                    break;
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
