
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
<div id="imagem-paladar">

<div id="divcorpo">
<br>
<br>
	 <form action="usuarioContrller.do" method="post">
	   <label>Nome:</label> <input size="40" placeholder="nome usuário" type="text" name="nome" value="${requestScope.usuario.nome}"/> <br><br>
	   <label>E-mail:</label> <input size="40" placeholder="@email.com" type="text" name="email" value="${requestScope.usuario.email}"/> <br><br>
	   <label>Telefone:</label> <input type="text" name="telefone" value="${requestScope.usuario.telefone}"/> <br><br>
	   <label>Login:</label> <input type="text" name="login"value="${requestScope.usuario.login}"/> <br><br>
	   <label>Senha:</label> <input type="password" name="senha" value="${requestScope.usuario.senha}" /><br><br>
	   <input type="submit" value="Salvar" id="listar">
	   <input type="text" readonly="readonly" name="id" class="idoculto" value="${requestScope.usuario.idContato}">
	 </form>
 
 <br>
 <div class="conteiner">
 <div class="panel panel-default">
  <!-- Default panel contents -->
 <div class="panel-heading"><strong>Lista de Usuarios</strong></div>
 
 <!-- Table -->
 <a href="usuarioContrller.do?acao=listar"> <input type="button" id="listar" value="Listar"/></a>
 <br/>
 <br/>
 <table class="table">
  <tr bgcolor="#cccccc">
    <th>ID</th>
    <th>Login</th>
    <th>Senha</th>
    <th>Nome</th>
    <th>Email</th>
    <th>Telefone</th>
    <th>Excluir//Alterar</th>
  </tr>
  
 <!-- Scrptlet--->

 <c:forEach items="${requestScope.lista}" var="u">
 <tr>
   <td>${u.idContato}</td>
   <td>${u.login} </td>
   <td>${u.senha}</td>
   <td>${u.nome}</td>
   <td>${u.email}</td>
   <td>${u.telefone}</td>
   <td> 
        <a href="usuarioContrller.do?acao=excluir&id=${u.idContato}"> Excluir </a>|| 
        <a href="usuarioContrller.do?acao=alterar&id=${u.idContato}"> Alterar </a> 
   </td>
 </tr>
  
  </c:forEach>
 </table>
</div><!-- fim  panel panel-default -->

</div>

<br>

<br>
 </div>
</body>
</html>