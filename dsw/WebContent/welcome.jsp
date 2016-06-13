<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	    <!-- Custom CSS -->
    <link href="style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<title>Welcome <%=session.getAttribute("usuario")%></title>
</head>
<body>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Start Bootstrap
                    </a>
                </li>
                <li>
                	<a href="/dsw/jsp/user/EditaUsuario.jsp" method="post">
                    Editar Usuario
                    </a>
 
                </li>
                <li>
                    <a href="/dsw/jsp/user/EditaSenha.jsp" method="post">
                    Editar Senha
                    </a>
                </li>
                <li>
                    <a href="/dsw/jsp/registros/Transferencia.jsp?bankNumber=123&AgencyNumber=12345&AccountNumber=123456&ammount=12" method="post">
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
  <div class="col-sm-4 col-md-4"></div>
  <div class="col-sm-4">
	
    <h3>Login Concluido!!!</h3>
    <p>usuario: ${usuario.nome}</p>
    <p>email: ${usuario.email}</p>
    <p>cpf: ${usuario.cpf}</p>
    <p>telefone: ${usuario.telefone}</p>
    <p>senha: ${usuario.senha}</p>
    

    
  <div class="row">
  <div class="col-sm-3 col-md-3">



		</div>
	  <div class="col-sm-3 col-md-3">
	 <form action="/dsw/jsp/user/EditaSenha.jsp" method="post">
    	<input type="submit" value="edita senha" 
			name="Submit" id="frm1_submit" />
	</form>
		</div>
	  <div class="col-sm-3 col-md-3">
	<form action="/dsw/jsp/user/logoutServlet" method="post">
    	<input type="submit" value="Log out" 
			name="Submit" id="frm1_submit" />
	</form>
	</div>
    
    </div>
    </div>
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