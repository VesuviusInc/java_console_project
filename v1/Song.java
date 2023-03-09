package Klasse_12.AEP.Eichner.SWProjekt.v1;

import java.io.Serializable;

public class Song implements Serializable{
    private String titel;
    private float laenge;
    private Interpret interpret;

    public Song(String titel, float laenge, Interpret interpret){
        this.titel = titel;
        this.laenge = laenge;
        this.interpret = interpret;
        this.interpret.addSong();
    }

    public String getName(){
        return this.titel;
    }

    public float getLaenge(){
        return this.laenge;
    }

    public Interpret getInterpret(){
        return this.interpret;
    }
}
