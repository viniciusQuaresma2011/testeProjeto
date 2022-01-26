package com.springboot.application.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.springboot.application.model.Usuario;
import com.springboot.application.repository.DispositivoRepository;
import com.springboot.application.repository.EstoqueRepository;
import com.springboot.application.repository.ProdutoRepository;
import com.springboot.application.repository.UsuarioRepository;
import com.springboot.application.service.ServicoGeral;
import com.springboot.application.service.UsuarioService;



@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ServicoGeral servicoGeral;
	
	@Autowired
	private DispositivoRepository dispositivoRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	
	
	
	
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}


	@GetMapping("/cadastro/usuarios")
	public ModelAndView retornaCadastroUsuario(Usuario usuario) {
		
	
			//Usuario usuario = new Usuario();
			ModelAndView mv = new ModelAndView("cadastro/cadastro_usuario");
			mv.addObject("usuarios", usuario);
			
			//model.addAttribute("usuarios", usuario);
			
			List<String> listaDeFuncoes = Arrays.asList("Caixa" , "Fiscal de Loja", "Gerente", "Repositor", "Estoquista", "Conferente");
			mv.addObject("Listacargo", listaDeFuncoes );
			
			mv.addObject("ListaDispositivo", dispositivoRepository.findAll());
			//usuarioRepository.save(usuario);
			
			return mv;
			
			
	}
	
	
//	@PostMapping("/cadastro/usuarios")
//	public String cadastroDeUsuario(@ModelAttribute("usuarios") Usuario usuario) {
//		usuarioService.salvarUsuario(usuario);
//		return "usuario_cadastrado_com_sucesso";
//	}
	
	@GetMapping("/cadastro/usuarios/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("lista/listar_usuario");
		mv.addObject("listaUsuarios", usuarioRepository.findAll());
		//List<String> d = dispositivoRepository.retornaNomeDipositivoPorUsuario();
		//mv.addObject("listaNomeDispositivo", dispositivoRepository.retornaNomeDipositivoPorUsuario());
		return mv;
	}
	
	
//	@GetMapping("/cadastro/usuarios/editar/{id}")
//	public ModelAndView editarUsuario(@PathVariable("id") Long id) {
//		Optional<Usuario> usuario = usuarioRepository.findById(id);
//		return retornaCadastroUsuario(usuario.get());
//	}
	
	@GetMapping("/cadastro/usuarios/editar/{id}")
	public ModelAndView editarUsuario(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("edicao/editar_usuario");
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		mv.addObject("usuarios", usuario.get());
		mv.addObject("Listacargo", usuario.get().getFuncao());
		
		return mv;
	}
	
	@GetMapping("/cadastro/usuarios/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro_remocao/usuario_deletado_com_sucesso");
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		try {
			usuarioRepository.delete(usuario.get());
			mv.addObject("mensagemUsuarioRemocao", usuario);
			return mv;
			
		}catch(Exception e) {
			
		}
		
		return mv;
	}
	
//	@PostMapping("/cadastro/usuarios/salvar")
//	public ModelAndView salvarUsuario(@Valid Usuario usuario, BindingResult result) {
//		ModelAndView mv = new ModelAndView("usuario_cadastrado_com_sucesso");
//		if(result.hasErrors()) {
//			return retornaCadastroUsuario(usuario);
//		}
//		
//		usuarioRepository.saveAndFlush(usuario);
//		mv.addObject(usuario);
//		return mv;
//	}
	
	@PostMapping("/cadastro/usuarios/salvar")
	public ModelAndView salvarUsuario(@Valid Usuario usuario, BindingResult result) throws Exception {
		ModelAndView mv = new ModelAndView("cadastrado_com_sucesso/usuario_cadastrado_com_sucesso");
		if(result.hasErrors()) {
			return retornaCadastroUsuario(usuario);
			
		}
		
		try {
			usuarioRepository.saveAndFlush(usuario);
			mv.addObject("usuarios", usuario);
			
			
		}catch(Exception e) {
			ModelAndView mv1 = new ModelAndView("cadastro_exceptions/usuario_existente");
			mv1.addObject("mensagemUsuario" , e);
			return mv1;
		}
		
		
		
		//usuarioRepository.save(usuario);
		return mv;
	}
	
	@PostMapping("**/buscarPorNome") //aqui faz a busca pelo nome
	public ModelAndView buscarPorNome(@RequestParam("nome") String nome){
		ModelAndView mv = new ModelAndView("lista/listar_usuario");
		mv.addObject("listaUsuarios", usuarioRepository.buscarPorNome(nome));
		mv.addObject("usuarioObjeto", new Usuario());
		return mv;
	}
	
	
	@GetMapping("/usuarios/exportarCsv")
    public void exportCSV(HttpServletResponse response) throws Exception {

        // set file name and content type
        String filename = "usuario.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, 
                   "attachment; filename=\"" + filename + "\"");

        // create a csv writer
        StatefulBeanToCsv<Usuario> writer = new StatefulBeanToCsvBuilder
                    <Usuario>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).
                        withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false).build();

        // write all employees to csv file
        writer.write(usuarioRepository.findAll());

    }
	
	@RequestMapping(value = "/objetosCadastradosQuantidade", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String retornaQuantidadeDeObjetosCadastrados() {
		
		ArrayList QuantidadeDosObjetos = new ArrayList(); 
		
		
		Long listaUsuario = usuarioRepository.count();
		Long listaProduto = produtoRepository.count();
		Long listaEstoque = estoqueRepository.count();
		Long listaDispositivo = dispositivoRepository.count();
		
		QuantidadeDosObjetos.add(listaUsuario);
		QuantidadeDosObjetos.add(listaProduto);
		QuantidadeDosObjetos.add(listaEstoque);
		QuantidadeDosObjetos.add(listaDispositivo);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//System.out.println(gson.toJson(variosObjetos));
		

		return gson.toJson(QuantidadeDosObjetos);
	}
}
