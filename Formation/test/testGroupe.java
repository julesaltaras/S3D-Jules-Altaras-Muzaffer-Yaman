import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testGroupe {

    @Test
    public void testGroupe() {
        Identite id = new Identite("BOL", "Pasdeunom", "Niprainon");
        Formation form = new Formation("Astrologue");
        Matiere mat = new Matiere("Sciences de la faune de la flore, du corps humain, de l'astrologie...", 8);
        form.ajouterMatiere(mat,  16);
        Etudiant etu = new Etudiant(id, form);
        Groupe gr = new Groupe(form);
        //test méthode
        gr.ajouterEtudiant(etu);
        //vérif
        assertEquals(form, gr.getFormation());
        assertEquals(etu, gr.getEtudiants().get(0));
    }

    @Test
    public void testGroupe2() {
        Identite id = new Identite("BOL", "Pasdeunom", "Niprainon");
        Formation form = new Formation("Astrologue");
        Matiere mat = new Matiere("Sciences de la faune de la flore, du corps humain, de l'astrologie...", 8);
        form.ajouterMatiere(mat,  16);
        Etudiant etu = new Etudiant(id, form);
        Groupe gr = new Groupe(form);
        //test méthode
        gr.ajouterEtudiant(etu);
        gr.supprimerEtudiant(etu);
        //vérif
        assertEquals(form, gr.getFormation());
        assertEquals(0, gr.getEtudiants().size());
    }
}