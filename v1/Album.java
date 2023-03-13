package Klasse_12.AEP.Eichner.SWProjekt.v1;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.ViewportLayout;

public class Album implements Serializable{
    private String name;
    private int id;
    private Interpret interpret;
    private LinkedList<Song> songlist = new LinkedList<>();

    // Konstruktor
    public Album(String name, Interpret interpret, int id){
        this.name = name;
        this.id = id;
        this.interpret = interpret;
    }

    // Rückgabe der ID des Albums
    public int getID(){
        return id;
    }

    // Print des Namen und der ID des Albums
    public void getNameAndID(){
        System.out.println(id + ") " + name);
    }

    // Rückgabe des Namen des Albums
    public String getName(){
        return name;
    }

    // Rückgabe des Interpreten des Albums
    public Interpret getInterpret(){
        return this.interpret;
    }

    // Hinzufügen eines übergebenen Songs an das Album
    public void addSong(Song song){
        songlist.add(song);
    }

    // Print aller Songs eines Albums
    public void getSongList(){
        int i = 1;
        for (Song song: songlist){
            System.out.println("Song " + i + ": " + song.getName() + " (" + song.getLaenge() + ")");
            System.out.println("Interpret: " + song.getInterpret().getName());
            i++;
        }
    }

    // Rückgabe der Anzahl des Songs eines Albums
    public int getAnzahlSongs(){
        int i = 0;
        for (Song song: songlist){
            i++;
        }
        return i;
    }

    // Rückgabe der Songlist
    public LinkedList<Song> getSongListArray(){
        return songlist;
    }
}
