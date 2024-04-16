package org.example;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JeuTest {

    @Test
    public void testJeuFerme() {
        Banque Banque_M= mock(Banque.class);
        InterfaceJeu jeu = new Jeu(Banque_M);
        Joueur joueur_M = mock(Joueur.class);
        De Mock1 = mock(De.class);
        De Mock2 = mock(De.class);
        jeu.fermer();
        assertThrows(JeuFermeException.class, () -> jeu.jouer(joueur_M, Mock1, Mock2));
    }
    @Test
    public void testBanqueInsolvableApresGain() throws JeuFermeException, DebitImpossibleException {
        // Arrange
        Banque banque = new BanqueImt(15, 20);
        Joueur joueur = mock(Joueur.class);
        when(joueur.mise()).thenReturn(10);
        InterfaceJeu jeu = new Jeu(banque);
        De de1 = mock(De.class);
        De de2 = mock(De.class);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);
        assertThrows(JeuFermeException.class, () -> jeu.jouer(joueur, de1, de2));
    }

    @Test
    public void testJoueurInsolvable() throws JeuFermeException, DebitImpossibleException {
        Banque banqueMock = mock(Banque.class);
        when(banqueMock.est_solvable()).thenReturn(true);
        Joueur joueurMock = mock(Joueur.class);
        when(joueurMock.mise()).thenReturn(10);
        doThrow(DebitImpossibleException.class).when(joueurMock).debiter(anyInt());
        InterfaceJeu jeu = new Jeu(banqueMock);
        De Mock1 = mock(De.class);
        De Mock2 = mock(De.class);
        try {
            jeu.jouer(joueurMock, Mock1, Mock2);
        } catch (DebitImpossibleException e) {
        }
        verify(Mock1, never()).lancer();
        verify(Mock2, never()).lancer();
    }



}