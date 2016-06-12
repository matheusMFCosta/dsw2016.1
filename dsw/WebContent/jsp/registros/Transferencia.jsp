<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<c:set var="usuario" value="${requestScope.usuario}" scope="page" />

<title>Insert title here</title>
</head>
<body>

<div class="row">
  <div class="col-sm-4">.</div>
	</div>
	<div class="col-sm-4"></div>
<form action="/dsw/transferencia.do" method="post">  
 <fieldset style="width: 300px">
     <legend> Create Account</legend>
     <table>
     
     	 <tr>
			<td><input type="hidden" name="userEmail"  value="${usuario.email}"/> <td>
		 </tr>


		 <tr>  
			<td>Numero do Banco:</td>
			<td><input type="text" value="<%= request.getParameter("bankNumber") %>" required="required" name="bankNumber"/> </td>
		</tr>
		<tr>
			<td>Numero da Agencia:</td>
			<td><input type="number"  value="<%= request.getParameter("AgencyNumber") %>" required="required" name="AgencyNumber"/> </td>
		</tr>
		 <tr>
			<td>Numero da Conta:</td>
			<td><input type="number"  value="<%= request.getParameter("AccountNumber") %>" required="required" name="AccountNumber"/> </td>
		</tr>
		 <tr>
			<td>Valor:</td>
			<td><input type="number" value="<%= request.getParameter("ammount") %>" required="required" name="ammount"/></td>
		</tr>
	</table>  


<input type="submit" value="register"/>
</fieldset>
</form>    



</body>
</html>