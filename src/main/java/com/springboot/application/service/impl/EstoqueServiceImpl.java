package com.springboot.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Estoque;
import com.springboot.application.repository.EstoqueRepository;
import com.springboot.application.service.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService{
	
	private EstoqueRepository estoqueRepository;

	public EstoqueServiceImpl(EstoqueRepository estoqueRepository) {
		super();
		this.estoqueRepository = estoqueRepository;
	}

	

	@Override
	public List<Estoque> buscarTodosOsEstoques() {
		return estoqueRepository.findAll();
	}

	@Override
	public Estoque salvarEstoque(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	@Override
	public Estoque pegarEstoquePeloId(Long id) {
		return estoqueRepository.findById(id).get();
	}

	@Override
	public Estoque atualizarEstoque(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	@Override
	public void apagarEstoquePeloId(Long id) {
		estoqueRepository.deleteById(id);
		
	}
	
	
	
}
