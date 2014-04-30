package br.com.hightechcursos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hightechcursos.entidades.Usuario;

public class UsuarioDAO {

		private Connection con = Conexao.getConnection();
		
		public void cadastrar(Usuario usuario){
			//Montando SQL
			String sql = "INSERT INTO USUARIO(nome,login,senha) values(?,?,?);";
			
			try {
				//constroi o PreparedStatement com o SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				//primeiro ponto de interrogação pega nome
				preparador.setString(1, usuario.getNome());
				//segundo ponto de interrogação pega login
				preparador.setString(2, usuario.getLogin());
				//terceiro ponto de interrogação pega senha
				preparador.setString(3, usuario.getSenha());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Cadastrado com sucesso");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Erro: "+e.getMessage());
			}
		}
		
		public void alterar(Usuario usuario){
			//Montando SQL
			String sql = "UPDATE USUARIO SET NOME=?,LOGIN=?,SENHA=? WHERE ID=?";
			
			try {
				//constroi o PreparedStatement com o SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				//primeiro ponto de interrogação pega nome
				preparador.setString(1, usuario.getNome());
				//segundo ponto de interrogação pega login
				preparador.setString(2, usuario.getLogin());
				//terceiro ponto de interrogação pega senha
				preparador.setString(3, usuario.getSenha());
				//quarto ponto de interrogção pega id
				preparador.setInt(4, usuario.getId());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Alterado com sucesso");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Erro: "+e.getMessage());
			}
		}
		
		public void excluir(Usuario usuario){
			//Montando SQL
			String sql = "DELETE FROM USUARIO WHERE ID=?;";
			
			try {
				//constroi o PreparedStatement com o SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				//primeiro ponto de interrogação pega ID
				preparador.setInt(1, usuario.getId());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Excluido com sucesso");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Erro: "+e.getMessage());
			}
		}
		
		public List<Usuario> buscarTodos(){
			//Montando SQL
			String sql = "SELECT * FROM USUARIO;";
			
			List<Usuario> lista = new ArrayList<Usuario>();
			
			try {
				//constroi o PreparedStatement com o SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				
				//executeQuery é quando iremos realizar consulta
				//apenas execute não tem retorno nenhum
				//resultset recebe todos o resultado do retorno da consulta
				ResultSet resultado = preparador.executeQuery();
				
				while(resultado.next()){
					//populando lista
					Usuario usu = new Usuario();
					usu.setId(resultado.getInt("id")); //valor da coluna id
					usu.setNome(resultado.getString("nome")); //valor da coluna nome
					usu.setLogin(resultado.getString("login")); // valor da coluna login
					usu.setSenha(resultado.getString("senha")); // valor da coluna senha
					
					lista.add(usu);
				}
				
				System.out.println("Lista populada com sucesso");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Erro: "+e.getMessage());
			}
			
			return lista;
		}
	
}
