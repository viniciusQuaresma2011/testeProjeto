package com.springboot.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModuloController {
	
	
	@GetMapping("/modulos")
	public String rest() {
		return "pagina_modulo";
	}
}
