package org.example;


    public class BanqueImt implements Banque {
        private int fond;
        private final int fondMinimum;

        public BanqueImt(int fondInitial, int fondMinimum) {
            this.fond = fondInitial;
            this.fondMinimum = fondMinimum;
        }

        @Override
        public void crediter(int somme) {
            fond += somme;
        }

        @Override
        public boolean est_solvable() {
            return fond >= fondMinimum;
        }

        @Override
        public void debiter(int somme) {
            fond -= somme;
        }

}
