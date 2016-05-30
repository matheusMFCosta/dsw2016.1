<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<c:set var="usuario" value="${requestScope.usuario}" scope="page" />


<form action="/dsw/GetUsuario.do" method="post">
	<fieldset style="width: 300px">
     <legend> Insira seu email</legend>
     <table>
         <tr>
			<td>Name:</td>
			<td><input type="text" name="userEmail"  value="${usuario.email}"/> <td>
		 </tr>
	</table>
			    
		   	<input type="submit" value="ok" 
				name="Submit" id="frm1_submit" />
	</fieldset>
</form>

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
			<td><input type="text" name="userPhone" value="${usuario.telefone}"/></td>
	</tr>
	</table>  


<input type="submit" value="editar"/>
</fieldset>
</form>    


</body>
</html>