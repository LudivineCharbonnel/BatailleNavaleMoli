package fr.greta.java.bataillenavale;


public class PositionBateau {

    private Position position;

    private String etatBateau = "OK";

    public String getEtatBateau() {
        return etatBateau;
    }


    public void setEtatBateau(String etatBateau) {

        this.etatBateau = etatBateau;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
