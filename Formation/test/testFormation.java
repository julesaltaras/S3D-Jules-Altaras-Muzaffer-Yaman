import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testFormation {

    private Formation f;
    private Matiere m1, m2;

    @BeforeEach
    void setUp() {
        f = new Formation("F1");
        m1 = new Matiere("Maths", 9);
        m2 = new Matiere("Info", 10);
    }

    @Test
    void testTableMatieresBienInstanciee() {
        assertTrue(f.getMatieres().isEmpty(), "La table des matières doit être vide au départ");
    }

    @Test
    void testAjouterMatiereValide() {
        f.ajouterMatiere(m1, 3);
        assertEquals(3, f.getCoefficient(m1));
        assertFalse(f.getMatieres().isEmpty());
    }

    @Test
    void testAjouterMatiereAvecCoeffNegatif() {
        assertThrows(IllegalArgumentException.class, () -> {
            f.ajouterMatiere(m1, -2);
        });
    }

    @Test
    void testDemandeCoefficientMatiereNonPresente() {
        assertThrows(IllegalArgumentException.class, () -> {
            f.getCoefficient(m1); // pas encore ajoutée
        });
    }

    @Test
    void testSuppressionMatiere() {
        f.ajouterMatiere(m1, 2);
        f.supprimerMatiere(m1);
        assertTrue(f.getMatieres().isEmpty(), "La matière doit être supprimée");
    }

    @Test
    void testAjouterDeuxMatieres() {
        f.ajouterMatiere(m1, 2);
        f.ajouterMatiere(m2, 4);
        assertEquals(2, f.getCoefficient(m1));
        assertEquals(4, f.getCoefficient(m2));
        assertEquals(2, f.getMatieres().size(), "Deux matières doivent être enregistrées");
    }
}
