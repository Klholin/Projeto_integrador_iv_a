package br.com.puc.calculadora;

import br.com.puc.calculadora.Calculadora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class CalculadoraTest {

    Calculadora calc = new Calculadora();

    @Test
    void testSomar() {
        assertEquals(5, calc.somar(2, 3));
    }

    @Test
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calc.dividir(10, 0));
    }

    @Test
    void testHistorico() {
        calc.somar(2, 3);
        calc.subtrair(5, 2);
        List<String> historico = calc.getHistorico();
        assertEquals(2, historico.size());
        assertTrue(historico.get(0).contains("2 + 3 = 5"));
    }
}
