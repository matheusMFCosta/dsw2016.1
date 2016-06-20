package com.tags;

import javax.servlet.jsp.tagext.*;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import dswBD.CasamentosAcesso;
import dswBD.Oferta;
import dswBD.Personagem;
import dswBD.UsuarioAcesso;
import model.CasamentosOferta;
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


 

public class Historico  extends SimpleTagSupport {
	
	private String initialDate;
	private String FinalDate;

	
	public String getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}

	public String getFinalDate() {
		return FinalDate;
	}

	public void setFinalDate(String finalDate) {
		FinalDate = finalDate;
	}

	public ArrayList<Ofertas> Filter ( ArrayList<CasamentosOferta> InOferList) throws java.text.ParseException{
		ArrayList<Ofertas> oferList = new ArrayList<Ofertas>();
		Oferta minhaOferta = new Oferta();
			for(CasamentosOferta i: InOferList){
				System.out.println(i.getIdOfertaCompra());
				System.out.println(minhaOferta.getOferta(i.getIdOfertaCompra()));
				oferList.add(minhaOferta.getOferta(i.getIdOfertaCompra()));
			}
		ArrayList<Ofertas> currentList = new ArrayList<Ofertas>();

		
		if(initialDate.equals("") &&  FinalDate.equals(""))
			return oferList;
		
		
		DateFormat formatter = new SimpleDateFormat("yy-dd-MM");

		Date initialDateObject = (Date)formatter.parse(initialDate);
		Date finalDateObject = (Date)formatter.parse(FinalDate);	
		
		for(Ofertas i : oferList){
			DateFormat formatterSql = new SimpleDateFormat("yy-MM-dd");	
			Date actualDate = (Date)formatterSql.parse(i.getData().toString());
			
			if( (initialDateObject.before(actualDate) &&finalDateObject.after(actualDate)) && i.getTipo()==3){
			    currentList.add(i);   
			}
						
		}
			
		return currentList;
	}

  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
	Oferta newOferta = new Oferta();
	CasamentosAcesso meuCasamento = new CasamentosAcesso();
	UsuarioAcesso meUsuarioAcesso = new UsuarioAcesso();
	
	ArrayList<CasamentosOferta> meuPersonagemListFilter =  meuCasamento.getCasamentoOfertas();
	ArrayList<Ofertas> meuPersonagemList =  newOferta.getOfertasTable();
	try {
		meuPersonagemList = this.Filter(meuPersonagemListFilter);
	} catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	float[][]  meusValores = new float[63][2];
	for(Ofertas i:  meuPersonagemList){
		meusValores[i.getIdPersonagem()][0] = i.getPrecoUnitario();
		meusValores[i.getIdPersonagem()][1] = meusValores[i.getIdPersonagem()][1]+1;
	}
	Personagem meuAcessoPersonagem = new Personagem();


	
	out.write("<form>");
	out.write("        <fieldset style=\"width: 100%\">"+
            "<legend> Lista de Personagens</legend>");
	out.write("<table border=\"1\" style=\"width:100%\">");
	
	out.write("<thead>");
	out.write("<tr>");
	out.write("<th >Id</th>");
	out.write("<th>Personagem</th>");
	out.write("<th>Valor Medio </th>");
	out.write("<th>Valor Total</th>");
	out.write("<th>Quantidade Vendida</th>");
	out.write("</tr>");
	out.write("</thead>");
	
	out.write("<tbody>");
	for(int  i=0; i<63; i++){
		float valorMedio = meusValores[i][0]/meusValores[i][1];
		model.Personagens meupersonagem = meuAcessoPersonagem.getPersonagem(i);
		if(meusValores[i][1]>0){
			out.write("<tr>");
			out.write("<td>"+i+"</td>");
			out.write("<td>"+meupersonagem.getNome()+"</td>");
			out.write("<td>"+valorMedio+"</td>");
			out.write("<td>"+meusValores[i][0] +"</td>");
			out.write("<td>"+meusValores[i][1]+"</td>");
			out.write("</tr>");
		}
	}
	out.write("</tbody>");

	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");
	out.write("</br>");
	out.write("</br>");

	
  }
}