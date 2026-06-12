package br.com.puc.calculadora;

public class Financeiro {

    // Juros simples
    public double calcularJurosSimples(double valorPrincipal, double taxaMensal, int meses) {
        return valorPrincipal + (valorPrincipal * taxaMensal * meses);
    }

    // Juros compostos
    public double calcularJurosCompostos(double valorPrincipal, double taxaMensal, int meses) {
        return valorPrincipal * Math.pow(1 + taxaMensal, meses);
    }

    // Juros de mora (1% ao mês, conforme Código Civil)
    public double calcularJurosMora(double valorPrincipal, int meses) {
        return valorPrincipal * Math.pow(1.01, meses);
    }

    // Correção monetária (índice acumulado, ex: INPC/IPCA-E)
    public double aplicarCorrecaoMonetaria(double valorPrincipal, double indiceAcumulado) {
        return valorPrincipal * (1 + indiceAcumulado);
    }
}
