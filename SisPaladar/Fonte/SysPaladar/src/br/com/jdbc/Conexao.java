package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	//com static envocamos o metodo sem estancia a classe!!
	public static  Connection pegarConexao(){
			Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
//força o carregamento do Driver obs(tratar exceção com  catch (ClassNotFoundException e))
			String url = "jdbc:postgresql://localhost:5432/cadastro";
			String usuario = "postgres1";
			String senha = "1";
			
			con = DriverManager.getConnection(url,"postgres","postgres");
		    System.out.println("Conexão realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Não pode conectar: "+e.getMessage());
		} catch (ClassNotFoundException e) {//tratando erro do carregamento do Driver 
			// TODO Auto-generated catch block
			System.out.println("Driver não encontrado!");
			e.printStackTrace();
		}
		return con;
	}
}
