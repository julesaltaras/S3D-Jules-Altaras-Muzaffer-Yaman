import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Groupe {
    private List<Etudiant>etudiants;
    private Formation formation;
    public Groupe(Formation forma) {
        this.formation = forma;
        this.etudiants = new ArrayList<Etudiant>();
    }
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
    public Formation getFormation() {
        return formation;
    }
    public void ajouterEtudiant(Etudiant etudiant) {
        if (etudiant.getFormation()==this.formation) {
            this.etudiants.add(etudiant);
        }
    }
    public void supprimerEtudiant(Etudiant etudiant) {
        this.etudiants.remove(etudiant);
    }
}
