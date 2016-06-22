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

        out.print("<div style=\"background-color:#FFAAAA\">"); 
		out.print("<div  class=\"row\">"); 
		out.print("<div class=\"col-sm-5\"></div>"); 
		out.print("<div class=\"col-sm-6\">"); 
		
		out.print("<p style=\"color:red\">"+errorMessage+"</p>"); 
		out.print("</div>"); 
		out.print("</div>"); 
		out.print("</div>");
	    RequestDispatcher rd=request.getRequestDispatcher(nexPage);  
	    rd.include(request,response);  


        out.close();  
    }

}
