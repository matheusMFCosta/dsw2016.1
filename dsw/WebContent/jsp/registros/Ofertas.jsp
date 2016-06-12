
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

<ex:Ordens userEmail="${usuario.email}"/>


</body>
</html>







