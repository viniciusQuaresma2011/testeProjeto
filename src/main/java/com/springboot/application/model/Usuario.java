package com.springboot.application.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", unique=true)
	@NotEmpty
	private String nome;
	
	@Column(name="email", unique=true )
	@NotEmpty
	private String email;
	
	@Column(name="nome_usuario", unique=true)
	@NotEmpty
	private String nomeUsuario;
	
	@Column(name="filial")
	@NotEmpty
	private String filial;
	
	
	@Column(name="setor")
	@NotEmpty
	private String setor;
	
	@Column(name="funcao")
	@NotEmpty
	private String funcao;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="conexao_usuario_dispositivo")
	private Dispositivo dispositivo;
	

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String email, String nomeUsuario, String filial, String setor, String funcao,Dispositivo dispositivo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.nomeUsuario = nomeUsuario;
		this.filial = filial;
		this.setor = setor;
		this.funcao = funcao;
		this.dispositivo = dispositivo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
	
	
	
}
