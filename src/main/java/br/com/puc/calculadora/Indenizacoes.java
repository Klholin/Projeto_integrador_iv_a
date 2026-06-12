package br.com.puc.calculadora;

public class Indenizacoes {

    // Multa contratual
    public double calcularMultaContratual(double valorContrato, double percentualMulta) {
        return valorContrato * percentualMulta;
    }

    // Danos materiais
    public double calcularDanosMateriais(double valorPrejuizo) {
        return valorPrejuizo;
    }

    // Danos morais (exemplo simplificado: 3 salários mensais)
    public double calcularDanosMorais(double salarioMensal, int multiplicador) {
        return salarioMensal * multiplicador;
    }

    // Indenização por afastamento
    public double calcularIndenizacaoAfastamento(double salarioMensal, int mesesAfastado) {
        return salarioMensal * mesesAfastado;
    }
}
