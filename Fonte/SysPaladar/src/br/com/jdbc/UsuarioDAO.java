/*
 * barra * depois enter = formato de documenta��o
 */

/*  Objeto de acesso a dados (ou simplesmente DAO, acr�nimo de Data Access Object), 
 *  � um padr�o para persist�ncia de dados que permite separar regras de neg�cio
 *  das regras de acesso a banco de dados.
 *  */

package br.com.jdbc;
import java.sql.*;
import java.util.*;
import br.com.entidades.Usuario;

public class UsuarioDAO {

	 Connection con = Conexao.pegarConexao();
	 public void cadastrar (Usuario usuario){//in�cio do m�todo cadastrar
		 //MONTA O SQL
		 String sql = "insert into tab_contato"+"(login,senha,nome,email,telefone)"+"values"+"(?,?,?,?,?)";
		 //Constroi o PreparedStatement com o sql
		 try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());
			preparador.setString(3, usuario.getNome());//class com letra minuscula
			preparador.setString(4, usuario.getEmail());
			preparador.setString(5, usuario.getTelefone());			
		
			
			preparador.execute();
			preparador.close();
			System.out.println("Cadastrado inserido com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//mostra o erro
		}//
	 }//Fim do m�todo cadastrar
	 
	 public void alterar(Usuario usuario){//in�cio do m�todo Alterar
		 //MONTA O SQL
		 String sql = "update tab_contato set login=?,senha=?,nome=?,email=?,telefone=? where contatoid=?";
		 //Constroi o PreparedStatement com o sql
		 try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());
			preparador.setString(3, usuario.getNome());//class com letra minuscula
			preparador.setString(4, usuario.getEmail());
			preparador.setString(5, usuario.getTelefone());
			preparador.setInt(6, usuario.getIdContato());
			
			preparador.execute();
			preparador.close();
			System.out.println("Cadastrado alterado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//mostra o erro
		}//
	 }//Fim do m�todo Alterar
	 
	 

	 public void salvar(Usuario usuario){//cadastar ou alterar
		// Usuario usuario = new Usuario();
		 //OBS: uma vari�vel primitiva do tipo int n�o pode armazenar null, ent�o � imposs�vel fazer o teste (int != null)
		 if(usuario.getIdContato() != null && usuario.getIdContato() !=0){
			 alterar(usuario);
		 }else{
			 cadastrar(usuario); 
		 }
		
	 }
	 
	 
	 public void excluir(Usuario usuario){//in�cio do m�todo excluir
		 //MONTA O SQL
		 String sql = "delete from tab_contato where contatoid=?";
		 //Constroi o PreparedStatement com o sql
		 try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, usuario.getIdContato());
			
			preparador.execute();
			preparador.close();
			System.out.println("Cadastrado excluido com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//mostra o erro
		}//
	 }//Fim do m�todo excluir
	 
	 public List<Usuario> buscarTodosRegistro(){//in�cio do m�todo buscarTodosRegistro
		 //MONTA O SQL
		 String sql = "select * from tab_contato";
		 //Constroi o PreparedStatement com o sql
		 
		//Criando lista
			List<Usuario> lista = new ArrayList<Usuario>();
		 try {
			PreparedStatement preparador = con.prepareStatement(sql);
			//guandando todos os registros encontrados em uma vari�vel 
			ResultSet Resultado = preparador.executeQuery();
			
			//extraindo registros da vari�vel Resultado e add a objetos
			while(Resultado.next()){
				Usuario Usu = new Usuario();
				//ADD registros no objeto Usu�rio
				Usu.setIdContato(Resultado.getInt("contatoid"));//valor da coluna
				Usu.setLogin(Resultado.getString("login"));
				Usu.setSenha(Resultado.getString("senha"));
				Usu.setNome(Resultado.getString("nome"));
				Usu.setEmail(Resultado.getString("email"));
				Usu.setTelefone(Resultado.getString("telefone"));
			
				
				lista.add(Usu);//add objetos a Lista
			}
			preparador.close();
			System.out.println("todos os registros foram encontrados com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro, falha ao buscar registros!");
			e.printStackTrace();//mostra o erro
		}//
		 return lista;//retornando lista de objetos
		 
	 }//Fim do m�todo buscarTodosRegistro
	 
	 public Usuario buscarPorID(Integer id){//in�cio m�todo buscarPorID
		 String sql = "select * from tab_contato where contatoid=? ";
		 Usuario usuario = null;//inicializando um objeto usuario = null
		 try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			
			ResultSet Resultado = preparador.executeQuery();
			
			if(Resultado.next()){
			usuario = new Usuario();
			usuario.setIdContato(Resultado.getInt("contatoId"));
			usuario.setLogin(Resultado.getString("login"));
			usuario.setSenha(Resultado.getString("senha"));		
			usuario.setNome(Resultado.getString("nome"));
			usuario.setEmail(Resultado.getString("email"));
			usuario.setTelefone(Resultado.getString("telefone"));
		
			}
			System.out.println("Registro encontrado com scesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Registro n�o encontrado!");
			e.printStackTrace();
		}
		 return usuario;
	 }//Fim m�todo buscarPorID
	 
	 
	 public Usuario autenticar(Usuario usuarioAutenticar){
		 String sql = "select * from tab_contato where login=? and senha=?";
		 
		try {
			//objeto Statement que ir� manipular essa consulta
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuarioAutenticar.getLogin());
			preparador.setString(2, usuarioAutenticar.getSenha());
			
			ResultSet resultado = preparador.executeQuery();//recebendo o resultado da execu��o no banco
			
			if(resultado.next()){//proxima linha
			//setando os dadod obtidos do banco em uma nova estancia de usua
			Usuario usuario = new Usuario();
		//objeto | seta no objeto  | pega resultado do banco
			usuario.setIdContato(resultado.getInt("contatoid"));	
			usuario.setLogin(resultado.getString("login"));
			usuario.setSenha(resultado.getString("senha"));
			usuario.setNome(resultado.getString("nome"));
			usuario.setEmail(resultado.getString("email"));
			usuario.setTelefone(resultado.getString("telefone"));

			
			return usuario;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erro, m�todo Altenticar usuario");
			e.printStackTrace();
		}
			
		return null;
	 }
}//Fim da Classe UsuarioDAO ------------------------------------------------------->
