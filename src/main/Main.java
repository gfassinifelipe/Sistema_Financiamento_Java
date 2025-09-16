package main;

import java.util.Scanner;
import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== Simulador de Financiamento ===");
		String propriedade = InterfaceUsuario.pedirTipoPropriedade(sc);
		double valor = InterfaceUsuario.pedirValorImovel(sc);
		int prazoMeses = InterfaceUsuario.pedirPrazoFinanciamentoMeses(sc);
		double taxaAnual = InterfaceUsuario.pedirTaxaJurosAnual(sc);
		Financiamento f = new Financiamento(propriedade, valor, prazoMeses, taxaAnual);
		f.mostrarResumo();
		sc.close();
	}
}