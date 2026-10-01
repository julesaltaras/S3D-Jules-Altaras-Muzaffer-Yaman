import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testEtudiants {

    private Etudiant etu;
    private Matiere mat, mat2, absente;

    @BeforeEach
    void setUp() {
        Formation form = new Formation("Astrologue");
        mat = new Matiere("Sciences", 8);
        mat2 = new Matiere("Latin", 2);
        absente = new Matiere("Inconnue", 1);
        form.ajouterMatiere(mat, 8);
        form.ajouterMatiere(mat2, 2);
        etu = new Etudiant(new Identite("BOL", "Pasdeunom", "Niprainon"), form);
    }

    private void ajouterNotes(Matiere matiere, double... notes) {
        for (double note : notes) etu.ajouterNote(matiere, note);
    }

    @Test
    void testAjouterNotes() {
        ajouterNotes(mat, 20, 16, 8);
        assertEquals(20, etu.getResultats().get(mat).get(0));
        assertEquals(16, etu.getResultats().get(mat).get(1));
        assertEquals(8, etu.getResultats().get(mat).get(2));
    }

    @Test
    void testNotesInvalides() {
        assertThrows(IllegalArgumentException.class, () -> etu.ajouterNote(mat, -1));
        assertThrows(IllegalArgumentException.class, () -> etu.ajouterNote(mat, 21));
        assertThrows(IllegalArgumentException.class, () -> etu.ajouterNote(absente, 10));
    }

    @Test
    void testMatiereSansNote() {
        assertThrows(IllegalArgumentException.class, () -> etu.calculerMoyenneMatiere(mat2));
    }

    @Test
    void testMoyennes() {
        ajouterNotes(mat, 20, 16, 8, 16);
        ajouterNotes(mat2, 12, 8);
        assertEquals(15, etu.calculerMoyenneMatiere(mat));
        assertEquals(10, etu.calculerMoyenneMatiere(mat2));
        assertEquals(14, etu.calculerMoyenneGenerale());
    }

    @Test
    void testMoyenneGeneraleAvecMatiereSansNote() {
        ajouterNotes(mat, 20, 10);
        assertEquals(15, etu.calculerMoyenneGenerale());
    }
}