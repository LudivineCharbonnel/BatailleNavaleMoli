package fr.greta.java.bataillenavale;

import java.util.Scanner;

public class UI {


    public void messageDebutPlacerBateau(Joueur joueur) {

        System.out.println("C'est à " + joueur.getPseudo() + " de positionner son bateau");

    }



    public void messagePlacerBateau(BateauType type) {

        System.out.println("Nous allons placer le " + type.name());
    }

    public void messageRecupererPositionAvant() {

        System.out.println("Veuillez entrer la position avant du bateau :");


    }

    public Position recupererPosition() {
        Scanner scanner = new Scanner(System.in);
        Position parametrePosition = new Position();

        System.out.println("Entrez le X");
        parametrePosition.setX((scanner.nextInt()));
        System.out.println("Entrez le Y");
        parametrePosition.setY((scanner.nextInt()));

        return parametrePosition;
    }



    public void messageRecupererPositionArriere() {

        System.out.println("Veuillez entrer la position arriere du bateau :");
    }

    public void messageErreurPlacementBateau(String e) {

        System.out.println(e);

    }

    public void messageTirer(Joueur joueur) {

        System.out.println("C'est à " + joueur.getPseudo() + " de tirer");

    }

  public String pseudoJoueur1() {
      Scanner scanner = new Scanner(System.in);
          System.out.println("Joueur 1 : Veuillez entrer votre pseudo :");
      String pseudoJoueur1 = scanner.nextLine();
      while (pseudoJoueur1.equalsIgnoreCase("IA")) {

          System.out.println("pseudo incorrect");
          pseudoJoueur1.equalsIgnoreCase(scanner.nextLine());
      }
        return pseudoJoueur1;
  }

    public String pseudoJoueur2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Joueur 2 : Veuillez entrer votre pseudo :");

        String pseudoJoueur2 = scanner.nextLine();
        while (pseudoJoueur2.equalsIgnoreCase("IA")) {

            System.out.println("pseudo incorrect");
            pseudoJoueur2.equalsIgnoreCase(scanner.nextLine());
        }
return pseudoJoueur2;
    }

    public int messageJoueurOuIA(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select : 1 pour jouer contre l'IA -- 2 pour 2 joueurs humains OU 3 pour IA vs IA");
        return scanner.nextInt();

    }


    public String demandePlacementIA() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voulez vous un placement aleatoire? ( oui ou non )");

        return scanner.nextLine();

    }
}
