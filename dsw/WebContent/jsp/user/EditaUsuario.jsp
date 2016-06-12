<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<title>Welcome <%=session.getAttribute("usuario")%></title>
</head>
<body>
<c:set var="usuario" value="${requestScope.usuario}" scope="page" />

<div class="row">
  <div class="col-sm-4">.</div>
	</div>
	<div class="col-sm-4"></div>
<form action="/dsw/EditaUsuario.do" method="post">  
 <fieldset style="width: 300px">
     <legend> Editar Usuario</legend>
     <table>
     	 <tr>
			<td><input type="hidden" name="userEmail"  value="${usuario.email}"/> <td>
		 </tr>
         <tr>
			<td>Name:</td>
			<td><input type="text" name="userName"  value="${usuario.nome}"/> <td>
		 </tr>
		 <tr>
			<td>CPF:</td>
			<td><input type="text" name="userCPF"  value="${usuario.cpf}"/> </td>
		</tr>
		 <tr>
			<td>telefone:</td>
			<td><input type="tel" name="userPhone" value="${usuario.telefone}"/></td>
	</tr>
	</table>  


<input type="submit" value="editar"/>
</fieldset>
</form>    


</script>


</body>
</html>