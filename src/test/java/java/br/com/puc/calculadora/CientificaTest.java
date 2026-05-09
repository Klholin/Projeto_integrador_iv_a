package java.br.com.puc.calculadora;

import br.com.puc.calculadora.Cientifica;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CientificaTest {

    Cientifica cientifica = new Cientifica();

    @Test
    void testPotencia() {
        assertEquals(8.0, cientifica.potencia(2, 3));
    }

    @Test
    void testRaizQuadradaNegativa() {
        assertThrows(ArithmeticException.class, () -> cientifica.raizQuadrada(-9));
    }

    @Test
    void testSeno() {
        assertEquals(0.0, cientifica.seno(0), 0.0001);
    }
}
