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

//Lista todos os personagens Disponiveis
class PersonagensClass {
	String name;
	int id;
	int quantidade;
	float preco;
	
	public PersonagensClass(String name, int id, int quantidade, float preco) {
		super();
		this.name = name;
		this.id = id;
		this.quantidade = quantidade;
		this.preco = preco;
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
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
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
					PersonagensClass minhaPersonagemClass = new PersonagensClass(meuPersonagem.getNome(),meuPersonagem.getId(),i.getQuantidade(),i.getPrecoUnitario());
					personagemTable.add(minhaPersonagemClass);
				}
			}
		}
	}

	
	out.write("</br> </br>");

	out.write("        <fieldset style=\"width:100%\">"+
            "<legend> Personagens Disponiveis </legend>");
    
	out.write("<form>");
	out.write("<table border=\"1\" style=\"width:100%\">");
	
	out.write("<thead>");
	out.write("<tr>");
	out.write("<th >Id</th>");
	out.write("<th>Nome</th>");
	out.write("<th>Quantidade</th>");
	out.write("<th>preco</th>");
	out.write("</tr>");
	out.write("</thead>");
	
	out.write("<tbody>");
	for(PersonagensClass i : personagemTable){


		out.write("<td>"+i.getId() +" </td> ");
		out.write("<td>"+i.getName() +" </td> ");
		out.write("<td>"+i.getQuantidade() +" </td> ");
		out.write("<td>"+i.getPreco() +" </td> ");
		out.write("</tr>");
		
	}
	out.write("</tbody>");
	

	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");
	

	out.write("</br>");

  }
  
}