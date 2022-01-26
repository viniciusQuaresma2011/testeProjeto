package com.springboot.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="dispositivo")
public class Dispositivo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome_dispositivo", unique=true)
	@NotEmpty
	private String nome;
	
	@Column(name="imei", unique=true)
	@NotEmpty
	private String imei;
	
	@Column(name="modelo")
	@NotEmpty
	private String modelo;

	
	
	public Dispositivo() {
		super();
	}

	public Dispositivo(Long id, String nome, String imei, String modelo) {
		super();
		this.id = id;
		this.nome = nome;
		this.imei = imei;
		this.modelo = modelo;
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

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
	
}
