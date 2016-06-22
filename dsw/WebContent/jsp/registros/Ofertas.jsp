
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="ex" uri="../../WEB-INF/customTag.tld"%>
<link href="../../style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<c:set var="usuario" value="${requestScope.usuario}" scope="page" />
<c:set var="date" value="${requestScope.date}" scope="page" />
<c:set var="price" value="${requestScope.price}" scope="page" />
<c:set var="personagemId" value="${requestScope.personagemId}" scope="page" />


    	

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
	
<ex:SaldoDisponivel userEmail="${usuario.email}"/>

<div class="panel panel-default">
<div class="panel-heading">Cancelar Ordem</div>
<div class="panel-body">

<form action="/dsw/removeOfer.do" method="post">  
 <fieldset >
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
					<option value="venda" selected>venda</option>
					<option value="compra">compra</option>
				</select>
			</td>
		</tr>
				<tr>
			<td style="text-align: center;" colspan=2><input type="submit" value="register"/></td>
		</tr>
	</table>  

</fieldset>
</form>  
</div>
</div>  

</br> </br>

<div class="panel panel-default">
<div class="panel-heading">Filtro de ordem</div>
<div class="panel-body">

<form action="/dsw/filterOfers.do" method="post">  
 <fieldset style="width: 300px">

     <table>
     
     	 <tr>
			<td><input type="hidden" name="userEmail"  value="${usuario.email}"/> <td>
		 </tr>
		 <tr>  
			<td>Data: </td>
			<td><input type="number"   name="dataFilter"  min="0" max ="6" value="${date}"/> </td>
		</tr>
				 <tr>  
			<td>Preco: </td>
			<td><input type="text"   name="precoFilter" value="${price}"/> </td>
		</tr>
		</tr>
		<tr>  
			<td>Personagem: </td>
			<td><input type="text"   name="PersonagemFilter" value="${personagemId}"/> </td>
		</tr>
		
				<tr>
			<td style="text-align: center;" colspan=2><input type="submit" value="register"/></td>
		</tr>
</table>  


</fieldset>
</form>
</div>
</div>    

</br> </br>
<ex:Ordens price="${price}" personagemId="${personagemId}" date="${date}" userEmail="${usuario.email}"/>
</div>
</div>


                       </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    
</body>
</html>







