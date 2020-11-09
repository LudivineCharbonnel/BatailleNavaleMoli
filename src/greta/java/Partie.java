package greta.java;


import java.util.ArrayList;
import java.util.List;


public class Partie {

    private Joueur IA;
    private Joueur joueur1;
    private Joueur joueur2;
    private ConverteurPosition converteur = new ConverteurPosition();
    private List<Bateau> armadaJoueur1 = new ArrayList<>();
    private List<Bateau> armadaJoueur2 = new ArrayList<>();


    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }



    public void placer(Joueur joueur, BateauType type, Position positionAvant, Position positionArriere) throws PlacerBateauException {
        try {

            if (!estDansLaGrille(positionAvant) || !estDansLaGrille(positionArriere)) {
                throw new PlacerBateauException("Le positionnement n'est pas dans la grille'");
            }

            List<Position> positions = converteur.convertir(positionAvant, positionArriere);
            if (positions.size() != type.nbCase()) {
                throw new PlacerBateauException("Le positionnement ne correspond pas à la taille du bateau");
            }
            List<Bateau> armada = armada(joueur);
            for (Bateau chaqueBateauDejaPlace : armada) {
                if (chaqueBateauDejaPlace.traverse(positions)) {
                    throw new PlacerBateauException("Le positionnement chevauche un bateau");
                }
            }
            Bateau bateau = new Bateau();
            bateau.setType(type);
            bateau.setPositions(positions);
            armada.add(bateau);
        } catch (ConverteurException e) {
            throw new PlacerBateauException("Le positionnement n'est n'y horizontal ni vertical");
        }
    }


    private List<Bateau> armada(Joueur joueur) {

        if (joueur.equals(joueur1)) {
            return armadaJoueur1;

        }
        return armadaJoueur2;

    }

    private List<Bateau> armadaAdverse(Joueur joueur) {

        if (joueur.equals(joueur1)) {
            return armadaJoueur2;

        }
        return armadaJoueur1;

    }




    private boolean estDansLaGrille(Position position) {


        return (position.getX() >= 0 && position.getX() <= 9) && (position.getY() >= 0 && position.getY() <= 9);

    }


    public BateauType[] bateauAPlacer() {


        return BateauType.values();
    }

    public void tirer(Joueur joueur, Position tirer) throws TirerException {


        try {

            if (!estDansLaGrille(tirer)) {

                throw new TirerException("Le tir n'est pas dans la grille'");

            }

            for (Bateau chaqueBateauAdverse : armadaAdverse(joueur)) {

            chaqueBateauAdverse.tirSurUnBateau(tirer);

            }


        } catch (TirerException e) {
            throw new TirerException("le tir n'est pas dans la grille ou les donnees sont X/Y ne sont pas correct");
        }

        if (!Bateau.touche) {

            System.out.println("RATE");

        }


    }

    public void verifLaListeDePositionAdverse(Joueur joueur) {


        for (Bateau chaqueBateauAdverse : armadaAdverse(joueur)) {

            if (chaqueBateauAdverse.getType().name().equals("PORTEAVION") && chaqueBateauAdverse.getEtatBateau().equalsIgnoreCase("OK")) {

                chaqueBateauAdverse.nombreDesPositionsDunBateauTouche();
            }

            if (chaqueBateauAdverse.getType().name().equals("CROISEUR") && chaqueBateauAdverse.getEtatBateau().equalsIgnoreCase("OK")) {

                chaqueBateauAdverse.nombreDesPositionsDunBateauTouche();
            }

            if (chaqueBateauAdverse.getType().name().equals("CONTRE_CROISEUR") && chaqueBateauAdverse.getEtatBateau().equalsIgnoreCase("OK")) {

                chaqueBateauAdverse.nombreDesPositionsDunBateauTouche();
            }

            if (chaqueBateauAdverse.getType().name().equals("SOUS_MARIN") && chaqueBateauAdverse.getEtatBateau().equalsIgnoreCase("OK")) {

                chaqueBateauAdverse.nombreDesPositionsDunBateauTouche();
            }

            if (chaqueBateauAdverse.getType().name().equals("TORPILLEUR") && chaqueBateauAdverse.getEtatBateau().equalsIgnoreCase("OK")) {

                chaqueBateauAdverse.nombreDesPositionsDunBateauTouche();
            }


        }


    }

    public void verifSiTousLesBateauSontCoules(Joueur joueur2, Joueur joueur1) {

        int compteurDeBateauCoule = 0;
        for (Bateau chaqueBateau : armadaAdverse(joueur2)) {

            if (chaqueBateau.getEtatBateau().equalsIgnoreCase("COULE")) {

                compteurDeBateauCoule += 1;

            }

        }

        if (compteurDeBateauCoule == 5) {

            System.out.println(joueur1.getPseudo() + " a gagné");
            System.exit(1);
        }

    }

public  Position  recupParametreIA() {


    Position parametrePosition = new Position();

    parametrePosition.setX(nombreAvantRandomX());

    parametrePosition.setY(nombreAvantRandomY());

    return parametrePosition;
}

    public  int nombreAvantRandomX() {

        int nombreAleatoire = 1 + (int)(Math.random() * ((9 - 1) + 1));


        return nombreAleatoire;
    }

    public  int nombreAvantRandomY() {



        int nombreAleatoire = 1 + (int)(Math.random() * ((9 - 1) + 1));

        return nombreAleatoire;
    }
}