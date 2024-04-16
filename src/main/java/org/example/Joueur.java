package org.example;

public interface Joueur {
    public int mise();
    public void crediter(int somme);
    public void debiter(int somme) throws DebitImpossibleException;

}