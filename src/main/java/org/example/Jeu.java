package org.example;

public class Jeu implements InterfaceJeu {
    private Banque banque;
    private boolean ouvert;

    public Jeu(Banque labanque) {
        this.banque = labanque;
        this.ouvert = true;
    }

    @Override
    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException, DebitImpossibleException {
        if (!ouvert) {
            throw new JeuFermeException("Le jeu est fermé.");
        }

        if (!banque.est_solvable()) {
            ouvert = false;
            throw new JeuFermeException("La banque n'est plus solvable.");
        }

        int sommeDes = de1.lancer() + de2.lancer();

        if (sommeDes == 7) {
            joueur.crediter(2 * joueur.mise());
            banque.debiter(2 * joueur.mise());
            if (!banque.est_solvable()) {
                ouvert = false;
                throw new JeuFermeException("La banque n'est plus solvable.");
            }
        } else {
            joueur.debiter(joueur.mise());
        }
    }

    @Override
    public void fermer() {
        ouvert = false;
    }

    @Override
    public boolean estOuvert() {
        return ouvert;
    }
}
