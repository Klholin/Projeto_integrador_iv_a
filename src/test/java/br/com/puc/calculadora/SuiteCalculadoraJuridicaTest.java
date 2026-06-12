package br.com.puc.calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuiteCalculadoraJuridicaTest {

    CalculadoraJuridica trabalhista = new CalculadoraJuridica();
    Financeiro financeiro = new Financeiro();
    Indenizacoes indenizacoes = new Indenizacoes();

    // --- Testes trabalhistas ---
    @Test
    void testHorasExtras() {
        assertEquals(300.0, trabalhista.calcularHorasExtras(20.0, 10, 0.5), 0.01);
    }

    @Test
    void testRescisaoComAvisoPrevio() {
        assertEquals(21600.0, trabalhista.calcularRescisao(2400.0, 6, 5000.0, true), 0.01);
    }

    // --- Testes financeiros ---
    @Test
    void testJurosSimples() {
        assertEquals(1200.0, financeiro.calcularJurosSimples(1000.0, 0.02, 10), 0.01);
    }

    @Test
    void testJurosCompostos() {
        assertEquals(1218.99, financeiro.calcularJurosCompostos(1000.0, 0.02, 10), 0.01);
    }

    // --- Testes indenizatórios ---
    @Test
    void testMultaContratual() {
        assertEquals(5000.0, indenizacoes.calcularMultaContratual(100000.0, 0.05), 0.01);
    }

    @Test
    void testIndenizacaoAfastamento() {
        assertEquals(7200.0, indenizacoes.calcularIndenizacaoAfastamento(2400.0, 3), 0.01);
    }

    @Test
    void testJurosMora() {
        // Juros de mora: 1% ao mês
        double resultado = financeiro.calcularJurosMora(1000.0, 12); // 12 meses
        assertEquals(1126.83, resultado, 0.01); // tolerância de 1 centavo
    }

    @Test
    void testCorrecaoMonetaria() {
        // Correção monetária: índice acumulado de 10%
        double resultado = financeiro.aplicarCorrecaoMonetaria(1000.0, 0.10);
        assertEquals(1100.0, resultado, 0.01);
    }

}
