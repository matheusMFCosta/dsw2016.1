<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<title>Welcome <%=session.getAttribute("usuario")%></title>
</head>
<body>
 <div class="row">
  <div class="col-sm-4 col-md-4"></div>
  <div class="col-sm-4">
	
    <h3>Login Concluido!!!</h3>
    <p>usuario: ${usuario.nome}</p>
    <p>email: ${usuario.email}</p>
    <p>cpf: ${usuario.cpf}</p>
    <p>telefone: ${usuario.telefone}</p>
    <p>senha: ${usuario.senha}</p>

    
  <div class="row">
  <div class="col-sm-3 col-md-3">


    <form action="/dsw/EditaUsuario.jsp" method="post">
    	<input type="submit" value="edita usuario" 
			name="Submit" id="frm1_submit" />
	</form>
		</div>
	  <div class="col-sm-3 col-md-3">
	 <form action="/dsw/EditaSenha.jsp" method="post">
    	<input type="submit" value="edita senha" 
			name="Submit" id="frm1_submit" />
	</form>
		</div>
	  <div class="col-sm-3 col-md-3">
	<form action="/dsw/logoutServlet" method="post">
    	<input type="submit" value="Log out" 
			name="Submit" id="frm1_submit" />
	</form>
	</div>
    
    </div>
    </div>
          </div>
    </div>
</body>
</html>