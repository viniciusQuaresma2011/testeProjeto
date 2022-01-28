package com.springboot.application.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	@NotBlank(message = "Favor informar a rua")
	private String rua;
	
	@Column(unique=true)
	@NotBlank(message = "Favor informar o cep")
	private String cep;
	
	@Column(unique=true)
	@NotBlank(message = "Favor informar o estado")
	private String estado;
	
	@Column(unique=true)
	@NotBlank(message = "Favor informar o logradouro")
	private String logradouro;
	
	@Column(unique=true)
	@NotBlank(message = "Favor informar o ponto de referencia")
	private String ponto_referencia;
	
	


	public Endereco() {
		super();
	}

	public Endereco(Long id, String rua, String cep, String estado, String logradouro, String ponto_referencia
		) {
		super();
		this.id = id;
		this.rua = rua;
		this.cep = cep;
		this.estado = estado;
		this.logradouro = logradouro;
		this.ponto_referencia = ponto_referencia;
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getPonto_referencia() {
		return ponto_referencia;
	}

	public void setPonto_referencia(String ponto_referencia) {
		this.ponto_referencia = ponto_referencia;
	}

	
	
}
