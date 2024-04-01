package org.example;

public interface UtilisateurApi {
    void creerUtilisateur(Utilisateur utilisateur) throws ServiceException;
    int creerUtilisateurReturnId(Utilisateur utilisateur) throws ServiceException;
    boolean creerUtilisateurReturnBoolean(Utilisateur utilisateur) throws ServiceException;
}