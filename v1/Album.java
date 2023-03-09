package Klasse_12.AEP.Eichner.SWProjekt.v1;

import java.io.Serializable;
import java.util.LinkedList;

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
}
