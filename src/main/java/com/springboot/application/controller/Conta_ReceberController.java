package com.springboot.application.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;


import com.springboot.application.model.Conta_Receber;
import com.springboot.application.repository.Conta_ReceberRepository;
import com.springboot.application.repository.UsuarioRepository;
import com.springboot.application.repository.VendaRepository;

@Controller
public class Conta_ReceberController {
	
	
	@Autowired
	private Conta_ReceberRepository conta_receberRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Conta_ReceberController(Conta_ReceberRepository conta_receberRepository) {
		super();
		this.conta_receberRepository = conta_receberRepository;
	}
	
	@GetMapping("/cadastro/conta_receber")
	public ModelAndView retornaCadastroConta_Receber(Conta_Receber conta_receber) {
		ModelAndView mv = new ModelAndView("cadastro/cadastro_conta_receber");
		mv.addObject("contas_receber", conta_receber);
		mv.addObject("listaVendas", vendaRepository.findAll());
		mv.addObject("listaUsuarios", usuarioRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastro/conta_receber/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("lista/listar_conta_receber");
		mv.addObject("listaConta_Receber", conta_receberRepository.findAll());
		return mv;	
	}
	
	@GetMapping("/cadastro/conta_receber/editar/{id}")
	public ModelAndView editarConta_Receber(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("edicao/editar_conta_receber");
		Optional<Conta_Receber> conta_receber = conta_receberRepository.findById(id);
		mv.addObject("contas_receber", conta_receber);
		mv.addObject("listaVendas", conta_receber.get().getVenda());
		mv.addObject("listaUsuarios", conta_receber.get().getUsuario());
		return mv;
	}
	
	@GetMapping("/cadastro/conta_receber/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro_remocao/conta_receber_deletado_com_sucesso");
		Optional<Conta_Receber> conta_receber = conta_receberRepository.findById(id);
		try {
			conta_receberRepository.delete(conta_receber.get());
			
			mv.addObject("mensagemConta_ReceberRemocao",conta_receber);
		}catch(Exception e) {
			
		}
		return mv;
	}
	
//	@PostMapping("/cadastro/conta_receber/salvar")
//	public ModelAndView salvarConta_Receber(@Valid  Conta_Receber conta_receber, BindingResult result) {
//		ModelAndView mv = new ModelAndView("cadastrado_com_sucesso/conta_receber_cadastrado_com_sucesso");
//		if(result.hasErrors()) {
//			return retornaCadastroConta_Receber(conta_receber);
//			
//		}
//		try {
//			conta_receberRepository.saveAndFlush(conta_receber);
//			mv.addObject("contas_receber", conta_receber);
//		}catch(Exception e) {
//			ModelAndView mv1 = new ModelAndView("cadastro_exceptions/conta_receber_existente");
//			mv1.addObject("mensagemConta_receber" , e);
//			return mv1;
//		}
//		return mv;
//	
//	}
	
	@PostMapping("/cadastro/conta_receber/salvar")
	public ResponseEntity<Conta_Receber> createContaReceber(@ModelAttribute @Valid Conta_Receber cr) throws Exception {
	
		Conta_Receber d = conta_receberRepository.save(cr);
		return ResponseEntity.ok(d);
	}
	
}
