package br.com.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.entidades.Usuario;
import br.com.jdbc.UsuarioDAO;



@WebServlet("/usuarioContrller.do")
public class UsuarioControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UsuarioControllerServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando o método GET");
		
		String acao = request.getParameter("acao");
		
		if(acao != null && acao.equals("excluir")){
			String id = request.getParameter("id");
			UsuarioDAO usuarioExcluir = new UsuarioDAO();
			Usuario usuario = new Usuario();
			usuario.setIdContato(Integer.parseInt(id));
			usuarioExcluir.excluir(usuario);
			
			//redirecionando pelo cliente(browser)
			response.sendRedirect("usuarioContrller.do?acao=listar");
		}
		
		// Açãode alterar
		if(acao != null && acao.equals("alterar")){
			String id = request.getParameter("id");//captura o parametro 
			//busca o objeto usuario no banco
			UsuarioDAO usuarioAlterar = new UsuarioDAO();
			//seta atributos
			Usuario usuario = usuarioAlterar.buscarPorID(Integer.parseInt(id));
			request.setAttribute("usuario",usuario);
			  //encaminhamento o objeto para a tela
			RequestDispatcher saidaJSP = request.getRequestDispatcher("Formulario.jsp");//objeto que encaminha
			
		saidaJSP.forward(request, response);
		
		}
		
		// Ação cadastrar novo usuário
				if(acao != null && acao.equals("cadastrar")){
					//cria um novo objeto usuario
					Usuario usuario = new Usuario();
	                usuario.setIdContato(0);
	                usuario.setLogin("");
	                usuario.setSenha("");
	                usuario.setNome("");
	                usuario.setEmail("");
	                usuario.setTelefone("");
	              
	                
				
					request.setAttribute("usuario",usuario);
					  //encaminhamento o objeto para a tela
					RequestDispatcher saidaJSP = request.getRequestDispatcher("Formulario.jsp");//objeto que encaminha
					
					saidaJSP.forward(request, response);//enviando request e response para o arquivo JSP
				}
				
		//Ação listar na tela
		if(acao != null && acao.equals("listar")){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		//objeto usuarioDAO acessando o método buscarTodosRegistro()
		        //obter lista de usuario
				List<Usuario> lista = usuarioDAO.buscarTodosRegistro();//variavel lista do tipo List<Usuario> recebe uma lista de usuarios
				//PrintWriter saida = response.getWriter();
			 			 
				//atribui a lista no request
				request.setAttribute("lista",lista);
				
							
			   //encaminhamento ao JSP	
				RequestDispatcher saidaJSP = request.getRequestDispatcher("Formulario.jsp");//objeto que encaminha
				
				saidaJSP.forward(request, response);//enviando request e response para o arquivo JSP

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando o método POST");
		
		
		//pegando dados do formulário html através do request e add nas variáveis
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		
		if(login != "" && senha != "" && nome != ""){
		//setando dados do formulário no objeto Usuario (Classe)
		Usuario usuario = new Usuario();

		if(id != null && id != ""){
			usuario.setIdContato(Integer.parseInt(id));
		}
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setTelefone(telefone);
	
				 
		//pede para o UsuarioDAO cadastrar os dados do usuario no banco de dados		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
	    usuarioDAO.salvar(usuario);
	        //redirecionando pelo cliente(browser)
	  	
	    response.sendRedirect("usuarioContrller.do?acao=listar");
	   //PrintWriter saida = response.getWriter();
	   //saida.print("Salvo com sucesso!");
	 
	
	}else{
		response.getWriter().print("<script>window.alert('Campos Login, Senha e nome são obrigatorios!'); location.href='Formulario.jsp';</script>");
	}
		
	}//fim do post
}
