package Klasse_12.AEP.Eichner.SWProjekt.v1;

public class Player {
    Album album;

    public Player(Album alb){
        this.album = alb;
    }

    public void playAlbum(){
        int anzahl = this.album.getAnzahlSongs();
    }
}
