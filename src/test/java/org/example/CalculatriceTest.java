package org.example;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {
    @Mock
    Calculatrice calc;
    @Test
    public void testAdditionner() {
        when(calc.additionner(9, 10)).thenReturn(19);
        int result = calc.additionner (9,10);
        Assertions.assertEquals(result,19);
        verify(calc).additionner(9,10);
        verifyNoMoreInteractions(calc);
        int state = calc.getState();
        verify(calc).getState();
    }
}