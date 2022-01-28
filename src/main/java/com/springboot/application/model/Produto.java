package com.springboot.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_produto")
	private Long id;
	
	@Column(name="nome_produto", unique=true)
	@NotEmpty
	private String nome;
	
	@Column(name="categoria_produto")
	@NotEmpty
	private String categoria;
	
	@Column(name = "quantidade_produto")
	@NotEmpty
	private String quantidade;
	
	//@Column(name="estoque")
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Estoque estoque;
	
	
	
	

	public Produto(Long id, String nome,String categoria, String quantidade, Estoque estoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.estoque = estoque;
	}

	

	public Produto() {
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	
	
}
