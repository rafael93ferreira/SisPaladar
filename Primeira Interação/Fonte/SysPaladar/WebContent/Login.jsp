<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href ="_css/login.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<!-- -shutdown.bat -->
 <div id="divcorpo">
 <form action="autenticador.do" method="post">
 <label>Login:</label> <input type="text" name="login"> <br><br>
 <label>Senha:</label> <input type="password" name="senha"><br><br>
 <input type="submit" value="logar">
 </form>
 </div>
</body>
</html>