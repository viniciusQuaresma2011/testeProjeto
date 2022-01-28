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

import com.springboot.application.model.Venda;
import com.springboot.application.repository.VendaRepository;

@Controller
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepository;

	public VendaController(VendaRepository vendaRepository) {
		super();
		this.vendaRepository = vendaRepository;
	}
	
	@GetMapping("/cadastro/venda")
	public ModelAndView retornaCadastroVenda(Venda venda) {
		ModelAndView mv = new ModelAndView("cadastro/cadastro_venda");
		mv.addObject("vendas", venda);
		return mv;
	}
	
	@GetMapping("/cadastro/venda/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("lista/listar_venda");
		mv.addObject("listaVendas", vendaRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastro/venda/editar/{id}")
	public ModelAndView editarVenda(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("edicao/editar_venda");
		Optional<Venda> venda = vendaRepository.findById(id);
		mv.addObject("vendas", venda.get());
		return mv;
	}
	
	@GetMapping("/cadastro/venda/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro_remocao/venda_deletado_com_sucesso");
		Optional<Venda> venda = vendaRepository.findById(id);
		try {
			vendaRepository.delete(venda.get());
			mv.addObject("mensagemVendaRemocao", venda);
			return mv;
		}catch(Exception e) {
			
		}
		return mv;
	}
	
	@PostMapping("/cadastro/venda/salvar")
	public ModelAndView salvarVenda ( @Valid Venda venda, BindingResult result) {
		ModelAndView mv = new ModelAndView("cadastrado_com_sucesso/venda_cadastrado_com_sucesso");
		if(result.hasErrors()) {
			return retornaCadastroVenda(venda);
			
		}
		
		try {
			vendaRepository.saveAndFlush(venda);
			mv.addObject("vendas", venda);
		}catch(Exception e) {
			ModelAndView mv1 = new ModelAndView("cadastro_exceptions/venda_existente");
			mv1.addObject("mensagemVenda" , e);
			return mv1;
		}
		return mv;
	}
	
}
