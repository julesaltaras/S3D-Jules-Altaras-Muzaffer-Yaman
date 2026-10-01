import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testGroupeTris {
    private Groupe g;
    private Etudiant dupont, albert, martin;

    @BeforeEach
    void setUp() {
        Formation f = new Formation("BUT Informatique");
        dupont = new Etudiant(new Identite("Dupont", "Paul", "N1"), f);
        albert = new Etudiant(new Identite("Albert", "Jean", "N2"), f);
        martin = new Etudiant(new Identite("Martin", "Luc", "N3"), f);
        g = new Groupe(f);
        g.ajouterEtudiant(dupont);
        g.ajouterEtudiant(albert);
        g.ajouterEtudiant(martin);
    }

    @Test
    void testTriAlpha() {
        g.triAlpha();
        assertEquals(albert, g.getEtudiants().get(0));
        assertEquals(dupont, g.getEtudiants().get(1));
        assertEquals(martin, g.getEtudiants().get(2));
    }

    @Test
    void testTriAntiAlpha() {
        g.triAntiAlpha();
        assertEquals(martin, g.getEtudiants().get(0));
        assertEquals(dupont, g.getEtudiants().get(1));
        assertEquals(albert, g.getEtudiants().get(2));
    }

    @Test
    void testTriGroupeVide() {
        Groupe vide = new Groupe(new Formation("Autre"));
        assertDoesNotThrow(vide::triAlpha);
        assertDoesNotThrow(vide::triAntiAlpha);
    }
}

