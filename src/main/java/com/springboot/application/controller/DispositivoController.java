package com.springboot.application.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.springboot.application.model.Dispositivo;
import com.springboot.application.repository.DispositivoRepository;
import com.springboot.application.repository.UsuarioRepository;

@Controller
public class DispositivoController {

	@Autowired
	private DispositivoRepository dispositivoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public DispositivoController(DispositivoRepository dispositivoRepository) {
		super();
		this.dispositivoRepository = dispositivoRepository;
	}

	@GetMapping("/cadastro/dispositivos")
	public ModelAndView retornaCadastroDispositivo(Dispositivo dispositivo) {
		ModelAndView mv = new ModelAndView("cadastro/cadastro_dispositivo");
		mv.addObject("dispositivos", dispositivo);

		List<String> modelos = Arrays.asList("Selecione..", "Motorola", "Samsung");
		mv.addObject("listaModelos", modelos);
		mv.addObject("listaUsuario", usuarioRepository.findAll());

		return mv;
	}

	@GetMapping("/cadastro/dispositivos/listar")
	public ModelAndView listarDispositivo() {
		ModelAndView mv = new ModelAndView("lista/listar_dispositivo");
		mv.addObject("listaDispositivos", dispositivoRepository.findAll());
		return mv;
	}

//	@GetMapping("/cadastro/dispositivos/editar/{id}")
//	public ModelAndView editarDispositivo(@PathVariable("id") Long id) {
//		Optional<Dispositivo> dispositivo = dispositivoRepository.findById(id);
//		return retornaCadastroDispositivo(dispositivo.get());
//	}
	
	@GetMapping("/cadastro/dispositivos/editar/{id}")
	public ModelAndView editarDispositivo(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("edicao/editar_dispositivo");
		Optional<Dispositivo> dispositivo = dispositivoRepository.findById(id);
		mv.addObject("dispositivos", dispositivo.get());
		mv.addObject("listaModelos", dispositivo.get().getModelo());
		mv.addObject("listaUsuario", dispositivo.get().getUsuario());
		
		return mv;
	}

	@GetMapping("/cadastro/dispositivos/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro_remocao/dispositivo_deletado_com_sucesso");
		Optional<Dispositivo> dispositivo = dispositivoRepository.findById(id);
		try {
			dispositivoRepository.delete(dispositivo.get());
			mv.addObject("mensagemDispositivoRemocao", dispositivo);
			return mv;
			
		}catch(Exception e) {
			
		}
		
		
		
		return mv;
	}

	@PostMapping("/cadastro/dispositivos/salvar")
	public ModelAndView salvarDispositivo(@Valid Dispositivo dispositivo, BindingResult result) {
		ModelAndView mv = new ModelAndView("cadastrado_com_sucesso/dispositivo_cadastrado_com_sucesso");
		if (result.hasErrors()) {
			return retornaCadastroDispositivo(dispositivo);
		}
		
		try {
			dispositivoRepository.saveAndFlush(dispositivo);
			mv.addObject("dispositivos", dispositivo);
		}catch(Exception e) {
			ModelAndView mv1 = new ModelAndView("cadastro_exceptions/dispositivo_existente");
			mv1.addObject("mensagemDispositivo", e);
			return mv1;
		}

	

		return mv;
	}
	
	
	
	@PostMapping("**/buscarPorNomeDispositivo") //aqui faz a busca pelo nome
	public ModelAndView buscarPorNomeDispositivo(@RequestParam("nome") String nome){
		ModelAndView mv = new ModelAndView("lista/listar_dispositivo");
		mv.addObject("listaDispositivos", dispositivoRepository.buscarPorNome(nome));
		mv.addObject("dispositivoObjeto", new Dispositivo());
		return mv;
	}
	
	
	@GetMapping("/dispositivos/exportarCsv")
    public void exportCSV(HttpServletResponse response) throws Exception {

        // set file name and content type
        String filename = "dispositivo.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, 
                   "attachment; filename=\"" + filename + "\"");

        // create a csv writer
        StatefulBeanToCsv<Dispositivo> writer = new StatefulBeanToCsvBuilder
                    <Dispositivo>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).
                        withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false).build();

        // write all employees to csv file
        writer.write(dispositivoRepository.findAll());

    }
	

}
