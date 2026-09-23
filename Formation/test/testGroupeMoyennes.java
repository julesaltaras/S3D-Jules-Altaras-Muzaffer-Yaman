import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testGroupeMoyennes {

    private Formation f;
    private Groupe g;
    private Matiere web, reseau, algo, java;
    private Etudiant arthur, astrid, louis;

    @BeforeEach
    void initialiser() {
        f = new Formation("BUT Informatique");
        web = new Matiere("Web", 1);
        reseau = new Matiere("Réseau", 2);
        algo = new Matiere("Algo", 3);
        java = new Matiere("Java", 4);
        f.ajouterMatiere(web, 1);
        f.ajouterMatiere(reseau, 1);
        f.ajouterMatiere(algo, 2);
        f.ajouterMatiere(java, 1);

        arthur = creerEtudiant("Arthur", 12, 11, 9, 10);
        astrid = creerEtudiant("Astrid", 9, 9, 9, 9);
        louis = creerEtudiant("Louis", 11, 11, 9, 10);
        g = new Groupe(f);
    }

    private Etudiant creerEtudiant(String nom, double w, double r, double a, double j) {
        Etudiant e = new Etudiant(new Identite(nom, nom, nom), f);
        e.ajouterNote(web, w);
        e.ajouterNote(reseau, r);
        e.ajouterNote(algo, a);
        e.ajouterNote(java, j);
        return e;
    }

    private void ajouterEtudiants() {
        g.ajouterEtudiant(arthur);
        g.ajouterEtudiant(astrid);
        g.ajouterEtudiant(louis);
    }

    // Vérifie les moyennes lorsque le groupe contient trois étudiants.
    @Test
    void testMoyennesGroupe() {
        ajouterEtudiants();
        assertEquals(10.67, g.calculerMoyGroupeMatiere(web), 0.01);
        assertEquals(10.33, g.calculerMoyGroupeMatiere(reseau), 0.01);
        assertEquals(9, g.calculerMoyGroupeMatiere(algo), 0.01);
        assertEquals(9.67, g.calculerMoyGroupeMatiere(java), 0.01);
        assertEquals(9.73, g.calculerMoyGenGroupe(), 0.01);
    }

    // Vérifie qu'une moyenne ne peut pas être calculée pour un groupe vide.
    @Test
    void testMoyenneGroupeVide() {
        assertThrows(IllegalArgumentException.class, () -> g.calculerMoyGenGroupe());
    }

    // Un étudiant sans note de sport est ignoré dans la moyenne de sport.
    @Test
    void testMatiereAvecUneNoteManquante() {
        Matiere sport = new Matiere("Sport", 5);
        f.ajouterMatiere(sport, 1);
        arthur.ajouterNote(sport, 10);
        louis.ajouterNote(sport, 14);
        ajouterEtudiants();
        assertEquals(12, g.calculerMoyGroupeMatiere(sport), 0.01);
    }

    // Vérifie le cas où aucun étudiant n'a de note dans une matière.
    @Test
    void testMatiereSansAucuneNote() {
        Matiere sport = new Matiere("Sport", 5);
        f.ajouterMatiere(sport, 1);
        ajouterEtudiants();
        assertThrows(IllegalArgumentException.class, () -> g.calculerMoyGroupeMatiere(sport));
    }

    // Vérifie les ajouts interdits : étudiant null ou d'une autre formation.
    @Test
    void testAjoutsInvalides() {
        Etudiant autre = new Etudiant(new Identite("X", "X", "X"), new Formation("Autre"));
        assertThrows(IllegalArgumentException.class, () -> g.ajouterEtudiant(null));
        assertThrows(IllegalArgumentException.class, () -> g.ajouterEtudiant(autre));
    }
}
