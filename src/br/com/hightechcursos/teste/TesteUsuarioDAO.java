package br.com.hightechcursos.teste;

import java.util.List;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		
		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		testeBuscatTodos();

	}

	private static void testeCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Nivea");
		usu.setLogin("leal");
		usu.setSenha("26051427");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		
		usuDao.cadastrar(usu);
	}
	
	private static void testeAlterar(){
		Usuario usu = new Usuario();
		usu.setId(1);
		usu.setNome("Lucas");
		usu.setLogin("Prestupa");
		usu.setSenha("1a2b3c4d");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		
		usuDao.alterar(usu);
	}
	
	private static void testeExcluir(){
		Usuario usu = new Usuario();
		usu.setId(1);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		
		usuDao.excluir(usu);
	}
	
	public static void testeBuscatTodos(){
		UsuarioDAO usuDao = new UsuarioDAO();
		
		List<Usuario> listaResultado = usuDao.buscarTodos();
		
		for(Usuario u: listaResultado){
			System.out.println(u.getId()+" "+u.getNome()+" "+u.getLogin()+" "+u.getSenha());
		}
		
	}

}
