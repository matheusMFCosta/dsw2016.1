package com.tags;

import javax.servlet.jsp.tagext.*;

import dswBD.Oferta;
import dswBD.Personagem;
import dswBD.UsuarioAcesso;
import model.Ofertas;
import model.Usuarios;

import javax.servlet.jsp.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaldoDisponivel extends SimpleTagSupport {
	
	private String userEmail = "";
	public void setUserEmail (String InUserEmail)
	{
		userEmail = InUserEmail;
	}


  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
	UsuarioAcesso meUsuarioAcesso = new UsuarioAcesso();
	Personagem personagemAcesso = new Personagem();
    Usuarios meuUsuario = meUsuarioAcesso.getUsuario(userEmail);
    int numPersonagemDisponivel;
	
	out.write("</br>");
	out.write("<div class=\"panel panel-default\">");
	out.write("<div class=\"panel-heading\">Saldo Disponivel Dinheiro</div>");
	out.write("<div class=\"panel-body\">");
    
    int meuSlado = meUsuarioAcesso.calculaSaldoDisponivelDinheiro(meuUsuario.getId(), 0);
    out.write("<p>dinheiro: R$"+meuSlado+"</p> </br>");
    
	out.write("</div>");
	out.write("</div>");
    
    
	out.write("</br> </br>");

	
	
	out.write("<form>");
	out.write("        <fieldset style=\"width: 100%\">"+
            "<legend> Saldo Disponivel Personagem </legend>");
	out.write("<table border=\"1\" style=\"width:100%\">");
	
	

	
	out.write("<thead>");
	out.write("<tr>");
	out.write("<th >Id</th>");
	out.write("<th>Nome</th>");
	out.write("<th>Quantidade</th>");
	out.write("</tr>");
	out.write("</thead>");

	out.write("<tbody>");
    for(int i =1; i<=63;i++){
    	numPersonagemDisponivel = meUsuarioAcesso.calculaSaldoDisponivelPersonagem(meuUsuario.getId(),i, 0);
    	if(numPersonagemDisponivel != 0){
    		    		

    		model.Personagens meuPersonagem = personagemAcesso.getPersonagem(i);
    		out.write("<td>"+meuPersonagem.getId() +" </td> ");
    		out.write("<td>"+meuPersonagem.getNome() +" </td> ");
    		out.write("<td>"+numPersonagemDisponivel +" </td> ");
    		out.write("</tr>");
    	}

    }
	out.write("</tbody>");
	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");
	

	out.write("</br>");

	
	/*-------------------------------- Compra ---------------*/
	

  

  }
  
}