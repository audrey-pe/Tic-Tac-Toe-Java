public class Case {
    private Contenu contenu;

    public enum Contenu {
        vide,
        X,
        O,
    }

    private int numero;

    public Case(int num) {
        this.contenu = Contenu.vide;
        this.numero = num;
    }

    public void setContenu(Contenu contenu) {
        this.contenu = contenu;
    }

    public Contenu getContenu() {
        return contenu;
    }

    @Override
    public String toString() {
        switch (this.contenu) {
            case vide -> {
                return String.valueOf(this.numero);
            }
            case X -> {
                return "X";
            }
            case O -> {
                return "O";
            }
            default -> {
                return "??";
            }
        }
    }
}
