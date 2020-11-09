package fr.greta.java.bataillenavale;

import java.util.ArrayList;
import java.util.List;

public class ConverteurPosition {


    public List<Position> convertir(Position positionAvant, Position positionArriere) throws ConverteurException {

        if (positionAvant.getX() == positionArriere.getX()) {

            return convertirVertical(positionAvant, positionArriere);
        } else if (positionAvant.getY() == positionArriere.getY()) {

            return convertirHorizontal(positionAvant, positionArriere);
        }


        throw new ConverteurException();
    }

    private List<Position> convertirVertical(Position positionAvant, Position positionArriere) {

        List<Position> list = new ArrayList<>();

        int minimum = Math.min(positionAvant.getY(), positionArriere.getY());
        int max = Math.max(positionAvant.getY(), positionArriere.getY());

        for (int i = minimum; i <= max; i++) {

            Position p = new Position();

            p.setX(positionAvant.getX());
            p.setY(i);

            list.add(p);

        }


        return list;

    }

    private List<Position> convertirHorizontal(Position positionAvant, Position positionArriere) {

        List<Position> list = new ArrayList<>();

        int minimum = Math.min(positionAvant.getX(), positionArriere.getX());
        int max = Math.max(positionAvant.getX(), positionArriere.getX());

        for (int i = minimum; i <= max; i++) {

            Position p = new Position();

            p.setY(positionAvant.getY());
            p.setX(i);

            list.add(p);

        }


        return list;
    }


}
