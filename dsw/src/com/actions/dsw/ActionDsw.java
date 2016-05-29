
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
import dswBD.tokensAcesso;
import dswBD.usuarioAcesso;
import model.tokens;
import model.usuarios;

public class ActionDsw extends Action {
	
	
	@DisableUserVerification
	@Error("/index.jsp")
	@Success("/home.jsp")
	public String home() throws ActionException
	{
        	return SUCCESS;
	}
	
	@DisableUserVerification
	@Error("/index.jsp")
	@Success("/welcome.jsp")
	public String logIn() throws ActionException
	{
		
		String userEmail = getParameter("userEmail");
		String userPass = getParameter("userPass");
		usuarioAcesso meuUsuarioAcesso = new usuarioAcesso();
		usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);

        if(meuUsuario!=null){
        	if(meuUsuario.getSenha().equals(userPass))
        		return SUCCESS;	
        	return ERROR;
        }
        return ERROR;
	}
	
	
			
	@DisableUserVerification
	@Error("/createUser.jsp")
	@Success("/createUser.jsp")		
	public String createUser() throws ActionException
	{
		  
        
        String userName=getParameter("userName");  
        String userPass=getParameter("userPass");
        String userEmail=getParameter("userEmail");  
        String userCPF=getParameter("userCPF");
        String userPhone=getParameter("userPhone");
        
        usuarioAcesso meuUsuario = new usuarioAcesso();
        if(meuUsuario.setUsuario(userName, userPhone, userCPF, userEmail, userPass))
        	return SUCCESS;

		return ERROR;
		
	}
	
	
	@DisableUserVerification
	@Error("/createUser.jsp")
	@Success("/createUser.jsp")		
	public String enviaToken() throws ActionException, SQLException
	{
		     
        String userName=getParameter("userEmail"); 
        SendEmail.send("dsw", "token", "mf.costa@live.com");
        
//        tokensAcesso meuTokenAcesso = new tokensAcesso();
//        Calendar calendar = Calendar.getInstance();
//        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
//        meuTokenAcesso.insereToken(1, "12", ourJavaDateObject);
       
		return SUCCESS;
		
	}
	
	@DisableUserVerification
	@Error("/RecuperaSenha.jsp")
	@Success("/welcome.jsp")		
	public String confirmaToken() throws ActionException, SQLException
	{
		
		String userEmail = getParameter("userEmail");
        String userToken=getParameter("userToken"); 
        String senhaAntiga=getParameter("senhaAntiga");
        String novaSenha=getParameter("novaSenha");
        
        tokensAcesso meuTokenAcesso = new tokensAcesso();
        usuarioAcesso meuUsuarioAcesso = new usuarioAcesso();
        usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);  
        int userId = meuUsuario.getId();              
        ArrayList<tokens> meusTokens = meuTokenAcesso.getUserTokens(userId);
        Calendar calendar = Calendar.getInstance();
        
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
        for(tokens meuToken : meusTokens ){
        	if(meuToken.getToken().equals(userToken) && ourJavaDateObject.toString().equals(meuToken.getValidade().toString())){
        		if(meuUsuario.getSenha().equals(senhaAntiga)){
        			meuUsuarioAcesso.trocaSenha(userId,novaSenha);
	        		return SUCCESS;
        		}
        	}
        }
        	  
       
		return ERROR;
		
	}
	

}