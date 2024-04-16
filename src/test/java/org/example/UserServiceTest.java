package org.example;
import org.mockito.Captor;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

@RunWith(MockitoJUnitRunner.class)

public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Test
    public void test_creé_user() throws ServiceException {
//TODO Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont",
                "jeandupont@email.com");

// TODO : Configuration du comportement du mock, utiliser la

        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
// TODO : Création du service avec le mock

        UserService userService = new UserService(utilisateurApiMock);
// TODO : Appel de la méthode à tester

        userService.creerUtilisateur(utilisateur);
// TODO : Vérification de l'appel à l'API

        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }
    @Test
    public void test_creé_user_avec_exception() throws ServiceException {

        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        ServiceException serviceException = new ServiceException("Echec de la création de l'utilisateur");
        doThrow(serviceException).when(utilisateurApiMock).creerUtilisateur(utilisateur);
        UserService userService = new UserService(utilisateurApiMock);
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }
    @Test
    public void test_creé_user_avec_return() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        when(utilisateurApiMock.creerUtilisateurReturnBoolean(utilisateur)).thenReturn(true);
        int idUtilisateur = 123;
        when(utilisateurApiMock.creerUtilisateurReturnId(utilisateur)).thenReturn(idUtilisateur);
        UserService userService = new UserService(utilisateurApiMock);
        assertTrue(userService.creerUtilisateurReturnBoolean(utilisateur));
        int utilisateurId = userService.creerUtilisateurReturnId(utilisateur);
        verify(utilisateurApiMock).creerUtilisateurReturnBoolean(utilisateur);
        verify(utilisateurApiMock).creerUtilisateurReturnId(utilisateur);
        assertEquals(idUtilisateur, utilisateurId);

    }


    @Captor
    private ArgumentCaptor<Utilisateur> argumentCaptor;

    @Test
    public void test_creé_user_avec_captur() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        when(utilisateurApiMock.creerUtilisateurReturnBoolean(any(Utilisateur.class))).thenReturn(true);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        System.out.println(utilisateurCapture);
        assertEquals("Jean", utilisateurCapture.getFirstName());
        assertEquals("Dupont", utilisateurCapture.getLastName());
        assertEquals("jeandupont@email.com", utilisateurCapture.getEmail());
    }
    @Test
    public void test_creé_user_error_validation() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur(null, null, null);
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
        verify(utilisateurApiMock, never()).creerUtilisateur(utilisateur);
    }
}