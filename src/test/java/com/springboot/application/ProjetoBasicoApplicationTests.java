package com.springboot.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.application.model.Conta_Pagar;
import com.springboot.application.model.Estoque;
import com.springboot.application.model.Fornecedor;
import com.springboot.application.model.Produto;
import com.springboot.application.model.Usuario;
import com.springboot.application.model.Venda;

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
	
	
	@Test
	void testarpo() {
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setCnpj("545454");
		fornecedor.setEmail("asda@gmail.com");
		fornecedor.setEndereco(null);
		fornecedor.setProduto(null);
		fornecedor.setTelefone("123123");
		
		Conta_Pagar cp = new Conta_Pagar();
		cp.setNome("asda");
//		cp.setData_entrada(LocalDate.of(2021,05,02));
//		cp.setData_vencimento(LocalDate.of(2021,05,03));
		cp.setFornecedor(null);
		cp.setNumero_nota(cp.getNumero_nota());
		cp.setValor(cp.getValor());
		
		
		//Assertions.assertTrue(cp.getData_entrada().equals(LocalDate.of(2021,05,02)));
		
		
	}
	
	@Test
	void testVenda() {
		Venda v = new Venda();
		v.setId(1L);
		v.setFechamento_dia("2020-10-21");
		v.setNome("asdasda");
		v.setValor_total("12312");
		
		Assertions.assertTrue(v.getFechamento_dia().equals("2020-10-21"));
		
		
	}

}
