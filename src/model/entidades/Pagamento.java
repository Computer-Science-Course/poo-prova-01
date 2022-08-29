package model.entidades;

import model.enums.EstadoPagamento;

public class Pagamento {
	private Integer id;
	private EstadoPagamento estado;
	private Double valor;
	
	public Pagamento(Integer id, EstadoPagamento estado, Double valor) {
		this.id = id;
		this.estado = estado;
		this.valor = valor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EstadoPagamento getEstado() {
		return estado;
	}
	public void setEstado(EstadoPagamento estado) {
		this.estado = estado;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Double valorFinal() {
		return this.getValor();
	}
	
	public String relatorio() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Id: " + this.getId());
		stringBuilder.append(", Estado: " + this.getEstado());
		stringBuilder.append(", Valor: " + this.getValor());
		
		return stringBuilder.toString(); 
	}
	
}
