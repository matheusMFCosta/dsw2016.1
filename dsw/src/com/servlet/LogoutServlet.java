package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dswBD.usuarioAcesso;
import model.usuarios;

public class LogoutServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        System.out.println("3333");

		HttpSession session = request.getSession(false);
		if (!session.isNew()) {
		    session.invalidate();
		    session = request.getSession();
		}
		
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.forward(request,response);  

    }  

}
