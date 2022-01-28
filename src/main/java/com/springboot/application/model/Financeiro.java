package com.springboot.application.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="financeiro")
public class Financeiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Conta_Pagar conta_pagar;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Conta_Receber conta_receber;
	
	@OneToOne( cascade = CascadeType.ALL, orphanRemoval = true )
	@PrimaryKeyJoinColumn
	private Caixa caixa;

	public Financeiro() {
		super();
	}

	public Financeiro(Long id, String nome, Conta_Pagar conta_pagar, Conta_Receber conta_receber, Caixa caixa) {
		super();
		this.id = id;
		this.nome = nome;
		this.conta_pagar = conta_pagar;
		this.conta_receber = conta_receber;
		this.caixa = caixa;
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

	public Conta_Pagar getConta_pagar() {
		return conta_pagar;
	}

	public void setConta_pagar(Conta_Pagar conta_pagar) {
		this.conta_pagar = conta_pagar;
	}

	public Conta_Receber getConta_receber() {
		return conta_receber;
	}

	public void setConta_receber(Conta_Receber conta_receber) {
		this.conta_receber = conta_receber;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
}
