package com.springboot.application.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String fechamento_dia;
	
	@Column
	private String valor_total;
	
	

	public Venda() {
		super();
	}



	public Venda(Long id, String nome, String fechamento_dia, String valor_total) {
		super();
		this.id = id;
		this.nome = nome;
		this.fechamento_dia = fechamento_dia;
		this.valor_total = valor_total;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getFechamento_dia() {
		return fechamento_dia;
	}



	public void setFechamento_dia(String fechamento_dia) {
		this.fechamento_dia = fechamento_dia;
	}



	public String getValor_total() {
		return valor_total;
	}



	public void setValor_total(String valor_total) {
		this.valor_total = valor_total;
	}
	
	
	

}
