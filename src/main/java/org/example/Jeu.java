package org.example;

public class Jeu implements InterfaceJeu {
    private boolean ouvert;
    private Banque banque;


    public Jeu(Banque labanque) {
        this.ouvert = true;
        this.banque = labanque;

    }

    @Override
    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException, DebitImpossibleException {
        if (!banque.est_solvable()) {
            ouvert = false;
            throw new JeuFermeException("La banque n'est plus solvable.");
        }

        if (!ouvert) {
            throw new JeuFermeException("Le jeu est fermé.");
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
    public boolean estOuvert() {
        return ouvert;
    }
    @Override
    public void fermer() {
        ouvert = false;
    }


}
