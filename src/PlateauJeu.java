import java.util.ArrayList;

public class PlateauJeu {
    private ArrayList<Case> plateau = new ArrayList<>();

    //Creation du plateau, constructeur
    public PlateauJeu() {
        for (int i = 0; i < 9; i++) {
            Case c = new Case(i + 1);
            plateau.add(c);
        }
    }

    //Modification de la grille
    public void grille() {
        for (int i = 0; i < 9; i++) {
            Case c = plateau.get(i);
            c.setContenu(Case.Contenu.vide);
            plateau.set(i, c);
        }

    }

    //affichage dans la console
    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        a.append(plateau.get(0).toString() + " | " + plateau.get(1).toString() + " | " + plateau.get(2).toString() + "\n");
        a.append("--+--+--\n");
        a.append(plateau.get(3).toString() + " | " + plateau.get(4).toString() + " | " + plateau.get(5).toString() + "\n");
        a.append("--+--+--\n");
        a.append(plateau.get(6).toString() + " | " + plateau.get(7).toString() + " | " + plateau.get(8).toString() + "\n");
        return a.toString();
    }

    //gestion du jeu
    public boolean set(int nombre, Case.Contenu Pion) {
        if (nombre < 1 || nombre > 9) {
            System.out.println("Le nombre doit etre entre 1 et 9");
            return false;
        }
        if (plateau.get(nombre - 1).getContenu() == Case.Contenu.vide) {
            Case c = plateau.get(nombre - 1);
            c.setContenu(Pion);
            plateau.set(nombre - 1, c);

        } else {
            System.out.println("Vous ne pouvez pas vous placer ici, c'est déjà occupé");
            return false;
        }
        return true;
    }

    private Case.Contenu get(int nombre) {
        return plateau.get(nombre).getContenu();
    }

    //verification match null
    public boolean isFull() {
        int count = 0;
        for (Case c : plateau) {
            if (c.getContenu() != Case.Contenu.vide) {
                count++;
            }
        }
        if (count == 9) {
            return true;
        }
        return false;
    }

    // dynamique de jeu, check Win
    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (get(i * 3) != Case.Contenu.vide && get(i * 3) == get(i * 3 + 1) && get(i * 3) == get(i * 3 + 2)) {
                return true;
            }
            if (get(i) != Case.Contenu.vide && get(i) == get(i + 3) && get(i) == get(i + 6)) {
                return true;
            }
        }
        if (get(0) != Case.Contenu.vide && get(0) == get(4) && get(0) == get(8)) {
            return true;
        }
        if (get(2) != Case.Contenu.vide && get(2) == get(4) && get(2) == get(6)) {
            return true;
        }

        return false;
    }
}
