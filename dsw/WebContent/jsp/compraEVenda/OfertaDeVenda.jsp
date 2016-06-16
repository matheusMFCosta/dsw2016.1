

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="ex" uri="../../WEB-INF/customTag.tld"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<c:set var="usuario" value="${requestScope.usuario}" scope="page" />

<title>Insert title here</title>
</head>
<body>

	
<div class="row">
  <div class="col-sm-4"></div>

	<div class="col-sm-4">
	<ex:SaldoDisponivel userEmail="${usuario.email}"/>
<form action="/dsw/registraOfertaDeVenda.do" method="post">  
 <fieldset style="width: 300px">
     <legend> Vender personagem</legend>
     <table>
     
     	 <tr>
			<td><input type="hidden" name="userEmail"  value="${usuario.email}"/> <td>
		 </tr>


		 <tr>  
			<td>Id do Personagem:</td>
			<td><input type="number"  required="required" name="personagemId"/> </td>
		</tr>
		<tr>
			<td>Quantidade:</td>
			<td><input type="number"   required="required" name="quantity"/> </td>
		</tr>
		<tr>
			<td>preco Unitarioe:</td>
			<td><input type="number"   required="required" name="price"/> </td>
		</tr>

	</table>  


<input type="submit" value="register"/>
</fieldset>
</form>    

<ex:Personagens/>
</div>
</body>
</html>