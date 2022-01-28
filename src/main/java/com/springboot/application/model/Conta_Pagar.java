package com.springboot.application.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="conta_pagar")
public class Conta_Pagar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotEmpty
	private String nome;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Fornecedor fornecedor;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Produto produto;
	
	@Column
	
	private String numero_nota;
	
	@Column
	@NotEmpty
	
	private String data_entrada;
	
	@Column
	@NotEmpty
	
	private String data_vencimento;
	
	@Column
	
	private String valor;

	
	
	
	public Conta_Pagar(Long id, String nome, Fornecedor fornecedor, Produto produto, String numero_nota,
			@NotEmpty String data_entrada, @NotEmpty String data_vencimento, String valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.numero_nota = numero_nota;
		this.data_entrada = data_entrada;
		this.data_vencimento = data_vencimento;
		this.valor = valor;
	}




	public Conta_Pagar() {
	super();
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




	public Fornecedor getFornecedor() {
		return fornecedor;
	}




	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}




	public Produto getProduto() {
		return produto;
	}




	public void setProduto(Produto produto) {
		this.produto = produto;
	}




	public String getNumero_nota() {
		return numero_nota;
	}




	public void setNumero_nota(String numero_nota) {
		this.numero_nota = numero_nota;
	}




	public String getData_entrada() {
		return data_entrada;
	}




	public void setData_entrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}




	public String getData_vencimento() {
		return data_vencimento;
	}




	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}




	public String getValor() {
		return valor;
	}




	public void setValor(String valor) {
		this.valor = valor;
	}

	

}
