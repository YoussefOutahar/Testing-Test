import org.example.Bibliotheque;
import org.example.Livre;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BibliothequeTest {
    // fonction de test pour ajouter un livre dans une bibliothèque vide
    @Test
    public void testAjouterLivreDansBibliothequeVide() {
        // Créer un livre
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre = new Livre("Dummy Book", "R.R Martin",99);

        // Ajouter le livre à la bibliothèque
        bibliotheque.ajouterLivre(livre);

        // Vérifier que le livre a été ajouté à la bibliothèque
        assertTrue(bibliotheque.contientLivre(livre));
    }

    // fonction de test pour ajouter un livre dans une bibliothèque non vide
    @Test
    public void testAjouterLivreDansBibliothequeNonVide() {
        List<Livre> livresExistant = new ArrayList<>();
        Livre livre1 = new Livre("Dummy Book", "R.R Martin",99);
        livresExistant.add(livre1);

        Bibliotheque bibliotheque = new Bibliotheque(livresExistant);
        Livre livre2 = new Livre("dummy book", "a writer",5);

        bibliotheque.ajouterLivre(livre2);

        assertTrue(bibliotheque.contientLivre(livre1));
        assertTrue(bibliotheque.contientLivre(livre2));
    }

    // fonction de test pour ajouter un livre null
    @Test
    public void testAjouterLivreNull() {
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre = null;

        bibliotheque.ajouterLivre(livre);

        assertFalse(bibliotheque.contientLivre(livre));
    }

    // fonction de test pour retirer un livre
    @Test
    public void testRetirerLivre() {
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre1 = new Livre("Dummy Book", "R.R Martin",99);
        Livre livre2 = new Livre("The Dummy Book", "R.R Martin 33",99);
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);

        bibliotheque.retirerLivre(livre1);

        assertFalse(bibliotheque.contientLivre(livre1));
        assertTrue(bibliotheque.contientLivre(livre2));
    }

    // fonction de test pour retirer un livre inexistant
    @Test
    public void testRetirerLivreInexistant() {
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre1 = new Livre("Dummy Book", "R.R Martin",99);
        Livre livre2 = new Livre("Dummy Book 2", "R.R Martin 2",99);
        bibliotheque.ajouterLivre(livre1);

        bibliotheque.retirerLivre(livre2);

        assertTrue(bibliotheque.contientLivre(livre1));
    }

    // fonction de test pour retirer un livre null
    @Test
    public void testRetirerLivreNull() {
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre = null;

        bibliotheque.retirerLivre(livre);

        assertFalse(bibliotheque.contientLivre(livre));
    }

    // fonction de test pour vérifier si un livre est présent dans la bibliothèque
    @Test
    public void testContientLivrePresent() {
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre = new Livre("Dummy Book", "R.R Martin",99);
        bibliotheque.ajouterLivre(livre);

        assertTrue(bibliotheque.contientLivre(livre));
    }

    // fonction de test pour vérifier si un livre est absent de la bibliothèque
    @Test
    public void testContientLivreAbsent() {
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre = new Livre("Dummy Book", "R.R Martin",99);

        assertFalse(bibliotheque.contientLivre(livre));
    }

    // fonction de test pour vérifier si un livre est null
    @Test
    public void testContientLivreNull() {
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre = null;

        assertFalse(bibliotheque.contientLivre(livre));
    }
}