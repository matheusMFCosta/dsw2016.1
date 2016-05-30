<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="ex" uri="WEB-INF/customTag.tld"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/dsw/LogIn.do" method="post">
        <fieldset style="width: 300px">
            <legend> Login to App </legend>
            <table>
                <tr>
                    <td>User Email</td>
                    <td><input type="text" name="userEmail" required="required" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="userPass" required="required" /></td>
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
    <form action="/dsw/CreateUser.jsp" method="post">
    	<input type="submit" value="createUser" 
			name="Submit" id="frm1_submit" />
	</form>
	<form action="/dsw/EnviaToken.jsp" method="post">
    	<input type="submit" value="Forgot password?" 
			name="Submit" id="frm1_submit" />
	</form>
	<form action="/dsw/EditaUsuario.jsp" method="post">
    	<input type="submit" value="edita" 
			name="Submit" id="frm1_submit" />
	</form>

	<ex:UserTable/>
	
	</form>
	    <form action="/dsw/RecuperaSenha.jsp" method="post">
    	<input type="submit" value="email" 
			name="Submit" id="frm1_submit" />
	</form>
</body>
</html>