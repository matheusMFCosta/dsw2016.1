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

public class Ordens  extends SimpleTagSupport {
	
	private String userEmail = "";
	public void setUserEmail (String InUserEmail)
	{
		userEmail = InUserEmail;
	}


  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
	Oferta newOferta = new Oferta();
	UsuarioAcesso meUsuarioAcesso = new UsuarioAcesso();
    Usuarios meuUsuario = meUsuarioAcesso.getUsuario(userEmail);
    
	ArrayList<Ofertas> meuPersonagemList =  newOferta.getUserOfertasVendaTable(meuUsuario.getId());
	
	out.write("<form>");
	out.write("        <fieldset style=\"width: 600px\">"+
            "<legend> Lista de Ofertas de Venda </legend>");
	out.write("<table>");
	for(Ofertas i : meuPersonagemList){
		out.write("<tr>");
		out.write("<td>ID:"+i.getId() +"  Personagem: "+i.getIdPersonagem()+" Quantidade: "+i.getQuantidade()+"  preco: "+i.getPrecoUnitario()+" Status: "+i.getStatus()+"</td>");
		out.write("</tr>");
		
	}
	

	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");
	out.write("</br>");
	out.write("</br>");

	
	/*-------------------------------- Compra ---------------*/
	
	meuPersonagemList =  newOferta.getUserOfertasCompraTable(meuUsuario.getId());
	out.write("<form>");
	out.write("        <fieldset style=\"width: 600px\">"+
            "<legend> Lista de Ofertas de Compra </legend>");
	out.write("<table>");
	for(Ofertas i : meuPersonagemList){
		out.write("<tr>");
		out.write("<td>ID:"+i.getId() +"  Personagem: "+i.getIdPersonagem()+" Quantidade: "+i.getQuantidade()+"  preco: "+i.getPrecoUnitario()+" Status: "+i.getStatus()+"</td>");
		out.write("</tr>");
		
	}
	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");

  

  }
  
}