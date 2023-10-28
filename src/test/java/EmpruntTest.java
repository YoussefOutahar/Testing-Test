import org.example.Bibliotheque;
import org.example.Emprunt;
import org.example.Livre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class EmpruntTest {
    @InjectMocks
    private Emprunt emprunt;
    @Mock
    private Bibliotheque bibliotheque;

    // fonction de test pour emprunter un livre disponible
    @Test
    public void testEmprunterLivre_LivreDisponible() {
        // Créer un livre
        Livre livre = new Livre("Dummy Book", "R.R Martin",99);

        // Configurer le mock de la bibliothèque
        when(bibliotheque.contientLivre(livre)).thenReturn(true);

        // Effectuer l'emprunt
        emprunt.emprunterLivre("Utilisateur1", livre);

        // Vérifier que le livre a été retiré de la bibliothèque
        verify(bibliotheque, times(1)).retirerLivre(livre);
    }

    // fonction de test pour emprunter un livre déjà emprunté
    @Test
    public void testEmprunterLivre_LivreDejaEmprunte() {
        // Créer un livre
        Livre livre = new Livre("Dummy Book", "R.R Martin",99);

        // Configurer le mock de la bibliothèque
        when(bibliotheque.contientLivre(livre)).thenReturn(false);

        // Effectuer l'emprunt
        emprunt.emprunterLivre("User1", livre);

        // Assurez-vous que la méthode retirerLivre n'a jamais été appelée
        verify(bibliotheque, never()).retirerLivre(any());
    }


    // fonction de test pour emprunter un livre non dans la bibliothèque
    @Test
    public void testEmprunterLivre_LivreNonDansLaBibliotheque() {
        // Créer un livre
        Livre livre = new Livre("Dummy Book", "R.R Martin",99);

        // Configurer le mock de la bibliothèque
        when(bibliotheque.contientLivre(livre)).thenReturn(false);

        // Effectuer l'emprunt
        emprunt.emprunterLivre("Utilisateur1", livre);

        // Assurez-vous que la méthode retirerLivre n'a jamais été appelée
        verify(bibliotheque, never()).retirerLivre(livre);
    }

    // fonction de test pour retourner un livre emprunté
    @Test
    public void testRetournerLivre_LivreEmprunte() {
        // Créer un livre
        Livre livre = new Livre("Dummy Book", "R.R Martin",99);

        // Configurer le mock de la bibliothèque
        when(bibliotheque.contientLivre(livre)).thenReturn(true);

        // Effectuer l'emprunt
        emprunt.emprunterLivre("User1", livre);

        // Configurer le mock de la bibliothèque
        reset(bibliotheque);

        // Effectuer le retour du livre
        emprunt.retournerLivre("User1");

        // Vérifier que le livre a été ajouté à la bibliothèque
        verify(bibliotheque, times(1)).ajouterLivre(livre);
    }

    // fonction de test pour retourner un livre non emprunté
    @Test
    public void testRetournerLivre_UtilisateurSansEmprunt() {
        // Créer un livre
        emprunt.retournerLivre("User1");

        // Assurez-vous que la méthode ajouterLivre n'a jamais été appelée
        verify(bibliotheque, never()).ajouterLivre(any());
    }

}
