package br.com.puc.calculadora;

public class CalculadoraJuridica {

    // Horas extras
    public double calcularHorasExtras(double salarioHora, double horasExtras, double percentualAdicional) {
        return salarioHora * horasExtras * (1 + percentualAdicional);
    }

    // Adicional noturno
    public double calcularAdicionalNoturno(double salarioHora, double horasNoturnas, double percentualAdicional) {
        return salarioHora * horasNoturnas * (1 + percentualAdicional);
    }

    // Férias proporcionais
    public double calcularFeriasProporcionais(double salarioMensal, int mesesTrabalhados) {
        return (salarioMensal / 12) * mesesTrabalhados;
    }

    // 13º salário proporcional
    public double calcularDecimoTerceiro(double salarioMensal, int mesesTrabalhados) {
        return (salarioMensal / 12) * mesesTrabalhados;
    }

    // Rescisão contratual com multa de 40% do FGTS
    public double calcularRescisao(double salarioMensal, int mesesTrabalhados, double fgts, boolean avisoPrevioIndenizado) {
        double saldoSalario = salarioMensal * mesesTrabalhados;
        double feriasProporcionais = calcularFeriasProporcionais(salarioMensal, mesesTrabalhados);
        double decimoTerceiro = calcularDecimoTerceiro(salarioMensal, mesesTrabalhados);
        double multaFgts = fgts * 0.40;
        double avisoPrevio = avisoPrevioIndenizado ? salarioMensal : 0.0;
        double adicionalFerias = feriasProporcionais / 3; // 1/3 constitucional

        return saldoSalario + feriasProporcionais + adicionalFerias + decimoTerceiro + multaFgts + avisoPrevio;
    }

}

