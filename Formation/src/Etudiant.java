import java.util.*;

public class Etudiant {

    private Identite id;

    private Formation form;

    private Map<Matiere, List<Double>> resultats;

    public Etudiant(Identite identite, Formation formation) {
        this.id = identite;
        this.form = formation;
        this.resultats = new HashMap<>();
    }

    public Identite getId() {
        return id;
    }

    public void ajouterNote(Matiere m, double note){
        if (note > 20){
            note = 20;
        }
        if (note < 0){
            note = 0;
        }
        if (!resultats.containsKey(m)) {
            resultats.put(m, new ArrayList<>()); // initialise une liste vide si absente
        }
        resultats.get(m).add(note);
    }

    public double calculerMoyenneMatiere(Matiere matiere){
        int taille = this.resultats.get(matiere).size();
        double  moyenneMatiere = 0;
        for (int i = 0; i < taille; i++){
            moyenneMatiere += this.resultats.get(matiere).get(i);
        }
        return moyenneMatiere/taille;
    }

    public double calculerMoyenneGenerale(){
        double somme = 0;
        double totalCoeff = 0;
        for (Matiere m : this.form.getMatieres().keySet()){
            List<Double> notes = this.resultats.get(m);
            double sommeNotes = 0;
            for (Double note : notes){
                sommeNotes += note;
            }
            double moyenne =  sommeNotes/notes.size();
            int coeff = form.getCoefficient(m);
            somme += moyenne * coeff;
            totalCoeff += coeff;
        }
        if (totalCoeff == 0){
            return 0;
        }
        else return somme/totalCoeff;
    }

    public Formation getFormation() {
        return form;
    }

    public Map<Matiere, List<Double>>  getResultats() {
        return this.resultats;
    }
}