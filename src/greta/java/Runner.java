package greta.java;


public class Runner {


    public static void main(String[] args) throws TirerException {
        Partie partie = new Partie();
        UI ui = new UI();

        int nombreJoueur = ui.messageJoueurOuIA();
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();


            String pseudoJoueur1 = ui.pseudoJoueur1();
            joueur1.setPseudo(pseudoJoueur1);
            partie.setJoueur1(joueur1);




        if (nombreJoueur == 2) {
            joueur2.setPseudo(ui.pseudoJoueur2());
            partie.setJoueur2(joueur2);
            while (joueur1.getPseudo().equalsIgnoreCase(joueur2.getPseudo())) {

                System.out.println("Joueur 2, vous ne pouvez pas avoir le même pseudo");
                joueur2.setPseudo(ui.pseudoJoueur2());
            }
        }


        else if (nombreJoueur == 1) {

            joueur2.setPseudo("IA");
            partie.setJoueur2(joueur2);

        }
        String placementAleatoire = ui.demandePlacementIA();

        if (placementAleatoire.equalsIgnoreCase("oui")) {

            placementBateauIA(partie, ui, joueur1);

        } else if (placementAleatoire.equalsIgnoreCase("non")) {

            placementBateauParJoueur(partie, ui, joueur1);

        }


        if (nombreJoueur == 2 && placementAleatoire.equalsIgnoreCase("oui")) {

            placementBateauIA(partie, ui, joueur2);

        } else if (nombreJoueur == 2 && placementAleatoire.equalsIgnoreCase("non")) {

            placementBateauParJoueur(partie, ui, joueur2);

        } else if (nombreJoueur == 1) {
            placementBateauIA(partie, ui, joueur2);

        }

        if (nombreJoueur == 2) {


            boolean infini = true;
            while (infini) {

              ui.messageTirer(joueur1);
                Position positionDuTir1 = ui.recupererPosition();
                partie.tirer(joueur2, positionDuTir1);
                Bateau.touche = false;
                partie.verifLaListeDePositionAdverse(joueur2);
                partie.verifSiTousLesBateauSontCoules(joueur2, joueur1);

                ui.messageTirer(joueur2);
                Position positionDuTir2 = ui.recupererPosition();
                partie.tirer(joueur1, positionDuTir2);
                Bateau.touche = false;
                partie.verifLaListeDePositionAdverse(joueur1);
                partie.verifSiTousLesBateauSontCoules(joueur1, joueur2);


            }

        } else if (nombreJoueur == 1) {


            boolean infini = true;
            while (infini) {

                ui.messageTirer(joueur1);
                Position positionDuTir1 = ui.recupererPosition();
                partie.tirer(joueur2, positionDuTir1);
                Bateau.touche = false;
                partie.verifLaListeDePositionAdverse(joueur2);
                partie.verifSiTousLesBateauSontCoules(joueur2, joueur1);

                ui.messageTirer(joueur2);
                Position positionDuTir2 = partie.recupParametreIA();
                partie.tirer(joueur1, positionDuTir2);
                Bateau.touche = false;
                partie.verifLaListeDePositionAdverse(joueur1);
                partie.verifSiTousLesBateauSontCoules(joueur1, joueur2);

            }
        }


    }


    private static void placementBateauParJoueur(Partie partie, UI ui, Joueur joueur) {


        ui.messageDebutPlacerBateau(joueur);
        for (BateauType type : partie.bateauAPlacer()) {
            boolean placer = false;
            while (!placer) {
                ui.messagePlacerBateau(type); // "On va placer le porte-avion (5 cases)"
                ui.messageRecupererPositionAvant(); // "Merci de saisir la position avant du bateau"
                Position positionAvant = ui.recupererPosition();
                ui.messageRecupererPositionArriere(); // "Merci de saisir la position arrière du bateau"
                Position positionArriere = ui.recupererPosition();
                try {
                    partie.placer(joueur, type, positionAvant, positionArriere);
                    placer = true;
                } catch (PlacerBateauException exception) {
                    ui.messageErreurPlacementBateau(exception.getMessage());
                }

            }

        }
    }

    public static void placementBateauIA(Partie partie, UI ui, Joueur joueur) {

        System.out.println("Placement automatique des Bateaux pour " +joueur.getPseudo());
        for (BateauType type : partie.bateauAPlacer()) {

            boolean placer = false;
            while (!placer) {

                Position positionAvant = partie.recupParametreIA();
                Position positionArriere = partie.recupParametreIA();
                try {
                    partie.placer(joueur, type, positionAvant, positionArriere);
                    placer = true;
                } catch (PlacerBateauException exception) {

                }
            }

        }

    }

}
