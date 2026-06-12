package br.com.puc.calculadora;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class IntegracaoTest {

    Financeiro financeiro = new Financeiro();
    Indenizacoes indenizacoes = new Indenizacoes();

    @ParameterizedTest
    @CsvSource({
            "10000.0, 0.05, 0.01, 12, 11760.0",   // correto
            "20000.0, 0.10, 0.02, 6, 24640.0",    // corrigido
            "15000.0, 0.03, 0.015, 24, 21012.0",  // corrigido
            "8000.0, 0.02, 0.005, 36, 9628.8",    // corrigido
            "50000.0, 0.20, 0.03, 3, 65400.0"     // corrigido
    })


    void testIndenizacaoAtualizada(double base, double correcao, double juros, int meses, double esperado) {
        // Indenização inicial (exemplo: afastamento já calculado)
        double corrigido = financeiro.aplicarCorrecaoMonetaria(base, correcao);
        double atualizado = financeiro.calcularJurosSimples(corrigido, juros, meses);
        assertEquals(esperado, atualizado, 0.01);
    }
}
