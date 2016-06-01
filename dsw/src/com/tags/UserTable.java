package com.tags;

import javax.servlet.jsp.tagext.*;

import dswBD.usuarioAcesso;
import model.usuarios;

import javax.servlet.jsp.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserTable  extends SimpleTagSupport {

  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
	usuarioAcesso meuUAcesso = new usuarioAcesso();
	ArrayList<usuarios> meuUsuarioList =  meuUAcesso.getUsuariosTable();
	
	out.write("<form>");
	out.write("        <fieldset style=\"width: 300px\">"+
            "<legend> Lista de usuarios </legend>");
	out.write("<table>");
	for(usuarios i : meuUsuarioList){
		out.write("<tr><td>"+i.getNome()+" - "+i.getEmail()+" - "+i.getCpf()+"</td></tr>");
		
	}
	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");

  }
}