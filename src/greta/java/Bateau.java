package greta.java;


import java.util.ArrayList;
import java.util.List;

public class Bateau {

    private BateauType type;
    private List<PositionBateau> position = new ArrayList<>();
    private String etatBateau = "OK";
    public static boolean touche;


    public String getEtatBateau() {
        return etatBateau;
    }

    public void setEtatBateau(String etatBateau) {
        this.etatBateau = etatBateau;
    }

    public BateauType getType() {
        return type;
    }

    public boolean traverse(List<Position> positionsDuBateauAPlacer) {

        for (PositionBateau listePosition : position) {

            for (Position positionEnCours : positionsDuBateauAPlacer) {

                if (positionEnCours.getX() == listePosition.getPosition().getX() && positionEnCours.getY() == listePosition.getPosition().getY()) {

                    return true;
                }

            }
        }
        return false;
    }

    public void setType(BateauType type) {

        this.type = type;


    }

    public void setPositions(List<Position> positions) {

        for (Position positionBateau : positions) {
            PositionBateau convertion = new PositionBateau();

            convertion.setPosition(positionBateau);
            position.add(convertion);

        }


    }

    public void nombreDesPositionsDunBateauTouche() {

        int compteurCaseTouche = 0;

        for (PositionBateau chaquePositionBateau : position) {

            if (chaquePositionBateau.getPosition().getCasePosition()) {
                compteurCaseTouche += 1;
            }

        }

        if (compteurCaseTouche == type.nbCase()) {

            System.out.println(getType().name() + " COULE");
            setEtatBateau("COULE");

        }


    }


    public void tirSurUnBateau(Position pos) {


        for (PositionBateau listePosition : position) {

            if (listePosition.getPosition().getX() == pos.getX() && listePosition.getPosition().getY() == pos.getY()) {
                System.out.println("TOUCHE");
                listePosition.getPosition().setCasePosition(true);
                touche = true;

            }

        }


    }


}