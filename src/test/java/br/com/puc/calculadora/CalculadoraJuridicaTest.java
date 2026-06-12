package br.com.puc.calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraJuridicaTest {

    CalculadoraJuridica calc = new CalculadoraJuridica();

    @Test
    void testHorasExtras() {
        double resultado = calc.calcularHorasExtras(20.0, 10, 0.5); // 20/hora, 10 horas, 50% adicional
        assertEquals(300.0, resultado, 0.01);
    }

    @Test
    void testAdicionalNoturno() {
        double resultado = calc.calcularAdicionalNoturno(20.0, 5, 0.2); // 20/hora, 5 horas, 20% adicional
        assertEquals(120.0, resultado, 0.01);
    }

    @Test
    void testFeriasProporcionais() {
        double resultado = calc.calcularFeriasProporcionais(2400.0, 6); // salário 2400, 6 meses
        assertEquals(1200.0, resultado, 0.01);
    }

    @Test
    void testDecimoTerceiro() {
        double resultado = calc.calcularDecimoTerceiro(2400.0, 6); // salário 2400, 6 meses
        assertEquals(1200.0, resultado, 0.01);
    }

    @Test
    void testRescisaoComAvisoPrevio() {
        double resultado = calc.calcularRescisao(2400.0, 6, 5000.0, true);
        // saldo salário = 14400
        // férias proporcionais = 1200
        // adicional férias = 400
        // 13º = 1200
        // multa FGTS = 2000
        // aviso prévio = 2400
        // total esperado = 21600
        assertEquals(21600.0, resultado, 0.01);
    }

    @Test
    void testRescisaoSemAvisoPrevio() {
        double resultado = calc.calcularRescisao(2400.0, 6, 5000.0, false);
        // saldo salário = 14400
        // férias proporcionais = 1200
        // adicional férias = 400
        // 13º = 1200
        // multa FGTS = 2000
        // aviso prévio = 0
        // total esperado = 19200
        assertEquals(19200.0, resultado, 0.01);
    }

}
