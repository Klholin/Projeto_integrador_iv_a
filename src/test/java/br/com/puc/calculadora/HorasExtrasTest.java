package br.com.puc.calculadora;

import br.com.puc.calculadora.CalculadoraJuridica;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class HorasExtrasTest {

    CalculadoraJuridica calc = new CalculadoraJuridica();

    @ParameterizedTest
    @CsvSource({
            "20.0, 10, 0.5, 300.0",
            "15.0, 8, 0.5, 180.0",
            "30.0, 5, 0.2, 180.0"
    })
    void testHorasExtras(double salarioHora, double horasExtras, double adicional, double esperado) {
        double resultado = calc.calcularHorasExtras(salarioHora, horasExtras, adicional);
        assertEquals(esperado, resultado, 0.01);
    }
}
