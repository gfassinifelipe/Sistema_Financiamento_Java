package modelo;

public class Financiamento {
	private String tipoPropriedade;
	private double valorImovel;
	private int prazoFinanciamentoMeses;
	private double taxaJurosAnual;

	public Financiamento(String tipoPropriedade, double valorImovel, int prazoFinanciamentoMeses, double taxaJurosAnual) {
		
		this.tipoPropriedade = tipoPropriedade;
		this.valorImovel = valorImovel;
		this.prazoFinanciamentoMeses = prazoFinanciamentoMeses;
		this.taxaJurosAnual = taxaJurosAnual;
 }

	public String getTipoPropriedade() {
		return tipoPropriedade;
	}


	public double getValorImovel() {
		return valorImovel;
	}

	public int getPrazoFinanciamentoMeses() { 
		return prazoFinanciamentoMeses;
	}

	public double getTaxaJurosAnual() {
		return taxaJurosAnual;
	}
	
	public int[] prazoAnos() {
		int anos = prazoFinanciamentoMeses / 12;
		int meses = prazoFinanciamentoMeses % 12;
		return new int[]{anos, meses};
	}
		
	public double calcularPagamentoMensal() {
		int meses = prazoFinanciamentoMeses * 12;
		double taxaMensalDecimal = (taxaJurosAnual / 100.0) / 12.0;
		return (valorImovel / meses) * (1 + taxaMensalDecimal);
	}

	public double calcularTotalPagamento() {
		return calcularPagamentoMensal() * (prazoFinanciamentoMeses * 12);
	}

	public void mostrarResumo() {
		int[] prazo = prazoAnos();
		System.out.println("--- Resumo do Financiamento ---");
		System.out.printf("Sua propriedade é uma %s\n", tipoPropriedade);
		System.out.printf("Valor do imóvel: R$ %.2f\n", valorImovel);
		System.out.printf("Prazo: %d Anos e %d meses\n", prazo[0], prazo[1]);
		System.out.printf("Taxa anual (%%): %.4f\n", taxaJurosAnual);
		System.out.printf("Parcela mensal estimada: R$ %.2f\n", calcularPagamentoMensal());
		System.out.printf("Total pago no final: R$ %.2f\n", calcularTotalPagamento());
		System.out.println("-------------------------------");
 }
}