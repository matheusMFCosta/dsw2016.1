
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="ex" uri="../../WEB-INF/customTag.tld"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<c:set var="usuario" value="${requestScope.usuario}" scope="page" />
<c:set var="date" value="${requestScope.date}" scope="page" />
<c:set var="price" value="${requestScope.price}" scope="page" />
<c:set var="personagemId" value="${requestScope.personagemId}" scope="page" />


    	

<title>Insert title here</title>
</head>
<body>

<div class="row">
  <div class="col-sm-4"></div>
 
	<div class="col-sm-4">
	
<ex:SaldoDisponivel userEmail="${usuario.email}"/>

<form action="/dsw/removeOfer.do" method="post">  
 <fieldset style="width: 300px">
     <legend> Cancel a order</legend>
     <table>
     
     	 <tr>
			<td><input type="hidden" name="userEmail"  value="${usuario.email}"/> <td>
		 </tr>
		 <tr>  
			<td>Id do ordem:</td>
			<td><input type="number"  required="required" name="orderId"/> </td>
		</tr>
		<tr>  
			<td>tipo:</td>
			<td><select name="type">
					<option value="Data Structures" selected>venda</option>
					<option value="Data Mining">compra</option>
				</select>
			</td>
		</tr>

	</table>  
	
<input type="submit" value="Remover"/>
</fieldset>
</form>    

</br> </br>
<form action="/dsw/filterOfers.do" method="post">  
 <fieldset style="width: 300px">
     <legend> Order Filter</legend>
     <table>
     
     	 <tr>
			<td><input type="hidden" name="userEmail"  value="${usuario.email}"/> <td>
		 </tr>
		 <tr>  
			<td>Data:</td>
			<td><input type="number"   name="dataFilter"  min="0" max ="6" value="${date}"/> </td>
		</tr>
				 <tr>  
			<td>Preco:</td>
			<td><input type="text"   name="precoFilter" value="${price}"/> </td>
		</tr>
		</tr>
		<tr>  
			<td>Personagem:</td>
			<td><input type="text"   name="PersonagemFilter" value="${personagemId}"/> </td>
		</tr>
		

</table>  


<input type="submit" value="Remover"/>
</fieldset>
</form>    

</br> </br>
<ex:Ordens price="${price}" personagemId="${personagemId}" date="${date}" userEmail="${usuario.email}"/>

</div>
</body>
</html>







