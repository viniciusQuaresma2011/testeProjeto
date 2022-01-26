package com.springboot.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.application.model.Estoque;
import com.springboot.application.model.Produto;
import com.springboot.application.model.Usuario;
import com.springboot.application.repository.ProdutoRepository;
import com.springboot.application.repository.UsuarioRepository;

@SpringBootTest
class ProjetoBasicoApplicationTests {
	
	

	@Test
	void testarCadastro() {
		//UsuarioRepository usuarioRepository ;
		Usuario usuario = new Usuario();
		
		usuario.setNome("vuribi");
		usuario.setEmail("asdas@gmail.com");
		usuario.setFilial("arcoverde");
		usuario.setSetor("pedrada");
		
		System.out.printf("teste " + usuario.getNome());
		System.out.printf("teste 2" + usuario.getEmail());
		
		Assertions.assertTrue(usuario.getNome().equals("vuribi"));
		Assertions.assertTrue(usuario.getEmail().equals("asdas@gmail.co"));
		Assertions.assertTrue(usuario.getFilial().equals("arcoverde"));
		Assertions.assertTrue(usuario.getSetor().equals("pedrada"));
		
	}
	
	@Test
	void TestarOProduto() {
		
		Estoque estoque = new Estoque(1L,"estoque 1", "refrigerado", "22");
		
		Produto p = new Produto(2L, "produto 1", "liquido", "5959", estoque);
	
		//prod.save(p);
		
		p.getEstoque();
		System.out.println(p);
	}
	

}
