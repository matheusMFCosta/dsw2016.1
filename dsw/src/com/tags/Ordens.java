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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


 

public class Ordens  extends SimpleTagSupport {
	
	private String userEmail = "";
	private String price = "";
	private String date = "";
	private String personagemId = "";
	
	public void setPrice(String price) {
		this.price = price;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setPersonagemId(String personagemId) {
		this.personagemId = personagemId;
	}

	public void setUserEmail (String InUserEmail)
	{
		userEmail = InUserEmail;
	}

	
	public ArrayList<Ofertas> Filter ( ArrayList<Ofertas> oferList){
		ArrayList<Ofertas> currentList = new ArrayList<Ofertas>();
		ArrayList<Ofertas> currentList2 = new ArrayList<Ofertas>();
		ArrayList<Ofertas> currentList3 = new ArrayList<Ofertas>();

		if(price.equals("") && date.equals("") && personagemId.equals(""))
			return oferList;
		

		if(price.equals("")){
			currentList = oferList;
		}
		else {
			System.out.println("111");
			for(Ofertas i : oferList){
				if(!(i.getPrecoUnitario() >= Float.parseFloat(price))){
				    currentList.add(i);   
				}
			}				
		}
		
		if(personagemId.equals("")){
			currentList2 = currentList;
		}
		else{
			System.out.println("id2: "+personagemId);
			for(Ofertas i : currentList){
				if(i.getIdPersonagem() == Integer.parseInt(personagemId)){
					currentList2.add(i);
				}	
			}
		}
		if(date.equals("")){
			currentList3 = currentList2;
		}		
		else{
		for(Ofertas i : currentList2){
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			String reportDate = df.format(i.getData());
			String[] splitedDate = reportDate.split("/");
			Date today = Calendar.getInstance().getTime();        
			String todayDate = df.format(today);
			String[] SplitedTodayDate = todayDate.split("/");
			
			
			if(Integer.parseInt(splitedDate[0])  >= Integer.parseInt(date)){
				currentList3.add(i);
			}	
		}
	}
		return currentList3;
	}

  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
	Oferta newOferta = new Oferta();
	UsuarioAcesso meUsuarioAcesso = new UsuarioAcesso();
    Usuarios meuUsuario = meUsuarioAcesso.getUsuario(userEmail);
    
	ArrayList<Ofertas> meuPersonagemList =  newOferta.getUserOfertasVendaTable(meuUsuario.getId());
	meuPersonagemList = this.Filter(meuPersonagemList);
	
	

	
	out.write("<form>");
	out.write("        <fieldset style=\"width: 600px\">"+
            "<legend> Lista de Ofertas de Venda </legend>");
	out.write("<table border=\"1\" style=\"width:100%\">");
	
	out.write("<tr>");
	out.write("<td >Id</td>");
	out.write("<td>Personagem</td>");
	out.write("<td>Quantidade</td>");
	out.write("<td>Preco unitario</td>");
	out.write("<td>Status</td>");
	out.write("<td>Data</td>");
	out.write("</tr>");
	
	
	for(Ofertas i : meuPersonagemList){
		out.write("<tr>");
//		out.write("<td>ID:"+i.getId() +"  Personagem: "+i.getIdPersonagem()+" Quantidade: "+i.getQuantidade()+
//				"  preco: "+i.getPrecoUnitario()+" Status: "+i.getStatus()+"data:"+i.getData()+"  </td>");
		out.write("<td >"+i.getId()+"</td>");
		out.write("<td>"+i.getIdPersonagem()+"</td>");
		out.write("<td>"+i.getQuantidade()+"</td>");
		out.write("<td>"+i.getPrecoUnitario()+"</td>");
		out.write("<td>"+i.getStatus()+"</td>");
		out.write("<td>"+i.getData()+"</td>");
		out.write("</tr>");
		
	}

	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");
	out.write("</br>");
	out.write("</br>");

	
	/*-------------------------------- Compra ---------------*/
	
	meuPersonagemList =  newOferta.getUserOfertasCompraTable(meuUsuario.getId());
	meuPersonagemList = this.Filter(meuPersonagemList);
	out.write("<form>");
	out.write("        <fieldset style=\"width: 600px\">"+
            "<legend> Lista de Ofertas de Compra </legend>");
	out.write("<table border=\"1\" style=\"width:100%\">");
	
	out.write("<tr>");
	out.write("<td >Id</td>");
	out.write("<td>Personagem</td>");
	out.write("<td>Quantidade</td>");
	out.write("<td>Preco unitario</td>");
	out.write("<td>Status</td>");
	out.write("<td>Data</td>");
	out.write("</tr>");
	
	
	for(Ofertas i : meuPersonagemList){
		out.write("<td >"+i.getId()+"</td>");
		out.write("<td>"+i.getIdPersonagem()+"</td>");
		out.write("<td>"+i.getQuantidade()+"</td>");
		out.write("<td>"+i.getPrecoUnitario()+"</td>");
		out.write("<td>"+i.getStatus()+"</td>");
		out.write("<td>"+i.getData()+"</td>");
		out.write("</tr>");
		
	}
	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");

  

  }
  
}