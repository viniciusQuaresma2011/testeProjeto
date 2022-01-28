package com.springboot.application.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="conta_receber")
public class Conta_Receber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String data_venda;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Venda venda;
	
	
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Usuario usuario;
		
	public Conta_Receber() {
		super();
	}

	public Conta_Receber(Long id, String nome, Venda venda, String data_venda, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.venda = venda;
		this.data_venda = data_venda;
		
		this.usuario = usuario;
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

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	

	
	public String getData_venda() {
		return data_venda;
	}

	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
