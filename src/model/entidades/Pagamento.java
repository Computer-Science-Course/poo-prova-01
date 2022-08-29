package model.entidades;

import model.enums.EstadoPagamento;

public class Pagamento {
	private Integer id;
	private EstadoPagamento estado;
	private Double valor;
	
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
	
	
}
