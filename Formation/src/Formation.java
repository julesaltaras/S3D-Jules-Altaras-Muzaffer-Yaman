import java.util.HashMap;
import java.util.Map;

public class Formation {
    private final String id;
    private final Map<Matiere, Double> matieres = new HashMap<>();

    public Formation(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void ajouterMatiere(Matiere matiere, double coefficient) {
        if (coefficient <= 0) throw new IllegalArgumentException("Coefficient négatif ou nul interdit");
        matieres.put(matiere, coefficient);
    }

    public void supprimerMatiere(Matiere matiere) {
        matieres.remove(matiere);
    }

    public double getCoefficient(Matiere matiere) {
        Double coef = matieres.get(matiere);
        if (coef == null) {
            throw new IllegalArgumentException("Le matiere n'existe pas" + matiere);
        }

        return coef;
    }

    public Map<Matiere, Double> getMatieres() {
        return matieres;
    }
}





