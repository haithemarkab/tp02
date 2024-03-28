package org.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {

    @Mock
    Calculatrice calc;
    @Test
    public void testAdditionner() {

        when(calc.additionner(2, 3)).thenReturn(5);

        int result = calc.additionner (2,3);

        Assertions.assertEquals(result,5);

        verify(calc).additionner(2,3);

        verifyNoMoreInteractions(calc);

        int state = calc.getState();

        verify(calc).getState();
    }
}