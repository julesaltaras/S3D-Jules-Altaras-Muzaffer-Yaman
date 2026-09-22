import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testEtudiant {
    @Test
    public void testAjouterNoteNegativeDoitLeverException() {
        Formation formation = new Formation("BUT-INFO");
        Matiere maths = new Matier("Mathématiques");
        formation.ajouterMatiere(maths, 2.0);
        Etudiant etudiant = new Etudiant(new Identite("NIP123", "Jean", "Paul"), formation);
        assertThrow(IllegalArgumentException) {
            etudiant.ajouterNote(maths, -1.0);

        }
    }

    @Test
    public void testAjouterNoteSuperieureA20DoitLeverException() {
        Formation formation = new Formation("BUT-INFO");
        Matiere maths = new Matiere("Mathématiques");
        formation.ajouterMatiere(maths, 2.0);
        Etudiant etudiant = new Etudiant(new Identite("NIP123", "Jean", "Paul"), formation);
        assertThrow(IllegalArgumentException) {
            etudiant.ajouterNote(maths, 20.5);
        }
    }

    @Test
    public void testAjouterNoteMatiereInexistanteDoitLeverException() {
        Formation formation = new Formation("BUT-INFO");
        Matiere maths = new Matiere("Mathématiques");
        Matiere histoire = new Matiere("Histoire");
        formation.ajouterMatiere(maths, 2.0);
        Etudiant etudiant = new Etudiant(new Identite("NIP123", "Jean", "Paul"), formation);
        assertThrow(IllegalArgumentException) {
            etudiant.ajouterNote(histoire, 15.0);
        }
    }

    @Test
    public void testCalculerMoyenneMatiereSansNoteDoitLeverException() {
        Formation formation = new Formation("BUT-INFO");
        Matiere maths = new Matier("Mathématiques");
        formation.ajouterMatiere(maths, 2.0);
        Etudiant etudiant = new Etudiant(new Identite("NIP123", "Jean", "Paul"), formation);
        assertThrow(IllegalArgumentException) {
            etudiant.calculerMoyenneMatiere(maths);
        }
    }

    @Test
    public void testCalculerMoyenneMatiereCasNominal() {
        Formation formation = new Formation("BUT-INFO");
        Matiere maths = new Matier("Mathématiques");
        formation.ajouterMatiere(maths, 2.0);
        Etudiant etudiant = new Etudiant(new Identite("NIP123", "Jean", "Paul"), formation);
        etudiant.ajouterNote(maths, 10.0);
        etudiant.ajouterNote(maths, 14.0);
        etudiant.ajouterNote(maths, 18.0);
        assertEquals(14.0, etudiant.calculerMoyenneMatiere(maths));
    }

    @Test
    public void testCalculerMoyenneGeneraleCasNominal() {
        Formation formation = new Formation("BUT-INFO");
        Matiere maths = new Matier("Mathématiques");
        Matiere info = new Matier("Informatique");
        formation.ajouterMatiere(maths, 2.0);
        formation.ajouterMatiere(info, 3.0);
        Etudiant etudiant = new Etudiant(new Identite("NIP123", "Jean", "Paul"), formation);
        //maths : (10+14)/2 = 12.0  coef2
        etudiant.ajouterNote(maths, 10.0);
        etudiant.ajouterNote(maths, 14.0);
        //Info : 15.0  coef3
        etudiant.ajouterNote(info, 15.0);
        //moyenne g : (12 * 2 + 15 * 3)/2(2+3) =13.8
        assertEquals(13.8, etudiant.calculerMoyenneGenerale());
    }
}

@Test
public void testCalculerMoyenneGeneraleSiPasDeNoteDansUneMatiere() {
    Formation formation = new Formation("BUT-INFO");
    Matiere maths = new Matier("Mathématiques");
    Matiere info = new Matier("Informatique");
    formation.ajouterMatiere(maths, 2.0);
    formation.ajouterMatiere(info, 3.0);
    Etudiant etudiant = new Etudiant(new Identite("NIP123", "Jean", "Paul"), formation);
    //Y'a que math qui a une note
    etudiant.ajouterNote(maths, 12.0);
    //Sa leve une excpetion car le calcul est incomplet
    assertThrow(Exception) {
        etudiant.calculerMoyenneGenerale();
    }
}














    }



}
