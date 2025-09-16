package util;

import java.util.Scanner;

public class InterfaceUsuario {
	public static double pedirValorImovel(Scanner sc) {
		while (true) {
			System.out.print("Valor do imóvel: ");
			System.out.flush();
			try {
				double valor = Double.parseDouble(sc.nextLine().replace(',', '.'));
				if (valor > 0)
					return valor;
				System.out.println("Erro: valor deve ser positivo.");
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida.");
			}
		}
	}

	public static int pedirPrazoFinanciamentoMeses(Scanner sc) {
		while (true) {
			System.out.print("Prazo (meses): ");
			try {
				int meses = Integer.parseInt(sc.nextLine());
				if (meses > 0)
					return meses;
				System.out.println("Erro: prazo deve ser positivo.");
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida.");
			}
		}
	}

	public static double pedirTaxaJurosAnual(Scanner sc) {
		while (true) {
			System.out.print("Taxa de juros anual (%): ");
			try {
				double taxa = Double.parseDouble(sc.nextLine().replace(',', '.'));
				if (taxa > 0)
					return taxa;
				System.out.println("Erro: taxa deve ser positiva.");
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida.");
			}
		}
	}
	
	public static String pedirTipoPropriedade(Scanner sc) {
        while (true) {
            System.out.print("Tipo de propriedade (Casa, Terreno, Apartamento): ");
            String tipo = sc.nextLine().trim();
            if (tipo.equalsIgnoreCase("Casa") ||
                tipo.equalsIgnoreCase("Terreno") ||
                tipo.equalsIgnoreCase("Apartamento")) {
                return tipo;
            } else {
                System.out.println("Erro: tipo de propriedade inválido. Tente novamente.");
            }
        }
    }
}