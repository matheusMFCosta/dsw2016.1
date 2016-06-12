<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib prefix="ex" uri="WEB-INF/customTag.tld"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title>Insert title here</title>


<c:set var="usuario" value=<%=session.getAttribute("usuario")%> scope="page" />
</head>
<body>
	<div class="row">
  <div class="col-sm-4">.</div>
	</div>
	<div class="col-sm-4"></div>
<form action="/dsw/logIn.do" method="post">
        <fieldset style="width: 300px">
        	

            <legend> Login to App </legend>
            <table>
            	
                <tr>
                    <td>User Email</td>
                    <td><input type="text" name="userEmail" value="${usuario.email}" required="required" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="userPass" value="${usuario.senha}"  required="required" /></td>
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
   </div>
   </br>
    <div class="lable">
	   	<div class="row">
	   	<div class="col-sm-4"></div>
	  	<div class="col-sm-4">
	  		<div class="row">
	  		
	  			<div class="col-sm-3">
		    <form action="/dsw/jsp/user/createUser.jsp" method="post">
		    	<input type="submit" value="createUser" 
					name="Submit" id="frm1_submit" />
			</form>
				</div>
				<div class="col-sm-1">
			<form action="/dsw/jsp/user/EnviaToken.jsp" method="post">
		    	<input type="submit" value="Forgot password?" 
					name="Submit" id="frm1_submit" />
			</form>
				</div>
		</div>
		</div>
	</div>

	</br>
	</hr>
	</br>
	<div class="row">
	   	<div class="col-sm-4"></div>
	   	<div class="col-sm-4">
	<ex:UserTable/>
	
	</form>
	    <form action="/dsw/RecuperaSenha.jsp" method="post">
    	<input type="submit" value="email" 
			name="Submit" id="frm1_submit" />
	</form>
	</div>
	</div>
</body>
</html>