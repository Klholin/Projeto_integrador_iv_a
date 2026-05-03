package br.com.puc.calculadora;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    private final List<String> historico = new ArrayList<>();

    public int somar(int a, int b) {
        int resultado = a + b;
        historico.add(a + " + " + b + " = " + resultado);
        return resultado;
    }

    public int subtrair(int a, int b) {
        int resultado = a - b;
        historico.add(a + " - " + b + " = " + resultado);
        return resultado;
    }

    public int multiplicar(int a, int b) {
        int resultado = a * b;
        historico.add(a + " * " + b + " = " + resultado);
        return resultado;
    }

    public double dividir(int a, int b) {
        if (b == 0) throw new ArithmeticException("Divisão por zero não permitida");
        double resultado = (double) a / b;
        historico.add(a + " / " + b + " = " + resultado);
        return resultado;
    }

    public List<String> getHistorico() {
        return historico;
    }
}
