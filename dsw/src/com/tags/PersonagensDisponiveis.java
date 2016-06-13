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

class PersonagensClass {
	String name;
	int id;
	int quantidade;
	
	public PersonagensClass(String name, int id, int quantidade) {
		super();
		this.name = name;
		this.id = id;
		this.quantidade = quantidade;
	}
	public PersonagensClass() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	

}

public class PersonagensDisponiveis  extends SimpleTagSupport {
	

  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
	Oferta newOfertaAcesso = new Oferta();
	ArrayList<Ofertas> minhasOfertas = newOfertaAcesso.getOfertasTable();
	Personagem personagemAcesso = new Personagem();
	ArrayList<PersonagensClass> personagemTable = new ArrayList<PersonagensClass>();
	
	boolean create = true;
	for(Ofertas i : minhasOfertas){
		if(i.getTipo() == 0){
			if(i.getStatus() == 0){
				create = true;
				for(PersonagensClass c : personagemTable){
					if(i.getIdPersonagem() ==  c.getId()){
						c.setQuantidade(c.getQuantidade()+i.getQuantidade());
						create = false;
					}
				}
				if(create){
					model.Personagens meuPersonagem = personagemAcesso.getPersonagem(i.getIdPersonagem());
					PersonagensClass minhaPersonagemClass = new PersonagensClass(meuPersonagem.getNome(),meuPersonagem.getId(),i.getQuantidade());
					personagemTable.add(minhaPersonagemClass);
				}
			}
		}
	}
	
	out.write("<form>");
	out.write("        <fieldset style=\"width: 600px\">"+
            "<legend> Lista de Personagems disponiveis </legend>");
	out.write("<table>");
	for(PersonagensClass i : personagemTable){
		out.write("<tr>");
		out.write("<td>ID:"+i.getId() +"  Name: "+i.getName()+" Quantidade: "+i.getQuantidade()+"</td>");
		out.write("</tr>");
		
	}
	

	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");
	out.write("</br>");
	out.write("</br>");
  

  }
  
}