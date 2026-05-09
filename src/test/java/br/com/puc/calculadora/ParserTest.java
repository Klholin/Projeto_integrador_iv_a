package br.com.puc.calculadora;

import br.com.puc.calculadora.Parser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    Parser parser = new Parser();

    @Test
    void testExpressaoSimples() {
        assertEquals(7.0, parser.avaliarExpressao("3 + 4"));
    }

    @Test
    void testExpressaoComMultiplicacao() {
        assertEquals(11.0, parser.avaliarExpressao("3 + 4 * 2"));
    }

    @Test
    void testExpressaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> parser.avaliarExpressao("3 + * 2"));
    }
}