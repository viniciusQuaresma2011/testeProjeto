package com.springboot.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Usuario;
import com.springboot.application.repository.UsuarioRepository;
import com.springboot.application.service.UsuarioService;

@Service
public class UsuarioServiceImpl  implements UsuarioService{
	
	
	private UsuarioRepository usuarioRepository;
	
	private UsuarioService usuarioService;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	

	@Override
	public List<Usuario> buscarTodosUsuarios() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario pegarUsuarioPeloId(Long id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public Usuario atualizarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void apagarUsuarioPeloId(Long id) {
		usuarioRepository.deleteById(id);
		
	}
	
	

}
