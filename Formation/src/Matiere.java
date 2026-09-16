public class Matiere {
    private String nom;
    private int coeff;

    public Matiere(String nom, int coeff) {
        this.nom = nom;
        this.coeff = coeff;

    }

    public String getNom() {
        return this.nom;
    }

    public int getCoeff() {
        return this.coeff;
    }
}
