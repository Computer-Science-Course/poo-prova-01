package model.entidades;

import model.enums.EstadoPagamento;

public class PagamentoCartaoDeCredito extends Pagamento {
	
	private Integer numeroParcelas;
	private Double taxaJuros;

	public PagamentoCartaoDeCredito(
			Integer id,
			EstadoPagamento estado,
			Double valor,
			Integer numeroParcelas,
			Double taxaJuros
			) {
		super(id, estado, valor);
		this.numeroParcelas = numeroParcelas;
		this.taxaJuros = taxaJuros;
	}


	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public Double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(Double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	@Override
	public Double valorFinal() {
		return (this.getValor() * (1 + this.getTaxaJuros()));
	}
	
	@Override
	public String relatorio() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Id: " + this.getId());
		stringBuilder.append(", Estado: " + this.getEstado() + ", (CARTÃO) ");
		stringBuilder.append("Número de parcelas: " + this.getNumeroParcelas());
		stringBuilder.append(", Valor Final: R$" + String.format("%.2f" , this.valorFinal()));
		
		return stringBuilder.toString(); 
	}
}
