package org.example;

import java.util.HashMap;
import java.util.Map;

public class Emprunt {
    private Bibliotheque bibliotheque;
    private Map<String, Livre> livresEmpruntes = new HashMap<>();
    public Emprunt(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }
    public void emprunterLivre(String utilisateur, Livre livre) {
        if(bibliotheque.contientLivre(livre)){
            bibliotheque.retirerLivre(livre);
            livresEmpruntes.put(utilisateur, livre);
        }
        else{
            System.out.println("Le livre n'est pas disponible");
        }
    }
    public void retournerLivre(String utilisateur) {
        if(livresEmpruntes.containsKey(utilisateur)){
            Livre livre = livresEmpruntes.get(utilisateur);
            bibliotheque.ajouterLivre(livre);
            livresEmpruntes.remove(utilisateur);
        }
        else{
            System.out.println("L'utilisateur n'a pas emprunté de livre");
        }
    }
}

