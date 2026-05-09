package br.com.puc.calculadora;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Parser {

    public double avaliarExpressao(String expressao) {
        try {
            Expression e = new ExpressionBuilder(expressao).build();
            return e.evaluate();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Expressão inválida: " + expressao);
        }
    }
}
