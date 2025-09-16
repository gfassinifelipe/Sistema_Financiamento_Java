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
    
    public double calcularPagamentoMensal() {
        double taxaMensal = (this.taxaJurosAnual / 100) / 12;
        int prazo = this.prazoFinanciamentoMeses;
        
        double pagamentoMensal = this.valorImovel * (taxaMensal * Math.pow(1 + taxaMensal, prazo)) / (Math.pow(1 + taxaMensal, prazo) - 1);
        return pagamentoMensal;
    }

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * this.prazoFinanciamentoMeses;
    }

    public void mostrarResumo() {
        System.out.printf("Tipo da propriedade: %s\n", this.tipoPropriedade);
        System.out.printf("Valor do imóvel: R$ %.2f\n", this.valorImovel);

        if (this.prazoFinanciamentoMeses < 12) {
            System.out.printf("Prazo: %d meses\n", this.prazoFinanciamentoMeses);
        } else {
            int anos = this.prazoFinanciamentoMeses / 12;
            int meses = this.prazoFinanciamentoMeses % 12;
            System.out.printf("Prazo: %d anos e %d meses\n", anos, meses);
        }

        System.out.printf("Taxa de juros anual: %.2f%%\n", this.taxaJurosAnual);
        System.out.printf("Total a ser pago: R$ %.2f\n", this.calcularTotalPagamento());
        System.out.printf("Valor da parcela mensal: R$ %.2f\n", this.calcularPagamentoMensal());
    }
}