package Klasse_12.AEP.Eichner.SWProjekt.v1;

import java.io.Serializable;

public class Song implements Serializable{
    private String titel;
    private float laenge;
    private Interpret interpret;

    // Konstruktor
    public Song(String titel, float laenge, Interpret interpret){
        this.titel = titel;
        this.laenge = laenge;
        this.interpret = interpret;
        this.interpret.addSong();
    }

    // Rückgabe des Namen des Songs
    public String getName(){
        return this.titel;
    }

    // Rückgabe der Länge des Songs
    public float getLaenge(){
        return this.laenge;
    }
    
    // Rückgabe des Interpreten des Songs
    public Interpret getInterpret(){
        return this.interpret;
    }
}
