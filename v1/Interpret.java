package Klasse_12.AEP.Eichner.SWProjekt.v1;

import java.io.Serializable;

public class Interpret implements Serializable{
    private String vname;
    private String nname;
    private int a_lieder = 0;
    private int a_album = 0;
    private int id;

    public Interpret(String vname, String nname, int id){
        this.vname = vname;
        this.nname = nname;
        this.id = id;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return vname + " " + nname;
    }

    public int getAnzahlSongs(){
        return a_lieder;
    }

    public int getAnzahlAlben(){
        return a_album;
    }

    public void addSong(){
        this.a_lieder++;
    }

    public void addAlbum(){
        this.a_album++;
    }
}
