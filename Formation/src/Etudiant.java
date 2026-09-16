import java.util.ArrayList;
import java.util.HashMap;

public class Etudiant {
    private  Identite id;
    private Formation form;
    private Map<Matiere, List<Double> resultats>;
    public Etudiant(Identite identite, Formation formation) {
        this.id=identite;
        this.form=formation;
        this.resultats=new HashMap<>();
    }

    public Identite getId() {
        return id;
    }

    public void ajouterNote(Matiere m,double note){
        if (note>20){
            note=20;
        }
        if (note<0){
            note=0;
        }
        if (!resultats.containKey(m)){
            resultats.put(m,new ArrayList<>());
        }
        resultats.get(m).add(note);
    }
    
    public calculerMoyenneMatiere(Matiere matiere){
    }

    public calculerMoyenneGenerale(){
    }

    public Formation getFormation() {
        return form;
    }

    public Map<Matier,List<Double>> getResultats(){
        return resultats;
    }
}
