package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.entidades.Usuario;
import br.com.jdbc.UsuarioDAO;

//controller servlet serve para criar uma comunicação ente o browser e o servidor!! 
//todo od dados que vem do browser primeiro são tratados pelo servlet

@WebServlet("/autenticador.do")
public class AutenticadorControllerServlet extends HttpServlet{//import javax.servlet.http.HttpServlet;


	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	String login = req.getParameter("login");
	String senha = req.getParameter("senha");
	//constroi um objeto com login e senha
	Usuario usuario =new Usuario();
	usuario.setLogin(login);
	usuario.setSenha(senha);
	//pesquisa no banco através 
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	// guarda objeto           |autentica se login e senha corresponde a um usuario existente e retorna um objeto usuario
	Usuario usuarioAutenticar = usuarioDAO.autenticar(usuario);
	
	//
	if(usuarioAutenticar != null){
	
		//redirecionando o usuario para tela principal
		req.getRequestDispatcher("Formulario.jsp").forward(req,resp);
	}else{
		resp.getWriter().print("<script>window.alert('Cadastro não existe!');location.href='login.jsp'; </script>");//
	}
	
	}//fim dopost
}
