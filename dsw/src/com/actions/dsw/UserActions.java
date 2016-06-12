package com.actions.dsw;

import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.utils.SendEmail;

import br.unirio.simplemvc.actions.Action;
import br.unirio.simplemvc.actions.ActionException;
import br.unirio.simplemvc.actions.authentication.DisableUserVerification;
import br.unirio.simplemvc.actions.results.Any;
import br.unirio.simplemvc.actions.results.Error;
import br.unirio.simplemvc.actions.results.ResultType;
import br.unirio.simplemvc.actions.results.Success;
import br.unirio.simplemvc.utils.Crypto;
import dswBD.TokensAcesso;
import dswBD.UsuarioAcesso;
import model.Tokens;
import model.Usuarios;


class UserActions extends Action{
	
	
	
	@DisableUserVerification
	@Error("/error")
	@Success("/home.jsp")
	public String home() throws ActionException
	{	
        	return SUCCESS;
	}
	
	
	
	public String logIn(String userEmail, String userPass)
	{
		UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
		Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail); 
		
        if(meuUsuario!=null){
        	if(meuUsuario.getSenha().equals(userPass)){
        			if(meuUsuario.getNumeroLogins()>=2){
        				setAttribute("nextPage", "home.jsp");
        	        	setAttribute("errorMessage", "Numero de tentativas maior que 3");
        	        	return ERROR;
        			}
        				
        		setAttribute("usuario", meuUsuario);
        		meuUsuarioAcesso.indicaSucesso(meuUsuario.getId());
        		return SUCCESS;	
        	}
        	meuUsuarioAcesso.indicaFalha(meuUsuario.getId());
        	setAttribute("nextPage", "home.jsp");
        	setAttribute("errorMessage", "Senha ou usuario invalidos ");
        	return ERROR;
        }
        setAttribute("nextPage", "home.jsp");
        setAttribute("errorMessage", "Senha ou usuario invalidos ");
        
        return ERROR;
	}
	
	

}
