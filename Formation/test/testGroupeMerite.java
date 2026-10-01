import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testGroupeMerite {

    private Formation f;
    private Matiere maths, info;
    private Groupe g;

    @BeforeEach
    void setUp() {
        f = new Formation("BUT Informatique");
        maths = new Matiere("Maths", 1);
        info = new Matiere("Info", 3);
        f.ajouterMatiere(maths, 1);
        f.ajouterMatiere(info, 3);
        g = new Groupe(f);
    }

    private Etudiant creer(String nom, double noteMaths, double noteInfo) {
        Etudiant e = new Etudiant(new Identite(nom, "Prenom", "NIP" + nom), f);
        e.ajouterNote(maths, noteMaths);
        e.ajouterNote(info, noteInfo);
        return e;
    }

    @Test
    void testTriParMerite() {
        Etudiant faible = creer("Faible", 8, 8);
        Etudiant moyen = creer("Moyen", 12, 12);
        Etudiant fort = creer("Fort", 16, 16);
        g.ajouterEtudiant(moyen);
        g.ajouterEtudiant(faible);
        g.ajouterEtudiant(fort);
        g.triParMerite();
        assertEquals(fort, g.getEtudiants().get(0));
        assertEquals(moyen, g.getEtudiants().get(1));
        assertEquals(faible, g.getEtudiants().get(2));
    }

    @Test
    void testTriParMeriteAvecCoefficients() {
        // A : (20*1 + 10*3) / 4 = 12,5   et   B : (10*1 + 14*3) / 4 = 13
        Etudiant a = creer("A", 20, 10);
        Etudiant b = creer("B", 10, 14);
        g.ajouterEtudiant(a);
        g.ajouterEtudiant(b);
        g.triParMerite();
        assertEquals(b, g.getEtudiants().get(0));
        assertEquals(a, g.getEtudiants().get(1));
    }

    @Test
    void testTriParMeriteGroupeVide() {
        assertDoesNotThrow(() -> g.triParMerite());
    }
}