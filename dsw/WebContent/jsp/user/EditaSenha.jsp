<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%=session.getAttribute("usuario")%></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

</head>
<body>


<div class="row">
  <div class="col-sm-4"></div>
 

	<div class="col-sm-4">
	
</br></br>
<form action="/dsw/EditaSenha.do" method="post">  
 <fieldset style="width: 300px">
     <legend> Editar Senha</legend>
     <table>
	
		 <tr>
		 
			<td><input type="hidden" name="userEmail"  value="${usuario.email}"/> <td>
		 </tr>

		<tr>
           <td>Senha Antiga</td>
           <td><input type="password" name="OldUserPass" required="required" /></td>
        </tr>
 		<tr>
           <td>Nova Senha</td>
           <td><input type="password" name="userPass" required="required" /></td>
        </tr>
            
        <tr>
            <td>Confirma Senha</td>
            <td><input type="password" name="userPassConfirmation" required="required" /></td>
         </tr>
	</table>  


<input type="submit" value="editar"/>
</fieldset>
</form>    
</div>

</body>
</html>