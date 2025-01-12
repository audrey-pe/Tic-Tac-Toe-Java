import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nombre;
        boolean checkWin = false;
        PlateauJeu jeu = new PlateauJeu();
        System.out.println("Bienvenue dans le jeu du Tic-Tac-Toe, placez les pions chacun votre tour pour en aligner 3 et c'est gagné");
        System.out.println(jeu);

        //Saisie du jeu parti utilisateur
        do {
            System.out.println("Joueur 1 : Selectionner la case avec le chiffre de la case ou vous souhaitez possitionner votre pion");
            nombre = sc.nextInt();
            boolean saisieValide = jeu.set(nombre, Case.Contenu.X);
            while (!saisieValide) {
                System.out.println("Joueur 1 : Selctionner la case avec le chiffre de la case ou vous souhaitez possitionner votre pion");
                System.out.println(jeu);
                nombre = sc.nextInt();
                saisieValide = jeu.set(nombre, Case.Contenu.X);
            }
            System.out.println(jeu);
            if (checkWin == true) {
                System.out.println("Le joueur 1 gagne");
                break;
            }
            if (jeu.isFull()) {
                System.out.println("Partie nulle");
                break;
            }
            System.out.println("Joueur 2 : Selectionner la case avec le chiffre de la case ou vous souhaitez possitionner votre pion");
            nombre = sc.nextInt();
            saisieValide = jeu.set(nombre, Case.Contenu.O);
            while (!saisieValide) {
                System.out.println("Joueur 2 : Selctionner la case avec le chiffre de la case ou vous souhaitez possitionner votre pion");
                System.out.println(jeu);
                nombre = sc.nextInt();
                saisieValide = jeu.set(nombre, Case.Contenu.O);
            }
            System.out.println(jeu);
            if (checkWin == true) {
                System.out.println("Le joueur 2 gagne");
                break;
            }
        } while (!jeu.isFull());
    }

}