<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

<div class="row">
  <div class="col-sm-4">.</div>
	</div>
	<div class="col-sm-4"></div>
<form action="/dsw/createUser.do" method="post">  
 <fieldset style="width: 300px">
     <legend> Create Account</legend>
     <table>
         <tr>
			<td>Name:</td>
			<td><input type="text" name="userName"/> <td>
		 </tr>

		 <tr>  
			<td>Email Id:</td>
			<td><input type="text" name="userEmail"/> </td>
		</tr>
		 <tr>
			<td>CPF:</td>
			<td><input type="text" name="userCPF"/> </td>
		</tr>
		 <tr>
			<td>telefone:</td>
			<td><input type="text" name="userPhone"/></td>
		</tr>
		<tr>
			<td>senha:</td>
			<td><input type="password" name="userPass"/></td>
		</tr>
		<tr>
			<td>Confirma senha:</td>
			<td><input type="password" name="userPassConfirmation"/></td>
		</tr>
	</table>  


<input type="submit" value="register"/>
</fieldset>
</form>    



</body>
</html>