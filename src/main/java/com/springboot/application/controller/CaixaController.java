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

import com.springboot.application.model.Caixa;
import com.springboot.application.repository.CaixaRepository;

@Controller
public class CaixaController {
	
	@Autowired
	private CaixaRepository caixaRepository;

	public CaixaController(CaixaRepository caixaRepository) {
		super();
		this.caixaRepository = caixaRepository;
	}
	
	@GetMapping("/cadastro/caixa")
	public ModelAndView retornaCadastroCaixa(Caixa caixa) {
		ModelAndView mv = new ModelAndView("cadastro/cadastro_caixa");
		
		mv.addObject("caixas", caixa);
		return mv;
	}
	
	@GetMapping("/cadastro/caixa/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("lista/listar_caixa");
		mv.addObject("listaCaixas", caixaRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastro/caixa/editar/{id}")
	public ModelAndView editarCaixa(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("edicao/editar_caixa");
		Optional<Caixa> caixa = caixaRepository.findById(id);
		mv.addObject("caixas", caixa.get());
		return mv;
	}
	
	@GetMapping("/cadastro/caixa/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro_remocao/caixa_deletado_com_sucesso");
		Optional<Caixa> caixa = caixaRepository.findById(id);
		
		try {
			caixaRepository.delete(caixa.get());
			mv.addObject("mensagemCaixaRemocao", caixa);
			return mv;
		}catch(Exception e) {
			
		}
		
		return mv;
	}
	
	@PostMapping("/cadastro/caixa/salvar")
	public ModelAndView salvarUsuario(@Valid Caixa caixa, BindingResult result) {
		ModelAndView mv = new ModelAndView("cadastrado_com_sucesso/caixa_cadastrado_com_sucesso");
		if(result.hasErrors()) {
			return retornaCadastroCaixa(caixa);
		}
		
		try {
			caixaRepository.saveAndFlush(caixa);
			mv.addObject("caixas", caixa);
		}catch(Exception e) {
			ModelAndView mv1 = new ModelAndView("cadastro_exceptions/caixa_existente");
			mv1.addObject("mensagemCaixa" , e);
			return mv1;
		}
		
		return mv;
	}
	
	
	
}
