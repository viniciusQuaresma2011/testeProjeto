package com.springboot.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.lowagie.text.pdf.PdfPCell;

@Entity
@Table(name="estoque")
public class Estoque {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome_estoque", unique=true)
	@NotEmpty
	private String nome;
	
	@Column(name="tipo_estoque")
	@NotEmpty
	private String tipo;
	
	@Column(name="quantidade_estoque")
	@NotEmpty
	private String quantidade;
	
	
	
	
	

	public Estoque() {
		super();
	}

	public Estoque(Long id, String nome, String tipo, String quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	

}
