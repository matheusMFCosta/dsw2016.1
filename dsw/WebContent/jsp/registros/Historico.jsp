
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../../style.css" rel="stylesheet">
<%@ taglib prefix="ex" uri="../../WEB-INF/customTag.tld"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<c:set var="usuario" value="${requestScope.usuario}" scope="page" />
<c:set var="initialDate" value="${requestScope.initialDate}" scope="page" />
<c:set var="finalDate" value="${requestScope.finalDate}" scope="page" />


<title>Insert title here</title>
</head>
<body>

 <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Olá ${usuario.nome}

                        
                    </a>
                </li>
                <li>
                	<a href="/dsw/jsp/user/EditaUsuario.jsp" method="post">
                    Dados do Usuario
                    </a>
 
                </li>
                <li>
                    <a href="/dsw/jsp/user/EditaSenha.jsp" method="post">
                    Editar Senha
                    </a>
                </li>
                <li>
                    <a href="/dsw/jsp/registros/Transferencia.jsp?cpf=12345678901&bankNumber=123&AgencyNumber=12345&AccountNumber=123456&ammount=12" method="post">
                   Transferencia
                    </a>
                </li>
                <li>
               
                    <a href="/dsw/jsp/registros/RegistrarPersonagem.jsp" method="post">                
                    Registrar Personagem
                    </a>
                </li>
                <li>
               
                    <a href="/dsw/jsp/registros/Ofertas.jsp" method="post">                
                    Suas Ofertas
                    </a>
                </li>
                <li>
                   	<a href="/dsw/jsp/registros/Historico.jsp" method="post">                
                    	Historico de personagem
                    </a>
                </li>
                <li>
                   	<a href="/dsw/jsp/compraEVenda/OfertaDeVenda.jsp" method="post">                
                    	Oferta de Venda
                    </a>
                </li>
                

                <li>
                                       	<a href="/dsw/jsp/compraEVenda/OfertaDeCompra.jsp" method="post">                
                    	Oferta de Compra
                    </a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">

<div class="row">
  <div class="col-sm-3"></div>
 
	<div class="col-sm-6">
	   

</br> </br>
<form action="/dsw/historicoPersonagem.do" method="post">  
 <fieldset style="width: 300px">
     <legend>Filtro do Historico </legend>
     <table>
     
     	 <tr>
			<td><input type="hidden" name="userEmail"  value="${usuario.email}"/> <td>
		 </tr>
		 <tr>  
			<td>Data Inicial: </td>
			<td><input type="date"   name="initialDate"  value="${initialDate}"/> </td>
		</tr>
		<tr>  
			<td>Data Final: </td>
			<td><input type="date"   name="finalDate"   value="${finalDate}"/> </td>
		</tr>
		</tr>

		
				<tr>
			<td style="text-align: center;" colspan=2><input type="submit" value="register"/></td>
		</tr>
</table>  

</fieldset>
</form>    

</br> </br>
<ex:Historico  initialDate="${initialDate}" finalDate="${finalDate}"/>
<ex:Extrato userEmail="${usuario.email}"  initialDate="${initialDate}" finalDate="${finalDate}"/>

</div>
</body>


                       </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
</html>







