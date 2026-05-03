package br.com.puc.app;

import br.com.puc.calculadora.Calculadora;
import br.com.puc.calculadora.Cientifica;

public class Application {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Cientifica cientifica = new Cientifica();

        System.out.println("Soma: " + calc.somar(2, 3));
        System.out.println("Potência: " + cientifica.potencia(2, 5));
    }
}
