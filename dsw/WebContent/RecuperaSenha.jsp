<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/dsw/confirmaToken.do" method="post">
        <fieldset style="width: 300px">
            <legend> mudar senha </legend>
            <table>
                <tr>
                    <td>Seu email</td>
                    <td><input type="text" name="userEmail" required="required" /></td>
                </tr>
                <tr>
                    <td>Token</td>
                    <td><input type="text" name="userToken" required="required" /></td>
                </tr>
                <tr>
                    <td>Senha antiga</td>
                    <td><input type="text" name="senhaAntiga" required="required" /></td>
                </tr>
                <tr>
                    <td>Nova senha</td>
                    <td><input type="text" name="novaSenha" required="required" /></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Login" /></td>
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