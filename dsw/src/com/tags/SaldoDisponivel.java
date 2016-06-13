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
	
    int meuSlado = meUsuarioAcesso.calculaSaldoDisponivelDinheiro(meuUsuario.getId(), 0);
	out.write("        <fieldset style=\"width: 600px\">"+
            "<legend> Saldo disponivel: </legend>");
    out.write("<p>dinheiro: R$"+meuSlado+"</p> </br>");
    
    
    for(int i =1; i<=63;i++){
    	numPersonagemDisponivel = meUsuarioAcesso.calculaSaldoDisponivelPersonagem(meuUsuario.getId(),i, 0);
    	if(numPersonagemDisponivel != 0){
    		model.Personagens meuPersonagem = personagemAcesso.getPersonagem(i);
    		out.write("<p> Personagens: </p>"+"<p>"+"ID:"+meuPersonagem.getId()+" Nome: "+meuPersonagem.getNome()+
    				" Quantidade: "+numPersonagemDisponivel+"</p>");
    	}
    	
    }
	out.write("</br>");

	
	/*-------------------------------- Compra ---------------*/
	

  

  }
  
}