package main;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        System.out.println("=== Simulador de Financiamento ===");

        String continuar;
        do {
            System.out.println("\n--- Novo Financiamento ---");
            
            String tipoPropriedade = InterfaceUsuario.pedirTipoPropriedade(sc);
            double valorImovel = InterfaceUsuario.pedirValorImovel(sc);
            int prazoMeses = InterfaceUsuario.pedirPrazoFinanciamentoMeses(sc);
            double taxaAnual = InterfaceUsuario.pedirTaxaJurosAnual(sc);

            Financiamento novoFinanciamento = new Financiamento(tipoPropriedade, valorImovel, prazoMeses, taxaAnual);
            
            financiamentos.add(novoFinanciamento);

            System.out.println("\n--- Resumo do Financiamento Cadastrado ---");
            novoFinanciamento.mostrarResumo();
            System.out.println("----------------------------------------");

            System.out.print("\nDeseja cadastrar outro financiamento? (S/N): ");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("S"));

        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;
        int contador = 1;

        System.out.println("\n========= Resumo de TODOS os Financiamentos =========");
        for (Financiamento f : financiamentos) {
            System.out.printf("\n--- Financiamento %d ---\n", contador++);
            f.mostrarResumo();
            totalValorImoveis += f.getValorImovel();
            totalValorFinanciamentos += f.calcularTotalPagamento();
        }
        
        System.out.println("\n======================= Totais =======================");
        System.out.printf("Total de todos os imóveis: R$ %.2f\n", totalValorImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f\n", totalValorFinanciamentos);
        System.out.println("======================================================");

        sc.close();
    }
}