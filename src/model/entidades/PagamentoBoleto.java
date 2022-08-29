package model.entidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import model.enums.EstadoPagamento;

public class PagamentoBoleto extends Pagamento{
	
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	
	public PagamentoBoleto(
			Integer id, EstadoPagamento estado, Double valor, LocalDate dataVencimento,
			LocalDate dataPagamento
	) {
		super(id, estado, valor);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	public long diasAposPagamento() {
		Period periodo = Period.between(this.dataPagamento, LocalDate.now());
		
		return periodo.getDays();
	}
	
	@Override
	public String relatorio() {
		StringBuilder stringBuilder = new StringBuilder();
		
		DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		stringBuilder.append("Id: " + this.getId());
		stringBuilder.append(", Estado: " + this.getEstado() + ", (Boleto) ");
		stringBuilder.append("Data de Vencimento: " + this.getDataVencimento().format(formatacao));
		stringBuilder.append(", Data Pagamento: " + this.getDataPagamento().format(formatacao));
		stringBuilder.append(", Valor Final: R$" + String.format("%.2f" , this.getValor()));
		stringBuilder.append(" Pago a " + this.diasAposPagamento() + " dias");
		
		return stringBuilder.toString(); 
	}


}
