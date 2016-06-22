package com.tags;

import javax.servlet.jsp.tagext.*;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import dswBD.CasamentosAcesso;
import dswBD.Oferta;
import dswBD.Personagem;
import dswBD.Transferencia;
import dswBD.UsuarioAcesso;
import model.CasamentosOferta;
import model.LancamentosDinheiro;
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


 
//Responsavel por mostrar Historico e informações da compra e venda de Personagens
public class Extrato  extends SimpleTagSupport {
	
	private String initialDate;
	private String FinalDate;
	private String userEmail;
	

	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

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

	public ArrayList<LancamentosDinheiro>Filter ( ArrayList<LancamentosDinheiro> InOferList, String userEmail) throws java.text.ParseException{
		
		UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
		Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);
		ArrayList<LancamentosDinheiro> userLancamentos = new  ArrayList<LancamentosDinheiro>();
		ArrayList<LancamentosDinheiro> currentList = new  ArrayList<LancamentosDinheiro>();
		
		for(LancamentosDinheiro i : InOferList ){
			if(i.getIdusuario() == meuUsuario.getId()){
				userLancamentos.add(i);
			}	
		}
		
		if(initialDate.equals("") &&  FinalDate.equals(""))
			return userLancamentos;
		
		//Ja foi filtrado o usuario =)
		DateFormat formatter = new SimpleDateFormat("yy-MM-dd");


		Date initialDateObject = (Date)formatter.parse(initialDate);
		Date finalDateObject = (Date)formatter.parse(FinalDate);	
		for(LancamentosDinheiro i : userLancamentos){
			DateFormat formatterSql = new SimpleDateFormat("yy-MM-dd");	
			Date actualDate = (Date)formatterSql.parse(i.getData().toString());

			
			Calendar c = Calendar.getInstance();
			c.setTime(finalDateObject);
			c.add(Calendar.YEAR, 0);
			finalDateObject= c.getTime();
			
			
			if( (initialDateObject.before(actualDate) &&finalDateObject.after(actualDate))){
			    currentList.add(i);   
			}
						
		}
			
		return currentList;
	}

  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
	Oferta newOferta = new Oferta();
	CasamentosAcesso meuCasamento = new CasamentosAcesso();
	UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
	Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);
	float saldo = meuUsuarioAcesso.calculaSaldoDisponivelDinheiro(meuUsuario.getId(), 0);
	
	Transferencia minhaTransferenciaAcesso = new Transferencia();
	
	ArrayList<LancamentosDinheiro> minhaTransferencia = minhaTransferenciaAcesso.getLancamentosDinheiro();
	
	try {
		minhaTransferencia = this.Filter(minhaTransferencia,userEmail);
	} catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	


	
	out.write("<form>");
	out.write("        <fieldset style=\"width: 100%\">"+
            "<legend> Extrato</legend>");
	out.write("<table border=\"1\" style=\"width:100%\">");
	
	out.write("<thead>");
	out.write("<tr>");
	out.write("<th >Id</th>");
	out.write("<th>Acao</th>");
	out.write("<th>Data </th>");
	out.write("<th>Valor</th>");
	out.write("<th>saldo</th>");
	out.write("</tr>");
	out.write("</thead>");
	
	out.write("<tbody>");
	saldo =0;
	int index=0;
	for(LancamentosDinheiro i:  minhaTransferencia){
		index++;
			if(i.getOperacao() == 0 || i.getOperacao() == 3 ){
				saldo = saldo + i.getValor();
			}
			if(i.getOperacao() == 1 || i.getOperacao() == 2 ){
				saldo = saldo - i.getValor();
			}
			
			out.write("<tr>");
			out.write("<td>"+index+"</td>");
			out.write("<td>"+i.getHistorico()+"</td>");
			out.write("<td>"+ i.getData()+"</td>");
			out.write("<td>"+i.getValor()+"</td>");
			out.write("<td>"+saldo+"</td>");
			out.write("</tr>");
		
	}
	out.write("</tbody>");

	out.write("</table>");
	out.write("</fildset>");
	out.write("</form>");
	out.write("</br>");
	out.write("</br>");

	
  }
}
