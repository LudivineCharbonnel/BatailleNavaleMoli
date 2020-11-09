package greta.java;

public enum BateauType {

    PORTEAVION, CROISEUR, CONTRE_CROISEUR, SOUS_MARIN, TORPILLEUR;


    public int nbCase() {

        switch (this) {

            case PORTEAVION:
                return 5;
            case CROISEUR:
                return 4;
            case CONTRE_CROISEUR:
                return 3;
            case SOUS_MARIN:
                return 3;
            case TORPILLEUR:
                return 2;
            default:
                return 0;
        }

    }


}


