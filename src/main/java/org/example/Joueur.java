package org.example;

public interface Joueur {
    public int mise();
    public void debiter(int somme) throws DebitImpossibleException;
    public void crediter(int somme);
}