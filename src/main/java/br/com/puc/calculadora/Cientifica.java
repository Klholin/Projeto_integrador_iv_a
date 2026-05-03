package br.com.puc.calculadora;

public class Cientifica {

    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    public double raizQuadrada(double valor) {
        if (valor < 0) throw new ArithmeticException("Raiz quadrada de número negativo não permitida");
        return Math.sqrt(valor);
    }

    public double logaritmo(double valor) {
        if (valor <= 0) throw new ArithmeticException("Logaritmo definido apenas para valores positivos");
        return Math.log(valor);
    }

    public double seno(double angulo) {
        return Math.sin(Math.toRadians(angulo));
    }

    public double cosseno(double angulo) {
        return Math.cos(Math.toRadians(angulo));
    }

    public double tangente(double angulo) {
        return Math.tan(Math.toRadians(angulo));
    }
}
