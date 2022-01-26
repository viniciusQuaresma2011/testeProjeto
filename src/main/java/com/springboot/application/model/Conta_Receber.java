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
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Venda venda;
	
	@Column
	@NotEmpty
	private LocalDate dia_venda;
	
	@Column
	@NotEmpty
	private LocalTime hora_venda;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Usuario usuario;
		
	public Conta_Receber() {
		super();
	}

	public Conta_Receber(Long id, String nome, Venda venda, LocalDate dia_venda, LocalTime hora_venda, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.venda = venda;
		this.dia_venda = dia_venda;
		this.hora_venda = hora_venda;
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

	public LocalDate getDia_venda() {
		return dia_venda;
	}

	public void setDia_venda(LocalDate dia_venda) {
		this.dia_venda = dia_venda;
	}

	public LocalTime getHora_venda() {
		return hora_venda;
	}

	public void setHora_venda(LocalTime hora_venda) {
		this.hora_venda = hora_venda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
