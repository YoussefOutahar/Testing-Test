package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private List<Livre> livres = new ArrayList<>();
    public Bibliotheque() {
    }
    public Bibliotheque(List<Livre> livres) {
        this.livres=livres;
    }
    public void ajouterLivre(Livre livre) {
        if (livre != null) {
            livres.add(livre);
        }
    }

    public void retirerLivre(Livre livre) {
        livres.remove(livre);
    }

    public boolean contientLivre(Livre livre) {
        if (livre != null) {
            return livres.contains(livre);
        }
        return false;
    }
}
