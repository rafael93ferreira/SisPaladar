package br.com.jdbc;

import java.sql.*;

public class Conexao {
	//com static envocamos o metodo sem estancia a classe!!
	public static  Connection pegarConexao(){
			Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
//for�a o carregamento do Driver obs(tratar exce��o com  catch (ClassNotFoundException e))
			String url = "jdbc:postgresql://localhost:5432/cadastro";
			String usuario = "postgres";
			String senha = "postgres";
			
			con = DriverManager.getConnection(url,usuario,senha);
		    System.out.println("Conex�o realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println("N�o pode conectar: "+e.getMessage());
		} catch (ClassNotFoundException e) {//tratando erro do carregamento do Driver 
			// TODO Auto-generated catch block
			System.out.println("Driver n�o encontrado!");
			e.printStackTrace();
		}
		return con;
	}
}
