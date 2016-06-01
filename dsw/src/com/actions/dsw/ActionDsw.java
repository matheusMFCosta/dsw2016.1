
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
	@Error("/error")
	@Success("/home.jsp")
	public String home() throws ActionException
	{
		
        	return SUCCESS;
	}
	
	@DisableUserVerification
	@Error("/error")
	@Success("/loginServlet")
	public String logIn() throws ActionException
	{
		
		String userEmail = getParameter("userEmail");
		String userPass = getParameter("userPass");
		UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
		Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);   
		System.out.println("---1");
        if(meuUsuario!=null){
        	if(meuUsuario.getSenha().equals(userPass)){
        		setAttribute("usuario", meuUsuario);
        		return SUCCESS;	
        	}
        	setAttribute("nextPage", "home.jsp");
        	setAttribute("errorMessage", "Senha ou usuario invalidos ");
        	return ERROR;
        }
        setAttribute("nextPage", "home.jsp");
        setAttribute("errorMessage", "Senha ou usuario invalidos ");
        
        return ERROR;
	}
	
	
			
	@DisableUserVerification
	@Error("/error")
	@Success("/home.do")		
	public String createUser() throws ActionException
	{
		  
        
        String userName=getParameter("userName");  
        String userPass=getParameter("userPass");
        String userEmail=getParameter("userEmail");  
        String userCPF=getParameter("userCPF");
        String userPhone=getParameter("userPhone");
        String userPassConfirmation = getParameter("userPassConfirmation");
        
        
        if(!userPassConfirmation.equals(userPass)){
        	setAttribute("nextPage", "createUser.jsp");
        	setAttribute("errorMessage", "A senhas sao diferentes");
        	return ERROR;
        }
        
        
        UsuarioAcesso meuUsuario = new UsuarioAcesso();
        String emailBody = "Voce criou uma conta no DSW Project \n "+
        		"Seu User name é: "+ userEmail +
        		"Para trocar de Senha entre: "+ "http://localhost:8080/dsw/RecuperaSenha.jsp";
        
        String[] userEmailFrom = new String[] {userName}; 
        SendEmail.sendFromGMail(userEmailFrom,emailBody);
        if(meuUsuario.setUsuario(userName, userPhone, userCPF, userEmail, userPass))
        	return SUCCESS;

    	setAttribute("nextPage", "createUser.jsp");
    	setAttribute("errorMessage", "usuario existente");
		return ERROR;
		
	}
	
	
	@DisableUserVerification
	@Error("/error")
	@Success("/home.jsp")		
	public String enviaToken() throws ActionException, SQLException
	{
		     
        String userName=getParameter("userEmail");
        String[] userEmail = new String[] {userName}; 
        
        UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
        Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail[0]);  
        if(meuUsuario ==null){
        	setAttribute("nextPage", "EnviaToken.jsp");
        	setAttribute("errorMessage", "Email invalido- Usuario nao existente");
        	return ERROR;
        }
        
        System.out.println(meuUsuario);
        int userId = meuUsuario.getId();     
        
        Random newRandom = new Random();
        int token = newRandom.nextInt(Integer.MAX_VALUE);
        String emailBody = "Token: "+token+"\n link: http://localhost:8080/dsw/RecuperaSenha.jsp?userEmail="+meuUsuario.getEmail();
        SendEmail.sendFromGMail(userEmail,""+emailBody);       
      
        TokensAcesso meuTokenAcesso = new TokensAcesso();
        Calendar calendar = Calendar.getInstance();
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
        meuTokenAcesso.insereToken(userId, ""+token, ourJavaDateObject);
       
		return SUCCESS;
		
	}
	
	@DisableUserVerification
	@Error("/RecuperaSenha.jsp")
	@Success("/home.jsp")		
	public String confirmaToken() throws ActionException, SQLException
	{
			
		String userEmail = getParameter("userEmail");
        String userToken=getParameter("userToken"); 
        String senhaAntiga=getParameter("senhaAntiga");
        String novaSenha=getParameter("novaSenha");
        String novaSenhaConfirmation=getParameter("novaSenhaConfirmation");
        
        
        TokensAcesso meuTokenAcesso = new TokensAcesso();
        UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
        Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);  
        int userId = meuUsuario.getId();              
        ArrayList<Tokens> meusTokens = meuTokenAcesso.getUserTokens(userId);
        Calendar calendar = Calendar.getInstance();
        
        if(!novaSenhaConfirmation.equals(novaSenha)){
        	setAttribute("nextPage", "RecuperaSenha.jsp");
        	setAttribute("errorMessage", "Senhas diferentes");
    		return ERROR;
        }
        
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
        for(Tokens meuToken : meusTokens ){
        	if(meuToken.getToken().equals(userToken) && ourJavaDateObject.toString().equals(meuToken.getValidade().toString())){
        			meuUsuarioAcesso.trocaSenha(userId,novaSenha);
	        		return SUCCESS;       	
        	}
        }
        	  
    	setAttribute("nextPage", "RecuperaSenha.jsp");
    	setAttribute("errorMessage", "Token Invalido");
		return ERROR;
	}
	
	@DisableUserVerification
	@Error("/error")
	@Success("/loginServlet")		
	public String editaUsuario() throws ActionException, SQLException{
		
		String userEmail = getParameter("userEmail");
        UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
        Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);
      
        if(meuUsuario ==null){
        	setAttribute("nextPage", "EditaUsuario.jsp");
        	setAttribute("errorMessage", "Usuario invalido");
        	return ERROR;
        }
        
        int userId = meuUsuario.getId();
        String userName = getParameter("userName");
        String userPhone =  getParameter("userPhone");
        String userCpf =  getParameter("userCPF");
        String userPhoto = meuUsuario.getFoto();

        meuUsuarioAcesso.editUsuario(userId,userName, userPhone, userCpf, userPhoto);
        Usuarios newMeuUsuario = meuUsuarioAcesso.getUsuario(userEmail);
        
		setAttribute("usuario", newMeuUsuario);
        
		return SUCCESS;
	}
	
	@DisableUserVerification
	@Error("/error")
	@Success("/loginServlet")		
	public String editaSenha() throws ActionException, SQLException{
		
		String userEmail= getParameter("userEmail");
        UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
        Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);
         
        if(meuUsuario ==null){
        	setAttribute("nextPage", "EditaSenha.jsp");
        	setAttribute("errorMessage", "Usuario invalido");
        	return ERROR;
        }

        int userId = meuUsuario.getId();
        String userPass = getParameter("userPass");
        String userPassConfirmation =  getParameter("userPassConfirmation");
        String OldUserPass =getParameter("OldUserPass");
        
        if(!userPass.equals(userPassConfirmation)){
        	setAttribute("nextPage", "EditaSenha.jsp");
        	setAttribute("errorMessage", "as senhas sao diferentes");
        	return ERROR;
        }
        
        
        if(!OldUserPass.equals(meuUsuario.getSenha())){
        	setAttribute("nextPage", "EditaSenha.jsp");
        	setAttribute("errorMessage", "senha antiga errada");
        	return ERROR;
        	
        }

        meuUsuarioAcesso.trocaSenha(userId, userPass);
        Usuarios newMeuUsuario = meuUsuarioAcesso.getUsuario(userEmail);
		setAttribute("usuario", newMeuUsuario);

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