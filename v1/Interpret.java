package Klasse_12.AEP.Eichner.SWProjekt.v1;

import java.io.Serializable;

public class Interpret implements Serializable{
    private String vname;
    private String nname;
    private int a_lieder = 0;
    private int a_album = 0;
    private int id;

    // Konstruktor
    public Interpret(String vname, String nname, int id){
        this.vname = vname;
        this.nname = nname;
        this.id = id;
    }

    // Rückgabe der ID des Interpreten
    public int getID(){
        return id;
    }

    // Rückgabe der ID des Albums
    public String getName(){
        return vname + " " + nname;
    }

    // Rückgabe der Anzahl der Songs des Interpreten
    public int getAnzahlSongs(){
        return a_lieder;
    }

    // Rückgabe der Anzahl der Alben des Interpreten
    public int getAnzahlAlben(){
        return a_album;
    }

    // Zähler für die Anzahl der Songs, ausgelöst bei jedem hinzufügen eines Songs
    public void addSong(){
        this.a_lieder++;
    }

    // Zähler für die Anzahl der Songs, ausgelöst bei jedem hinzufügen eines Songs
    public void addAlbum(){
        this.a_album++;
    }
}
