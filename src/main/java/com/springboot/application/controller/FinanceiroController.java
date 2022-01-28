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

import com.springboot.application.model.Financeiro;
import com.springboot.application.repository.CaixaRepository;
import com.springboot.application.repository.Conta_PagarRepository;
import com.springboot.application.repository.Conta_ReceberRepository;
import com.springboot.application.repository.FinanceiroRepository;

@Controller
public class FinanceiroController {
	
	@Autowired
	private FinanceiroRepository financeiroRepository;
	
	@Autowired
	private Conta_PagarRepository conta_pagarRepository;
	
	@Autowired
	private Conta_ReceberRepository conta_receberRepository;
	
	@Autowired
	private CaixaRepository caixaRepository;

	public FinanceiroController(FinanceiroRepository financeiroRepository) {
		super();
		this.financeiroRepository = financeiroRepository;
	}
	
	@GetMapping("/cadastro/financeiro")
	public ModelAndView retornaCadastroFinanceiro(Financeiro financeiro) {
		ModelAndView mv = new ModelAndView("cadastro/cadastro_financeiro");
		mv.addObject("financeiros", financeiro);
		mv.addObject("listaConta_pagar", conta_pagarRepository.findAll());
		mv.addObject("listaConta_receber", conta_receberRepository.findAll());
		mv.addObject("listaCaixa",caixaRepository.findAll());
		return mv;	
	}
	
	@GetMapping("/cadastro/financeiro/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("lista/listar_financeiro");
		mv.addObject("listaFinanceiros", financeiroRepository.findAll());
		return mv;
	}
		
	@GetMapping("/cadastro/financeiro/editar/{id}")
	public ModelAndView editarFinanceiro(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("edicao/editar_financeiro");
		Optional<Financeiro> financeiro = financeiroRepository.findById(id);
		mv.addObject("financeiros", financeiro.get());
		mv.addObject("listaConta_pagar", financeiro.get().getConta_pagar());
		mv.addObject("listaConta_receber", financeiro.get().getConta_receber());
		mv.addObject("listaCaixa",financeiro.get().getCaixa());
		return mv;
	}
		
	@GetMapping("/cadastro/financeiro/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro_remocao/financeiro_deletado_com_sucesso");
		Optional<Financeiro> financeiro = financeiroRepository.findById(id);
		try {
			financeiroRepository.delete(financeiro.get());
			mv.addObject("mensagemFinanceiroRemocao", financeiro);
			return mv;
			
		}catch(Exception e) {
			
		}
		
		return mv;
		
	}
	
	
	@PostMapping("/cadastro/financeiro/salvar")
	public ModelAndView salvarFinanceiro(@Valid Financeiro financeiro, BindingResult result) {
		ModelAndView mv = new ModelAndView("cadastrado_com_sucesso/financeiro_cadastrado_com_sucesso");
		if(result.hasErrors()) {
			return retornaCadastroFinanceiro(financeiro);
			
		}
		
		try {
			financeiroRepository.saveAndFlush(financeiro);
			mv.addObject("financeiros", financeiro);
			
			
		}catch(Exception e) {
			ModelAndView mv1 = new ModelAndView("cadastro_exceptions/financeiro_existente");
			mv1.addObject("mensagemFinanceiro" , e);
			return mv1;
		}
		return mv;
	}
	
	
	
}
