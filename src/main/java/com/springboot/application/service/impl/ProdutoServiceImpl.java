package com.springboot.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Produto;
import com.springboot.application.repository.ProdutoRepository;
import com.springboot.application.service.ProdutoService;


@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	
	private ProdutoRepository produtoRepository;
	
	
	
	
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}

	@Override
	public List<Produto> buscarTodosOsProdutos() {
		
		return produtoRepository.findAll();
	}

	@Override
	public Produto salvarProduto(Produto produto) {
		
		return produtoRepository.save(produto);
	}

	@Override
	public Produto pegarProdutoPeloId(Long id) {
		
		return produtoRepository.findById(id).get();
	}
	
	@Override
	public Produto atualizarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@Override
	public void apagarUsuarioPeloId(Long id) {
		produtoRepository.deleteById(id);
		
	}
	

	
}
