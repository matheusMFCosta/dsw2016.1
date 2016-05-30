
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

public class ActionDsw extends Action {
	
	
	@DisableUserVerification
	@Error("/Index.jsp")
	@Success("/Home.jsp")
	public String home() throws ActionException
	{
        	return SUCCESS;
	}
	
	@DisableUserVerification
	@Error("/Index.jsp")
	@Success("/Welcome.jsp")
	public String logIn() throws ActionException
	{
		
		String userEmail = getParameter("userEmail");
		String userPass = getParameter("userPass");
		UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
		Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);

        if(meuUsuario!=null){
        	if(meuUsuario.getSenha().equals(userPass))
        		return SUCCESS;	
        	return ERROR;
        }
        return ERROR;
	}
	
	
			
	@DisableUserVerification
	@Error("/CreateUser.jsp")
	@Success("/Home.do")		
	public String createUser() throws ActionException
	{
		  
        
        String userName=getParameter("userName");  
        String userPass=getParameter("userPass");
        String userEmail=getParameter("userEmail");  
        String userCPF=getParameter("userCPF");
        String userPhone=getParameter("userPhone");
        
        UsuarioAcesso meuUsuario = new UsuarioAcesso();
        String emailBody = "Voce criou uma conta no DSW Project \n "+
        		"Seu User name é: "+ userEmail +
        		"Para trocar de Senha entre: "+ "http://localhost:8080/dsw/RecuperaSenha.jsp";
        
        String[] userEmailFrom = new String[] {userName}; 
        SendEmail.sendFromGMail(userEmailFrom,emailBody);
        if(meuUsuario.setUsuario(userName, userPhone, userCPF, userEmail, userPass))
        	return SUCCESS;

		return ERROR;
		
	}
	
	
	@DisableUserVerification
	@Error("/EnviaToken.jsp")
	@Success("/Home.jsp")		
	public String enviaToken() throws ActionException, SQLException
	{
		     
        String userName=getParameter("userEmail");
        String[] userEmail = new String[] {userName}; 
        
        UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
        Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail[0]);  
        if(meuUsuario ==null)
        	return ERROR;
        
        System.out.println(meuUsuario);
        int userId = meuUsuario.getId();
        
        
        Random newRandom = new Random();
        int token = newRandom.nextInt(Integer.MAX_VALUE);
        String emailBody = "Token: "+token+"\n link: http://localhost:8080/dsw/RecuperaSenha.jsp";
        SendEmail.sendFromGMail(userEmail,""+emailBody);
        

        
        TokensAcesso meuTokenAcesso = new TokensAcesso();
        Calendar calendar = Calendar.getInstance();
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
        meuTokenAcesso.insereToken(userId, ""+token, ourJavaDateObject);
       
		return SUCCESS;
		
	}
	
	@DisableUserVerification
	@Error("/RecuperaSenha.jsp")
	@Success("/Home.jsp")		
	public String confirmaToken() throws ActionException, SQLException
	{
	
		
		String userEmail = getParameter("userEmail");
        String userToken=getParameter("userToken"); 
        String senhaAntiga=getParameter("senhaAntiga");
        String novaSenha=getParameter("novaSenha");
        
        TokensAcesso meuTokenAcesso = new TokensAcesso();
        UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
        Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);  
        int userId = meuUsuario.getId();              
        ArrayList<Tokens> meusTokens = meuTokenAcesso.getUserTokens(userId);
        Calendar calendar = Calendar.getInstance();
        
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
        for(Tokens meuToken : meusTokens ){
        	if(meuToken.getToken().equals(userToken) && ourJavaDateObject.toString().equals(meuToken.getValidade().toString())){
        			meuUsuarioAcesso.trocaSenha(userId,novaSenha);
	        		return SUCCESS;
        	
        	}
        }
        	  
  
		return ERROR;
	}
	
	@DisableUserVerification
	@Error("/EditaUsuario.jsp")
	@Success("/Home.do")		
	public String editaUsuario() throws ActionException, SQLException{
		
		String userEmail = getParameter("userEmail");
		
        UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
        Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);
        
        if(meuUsuario ==null)
        	return ERROR;
        int userId = meuUsuario.getId();
        String userName = getParameter("userName");
        String userPhone =  getParameter("userPhone");
        String userCpf =  getParameter("userCPF");
        String userPhoto = meuUsuario.getFoto();

        meuUsuarioAcesso.editUsuario(userId,userName, userPhone, userCpf, userPhoto);
        
       
		return SUCCESS;
	}
	
	@DisableUserVerification
	@Error("/EditaUsuario.jsp")
	@Success("/EditaUsuario.jsp")		
	public String getUsuario() throws ActionException, SQLException{
		
		String userEmail = getParameter("userEmail");
        UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
        Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);

        
        setAttribute("usuario", meuUsuario);
		return SUCCESS;
	}
	

}