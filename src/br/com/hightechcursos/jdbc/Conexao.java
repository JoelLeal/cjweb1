package br.com.hightechcursos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection(){
		
		Connection con=null;
		
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancocjweb1_joel","postgres","123456");
			System.out.println("Conectado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro de conexao com o banco de dados: "+e.getMessage());
			e.printStackTrace();
		}
		return con;
	}

}