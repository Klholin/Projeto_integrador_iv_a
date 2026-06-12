package br.com.puc.app;

import br.com.puc.calculadora.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraJuridica cj = new CalculadoraJuridica();
        Financeiro fin = new Financeiro();
        Indenizacoes ind = new Indenizacoes();
        DecimalFormat df = new DecimalFormat("#.00");

        while (true) {
            System.out.println("\n=== Calculadora Jurídica ===");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Calcular Horas Extras");
            System.out.println("2 - Calcular Rescisão");
            System.out.println("3 - Calcular Juros Compostos");
            System.out.println("4 - Calcular Multa Contratual");
            System.out.println("5 - Calcular Juros Legais e Correção Monetária");
            System.out.println("0 - Sair");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Salário mensal: ");
                    double salarioMensal = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Horas trabalhadas por semana: ");
                    double horasSemana = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    // cálculo do salário hora
                    double salarioHora = salarioMensal / (horasSemana * 4);

                    System.out.print("Horas extras: ");
                    double horasExtras = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Percentual adicional (ex: 0.5 para 50%): ");
                    double adicional = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    double resultadoHE = cj.calcularHorasExtras(salarioHora, horasExtras, adicional);
                    System.out.println("Resultado: " + df.format(resultadoHE));
                    break;

                case 2:
                    System.out.print("Salário mensal: ");
                    double salarioMensalResc = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Meses trabalhados: ");
                    int meses = Integer.parseInt(scanner.nextLine());

                    System.out.print("FGTS acumulado: ");
                    double fgts = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Aviso prévio indenizado (true/false): ");
                    boolean avisoPrevio = Boolean.parseBoolean(scanner.nextLine());

                    double resultadoRescisao = cj.calcularRescisao(salarioMensalResc, meses, fgts, avisoPrevio);
                    System.out.println("Resultado: " + df.format(resultadoRescisao));
                    break;

                case 3:
                    System.out.print("Valor principal: ");
                    double principal = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Taxa mensal (ex: 0.02 para 2%): ");
                    double taxa = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Meses: ");
                    int periodo = Integer.parseInt(scanner.nextLine());

                    // juros compostos: M = P * (1 + i)^n
                    double resultadoJuros = principal * Math.pow(1 + taxa, periodo);
                    System.out.println("Resultado: " + df.format(resultadoJuros));
                    break;

                case 4:
                    System.out.print("Valor do contrato: ");
                    double contrato = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Percentual da multa (ex: 0.05 para 5%): ");
                    double percentualMulta = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    double resultadoMulta = ind.calcularMultaContratual(contrato, percentualMulta);
                    System.out.println("Resultado: " + df.format(resultadoMulta));
                    break;

                case 5:
                    System.out.print("Valor principal: ");
                    double valorPrincipal = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Meses em atraso: ");
                    int mesesAtraso = Integer.parseInt(scanner.nextLine());

                    double resultadoMora = fin.calcularJurosMora(valorPrincipal, mesesAtraso);
                    System.out.println("Valor com juros de mora: " + df.format(resultadoMora));

                    System.out.print("Índice acumulado de correção (ex: 0.12 para 12%): ");
                    double indice = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    double resultadoCorrecao = fin.aplicarCorrecaoMonetaria(valorPrincipal, indice);
                    System.out.println("Valor corrigido monetariamente: " + df.format(resultadoCorrecao));
                    break;


                case 0:
                    System.out.println("Encerrando a calculadora...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("\nDigite 1 para continuar ou 0 para sair:");
            int continuar = Integer.parseInt(scanner.nextLine());
            if (continuar == 0) {
                System.out.println("Encerrando a calculadora...");
                scanner.close();
                break;
            }
        }
    }
}
