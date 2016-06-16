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
  <div class="col-sm-4"></div>
	</div>
	<div class="col-sm-4"></div>
	</br></br>
<form action="/dsw/enviaToken.do" method="post">
        <fieldset style="width: 300px">
            <legend> Recuperar Senha</legend>
            <table>
                <tr>
                    <td>Seu email</td>
                    <td><input type="text" name="userEmail" required="required" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Enviar" /></td>
                </tr>
                <tr>
                	<td>    

         			</td>
         		</tr>
            </table>
</fieldset>
</form>

</body>
</html>