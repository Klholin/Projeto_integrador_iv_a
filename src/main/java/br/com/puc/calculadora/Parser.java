package br.com.puc.calculadora;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Parser {

    public double avaliarExpressao(String expressao) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        try {
            Object resultado = engine.eval(expressao);
            return Double.parseDouble(resultado.toString());
        } catch (ScriptException e) {
            throw new IllegalArgumentException("Expressão inválida: " + expressao);
        }
    }
}
