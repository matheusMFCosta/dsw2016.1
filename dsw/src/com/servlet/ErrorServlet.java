package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dswBD.UsuarioAcesso;
import model.Usuarios;

public class ErrorServlet extends HttpServlet{
	
	
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

    	

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String nexPage = (String) request.getAttribute("nextPage");
        String errorMessage=(String) request.getAttribute("errorMessage");

  		
		System.out.println("---"+nexPage);
		System.out.println("---"+errorMessage);
		out.print("<p style=\"color:red\">"+errorMessage+"</p>"); 
	    RequestDispatcher rd=request.getRequestDispatcher(nexPage);  
	    rd.include(request,response);  


        out.close();  
    }

}
