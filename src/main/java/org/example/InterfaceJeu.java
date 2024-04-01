package org.example;

public interface InterfaceJeu {
    void jouer(Joueur joueur, De d1, De d2) throws JeuFermeException, DebitImpossibleException;
    void fermer();
    boolean estOuvert();
}