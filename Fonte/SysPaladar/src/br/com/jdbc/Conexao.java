package br.com.jdbc;

import java.sql.*;

public class Conexao {
	//com static envocamos o metodo sem estancia a classe!!
	public static  Connection pegarConexao(){
			Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
//força o carregamento do Driver obs(tratar exceção com  catch (ClassNotFoundException e))
			String url = "jdbc:postgresql://localhost:5432/cadastro";
			String usuario = "postgres";
			String senha = "postgres";
			
			con = DriverManager.getConnection(url,usuario,senha);
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
