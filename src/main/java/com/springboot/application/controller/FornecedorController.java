package com.springboot.application.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.application.model.Fornecedor;
import com.springboot.application.repository.FornecedorRepository;
import com.springboot.application.repository.ProdutoRepository;

@Controller
public class FornecedorController {
	
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public FornecedorController(FornecedorRepository fornecedorRepository) {
		super();
		this.fornecedorRepository = fornecedorRepository;
	}
	
	@GetMapping("/cadastro/fornecedor")
	public ModelAndView retornaCadastroFornecedor(Fornecedor fornecedor) {
		
		ModelAndView mv = new ModelAndView("cadastro/cadastro_fornecedor");
		mv.addObject("fornecedores", fornecedor);
		mv.addObject("listaProduto", produtoRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastro/fornecedor/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("lista/listar_fornecedor");
		mv.addObject("listaFornecedores", fornecedorRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastro/fornecedor/editar/{id}")
	public ModelAndView editarFornecedor(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("edicao/editar_fornecedor");
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		mv.addObject("fornecedores", fornecedor.get());
		mv.addObject("listaProduto", fornecedor.get().getProduto());
		//mv.addObject("endereco", fornecedor.get().getEndereco());
		return mv;
	}
	
	@GetMapping("/cadastro/fornecedor/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro_remocao/fornecedor_deletado_com_sucesso");
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		
		try {
			fornecedorRepository.delete(fornecedor.get());
			mv.addObject("mensagemFornecedorRemocao", fornecedor);
			return mv;
		}catch(Exception e) {
			
		}
		
		return mv;
	}
	
	@PostMapping("/cadastro/fornecedor/salvar")
	public ModelAndView salvarFornecedor(@Valid Fornecedor fornecedor, BindingResult result) throws Exception {
		ModelAndView mv = new ModelAndView("cadastrado_com_sucesso/fornecedor_cadastrado_com_sucesso");
		if(result.hasErrors()) {
			return retornaCadastroFornecedor(fornecedor);
			
		}
		
		try {
		
			fornecedorRepository.saveAndFlush(fornecedor);
			
			mv.addObject("fornecedores", fornecedor);
			
		}catch(Exception e) {
			ModelAndView mv1 = new ModelAndView("cadastro_exceptions/fornecedor_existente");
			mv1.addObject("mensagemFornecedor" , e);
			return mv1;
		}
		return mv;
		
	}
	
}
