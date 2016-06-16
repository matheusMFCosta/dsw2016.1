

package com.tags;

import javax.servlet.jsp.tagext.*;

import dswBD.Personagem;
import dswBD.UsuarioAcesso;
import model.Ofertas;
import model.Usuarios;

import javax.servlet.jsp.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Personagens  extends SimpleTagSupport {

  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
	Personagem meuAcesso = new Personagem();
	ArrayList<model.Personagens> meuPersonagemList =  meuAcesso.getPersonagensTable();
	

	
	
	
	out.write("<form>");
	out.write("        <fieldset style=\"width: 300px\">"+
            "<legend> Lista de Personagens </legend>");
	out.write("<table border=\"1\" style=\"width:100%\">");
	
	out.write("<tr>");
	out.write("<td >Id</td>");
	out.write("<td>Personagem</td>");
	out.write("</tr>");
	for(model.Personagens i : meuPersonagemList){

		out.write("<td>"+i.getId() +" </td> ");
		out.write("<td>"+i.getNome()+"</td>");
		out.write("</tr>");

		
	}
	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");

  }
}