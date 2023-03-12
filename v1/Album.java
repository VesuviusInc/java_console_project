package Klasse_12.AEP.Eichner.SWProjekt.v1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.ViewportLayout;

public class Album implements Serializable{
    private String name;
    private int id;
    private Interpret interpret;
    private LinkedList<Song> songlist = new LinkedList<>();

    public Album(String name, Interpret interpret, int id){
        this.name = name;
        this.id = id;
        this.interpret = interpret;
    }

    public int getID(){
        return id;
    }

    public void getNameAndID(){
        System.out.println(id + ") " + name);
    }

    public String getName(){
        return name;
    }

    public Interpret getInterpret(){
        return this.interpret;
    }

    public void addSong(Song song){
        songlist.add(song);
    }

    public void getSongList(){
        int i = 1;
        for (Song song: songlist){
            System.out.println("Song " + i + ": " + song.getName());
            System.out.println("Interpret: " + song.getInterpret().getName());
            i++;
        }
    }

    public int getAnzahlSongs(){
        int i = 0;
        for (Song song: songlist){
            i++;
        }
        return i;
    }

    public void playAlbum(){
        Scanner ein = new Scanner(System.in);
        boolean runner = true;
        int anzahl = this.getAnzahlSongs();
        int s_id = 0;
        int return_value = 0;
        int cli_num;
        do{
            System.out.println("\n........Song................"); 
            System.out.print(songlist.get(s_id).getName() + " (" + songlist.get(s_id).getLaenge() + ")");
            System.out.println("\n............................"); 

            System.out.println("\n------------------------------"); 
            System.out.println("Nächster Song: 1");
            System.out.println("Vorheriger Song: 2");
            System.out.println("Anderes Album(Abbruch): 3");
            System.out.println("\n------------------------------"); 
            System.out.print("\nAuswahl: "); 

            cli_num = ein.nextInt();
            ein.nextLine();
            switch (cli_num) {
                case 1:
                    if(s_id == anzahl-1){
                        s_id = 0;
                    }
                    else{
                        s_id++;
                    }
                    break;
                case 2:
                    if(s_id == 0){
                        s_id = anzahl-1;
                    }
                    else{
                        s_id--;
                    }
                    break;
                case 3:
                    runner = false;
                    break;
                default:
                    break;
            }
        }while(runner);
    }
}
