

package com.tags;

import javax.servlet.jsp.tagext.*;

import dswBD.Personagem;
import dswBD.UsuarioAcesso;
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
	out.write("<table>");
	for(model.Personagens i : meuPersonagemList){
		out.write("<tr>");
		out.write("<td>"+i.getId() +" - "+i.getNome()+"</td>");
		out.write("</tr>");
		
	}
	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");

  }
}