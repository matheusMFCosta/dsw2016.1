package com.tags;

import javax.servlet.jsp.tagext.*;

import dswBD.UsuarioAcesso;
import model.Usuarios;

import javax.servlet.jsp.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserTable  extends SimpleTagSupport {

  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
	UsuarioAcesso meuUAcesso = new UsuarioAcesso();
	ArrayList<Usuarios> meuUsuarioList =  meuUAcesso.getUsuariosTable();
	
	out.write("<form>");
	out.write("        <fieldset style=\"width: 100%\">"+
            "<legend> Lista de usuarios </legend>");
	out.write("<table>");
	for(Usuarios i : meuUsuarioList){
		out.write("<tr>");
		out.write("<td>"+i.getNome()+" - "+i.getEmail()+" - "+i.getNumeroLogins()+" - "+ i.getSenha()+"</td>");
		out.write("</tr>");
		
	}
	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");

  }
}