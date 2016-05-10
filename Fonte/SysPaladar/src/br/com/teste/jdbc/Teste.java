package br.com.teste.jdbc;

import java.util.List;

import br.com.entidades.Usuario;
import br.com.jdbc.Conexao;
import br.com.jdbc.UsuarioDAO;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

    //Conexao.pegarConexao();
		
	//testeCdastrar();
	//testeAlterar();
    //testeExcluir();
    //testeBuscarTodosRegistro();
    //testeBuscaPorId();		
		testeAutenticar();
	}// Fim da do m�todo main

	private static void testeAutenticar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = new Usuario();
		usuario.setLogin("Let�cia09");
		usuario.setSenha("0907");
		
		Usuario usuarioRetorno = usuarioDAO.autenticar(usuario);
		System.out.println(usuarioRetorno);
	}

	private static void testeCdastrar() {//in�cio do m�todo testeCdastrar()
		//Ctrl+Shift+C para comentar	
			Usuario usuario = new Usuario();
			usuario.setLogin("Let�cia09");
			usuario.setSenha("0907");
			usuario.setNome("Let�cia");
			usuario.setEmail("leticia@hotmail.com");
			usuario.setTelefone("9826643636");
		
			
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.cadastrar(usuario);
			
	}//Fim do m�todo testeCdastrar();

	private static void testeAlterar() {//In�cio do m�todo testeAlterar()
		
		Usuario usuario = new Usuario();
		usuario.setLogin("Let�cia09");
		usuario.setSenha("0907");
		usuario.setNome("Let�cia Rodrigues");
		usuario.setEmail("letician@gmail.com");
		usuario.setTelefone("982664363");
		
		usuario.setIdContato(2);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usuario);
		
	}//Fim do m�todo testeAlterar();
	
    private static void testeExcluir() {//In�cio do m�todo testeExcluir()
		
		Usuario usuario = new Usuario();
		
		usuario.setIdContato(1);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usuario);
		
	}//Fim do m�todo testeExcluir()

    private static void testeBuscarTodosRegistro() {//In�cio do m�todo testeBuscarTodosRegistro()
		
	UsuarioDAO usuDAO = new UsuarioDAO();
	List<Usuario> listaResultado = usuDAO.buscarTodosRegistro();
	
	for(Usuario User: listaResultado){
		
		System.out.println("");
		System.out.println("ID: "+User.getIdContato());
		System.out.println("Login: "+User.getLogin());
		System.out.println("Senha: "+User.getSenha());
		System.out.println("Nome: "+User.getNome());
		System.out.println("Email: "+User.getEmail());
		System.out.println("Telefone: "+User.getTelefone());
		
				
	}
	
}//Fim do m�todo testeBuscarTodosRegistro()



}
