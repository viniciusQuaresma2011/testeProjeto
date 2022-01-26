package com.springboot.application.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.application.model.Conta_Pagar;
import com.springboot.application.repository.Conta_PagarRepository;
import com.springboot.application.repository.FornecedorRepository;
import com.springboot.application.repository.ProdutoRepository;

@RestController
public class Conta_PagarController {
	
	
	@Autowired
	private Conta_PagarRepository conta_pagarRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Conta_PagarController(Conta_PagarRepository conta_pagarRepository) {
		super();
		this.conta_pagarRepository = conta_pagarRepository;
	}
	
	@GetMapping("/cadastro/conta_pagar")
	public ModelAndView retornaCadastroConta_Pagar(Conta_Pagar conta_pagar) {
		ModelAndView mv = new ModelAndView("cadastro/cadastro_conta_pagar");
		mv.addObject("contas_pagar", conta_pagar);
		mv.addObject("listaFornecedores", fornecedorRepository.findAll());
		mv.addObject("listaProdutos", produtoRepository.findAll());
		
		return mv;
		
	}
	
	@GetMapping("/cadastro/conta_pagar/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("lista/listar_conta_pagar");
		mv.addObject("listaConta_Pagar", conta_pagarRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastro/conta_pagar/editar/{id}")
	public ModelAndView editarConta_Pagar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("edicao/editar_conta_pagar");
		Optional<Conta_Pagar> conta_pagar = conta_pagarRepository.findById(id);
		mv.addObject("contas_pagar", conta_pagar.get());
		mv.addObject("listaFornecedores", conta_pagar.get().getFornecedor());
		mv.addObject("listaProdutos", conta_pagar.get().getProduto());
		return mv;
	}
	
	@GetMapping("/cadastro/conta_pagar/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro_remocao/conta_pagar_deletado_com_sucesso");
		Optional<Conta_Pagar> conta_pagar = conta_pagarRepository.findById(id);
		try {
			conta_pagarRepository.delete(conta_pagar.get());
			mv.addObject("mensagemConta_pagarRemocao", conta_pagar);
			return mv;
		}catch(Exception e) {
			
		}
		return mv;
	}
	
	
	@PostMapping("/cadastro/conta_pagar/salvar" )
	public ModelAndView salvarConta_Pagar(@Valid Conta_Pagar conta_pagar, BindingResult result) {
		ModelAndView mv = new ModelAndView("cadastrado_com_sucesso/conta_pagar_cadastrado_com_sucesso");
		if(result.hasErrors()) {
			return retornaCadastroConta_Pagar(conta_pagar);
		}
		
		
		try {
			conta_pagarRepository.save(conta_pagar);
			mv.addObject("contas_pagar", conta_pagar);
			
		}catch(Exception e) {
			ModelAndView mv1 = new ModelAndView("cadastro_exceptions/conta_pagar_existente");
			mv1.addObject("mensagemConta_pagar" , e);
			return mv1;
		}
		
		return mv;
	}
	
}
