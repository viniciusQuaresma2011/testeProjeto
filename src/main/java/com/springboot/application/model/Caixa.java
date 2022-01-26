package com.springboot.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="caixa")
public class Caixa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotEmpty
	private String saldo_positivo;
	
	@Column
	@NotEmpty
	private String saldo_negativo;
	
	@Column
	@NotEmpty
	private String saldo_total;

	public Caixa() {
		super();
	}

	public Caixa(Long id, String saldo_positivo, String saldo_negativo, String saldo_total) {
		super();
		this.id = id;
		this.saldo_positivo = saldo_positivo;
		this.saldo_negativo = saldo_negativo;
		this.saldo_total = saldo_total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSaldo_positivo() {
		return saldo_positivo;
	}

	public void setSaldo_positivo(String saldo_positivo) {
		this.saldo_positivo = saldo_positivo;
	}

	public String getSaldo_negativo() {
		return saldo_negativo;
	}

	public void setSaldo_negativo(String saldo_negativo) {
		this.saldo_negativo = saldo_negativo;
	}

	public String getSaldo_total() {
		return saldo_total;
	}

	public void setSaldo_total(String saldo_total) {
		this.saldo_total = saldo_total;
	}
}
