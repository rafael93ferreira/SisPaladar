<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.com.entidades.Usuario"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel="stylesheet" type="text/css" href ="_css/formulario.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img id="imgpaladar" alt="" src="./-imagem/paladar.png"></img>
<br>
<div id="divcorpo">
 
    <form action="usuarioContrller.do" method="post">
		   <label id="nomepratos" name="nome" value="${requestScope.usuario.nome}" ></label><br></br>
		   <label id="nomepratos" name="preco" value="${requestScope.usuario.preco}" ></label><br></br>
		   <label id="nomepratos" name="descricao" value="${requestScope.usuario.descricao}" ></label><br></br>
		   <input type="submit" value="Salvar" id="listar">
		   <input type="text" readonly="readonly" name="id" class="idoculto" value="${requestScope.usuario.idPrato}">
     </form>
		 
	 <table class="table">
	  <tr bgcolor="#cccccc">
	    <th>ID</th>
	    <th>Nome</th>
	    <th>Preco</th>
	    <th>Descricao</th>
	  </tr>
	  	
	 <c:forEach items="${requestScope.lista}" var="u">
	 <tr>
	   <td>${u.idPrato}</td>
	   <td>${u.nome} </td>
	   <td>${u.preco}</td>
	   <td>${u.descricao}</td>
	   <td> 
	        <a href="usuarioContrller.do?acao=excluir&id=${u.idPrato}"> Excluir </a>|| 
	        <a href="usuarioContrller.do?acao=alterar&id=${u.idPrato}"> Alterar </a> 
	   </td>
	 </tr>
	  
	  </c:forEach>
	 </table>
	</div>

	</div>
	
	<br>
	
	<br>
 </div>
</body>
</html>