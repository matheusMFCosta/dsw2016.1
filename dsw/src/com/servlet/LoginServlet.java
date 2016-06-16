package com.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dswBD.UsuarioAcesso;
import model.Usuarios;


public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String userEmail=request.getParameter("userEmail");  
        UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
		Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);
		System.out.println("ultimo"+meuUsuario.getUltimoLogin());

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = Calendar.getInstance().getTime();        
		meuUsuario.setUltimoLogin(today);

		
		
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("usuario", meuUsuario);
     
        RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
        //rd.forward(request,response);  
 
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    }  
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String userEmail=request.getParameter("userEmail");  
        UsuarioAcesso meuUsuarioAcesso = new UsuarioAcesso();
		Usuarios meuUsuario = meuUsuarioAcesso.getUsuario(userEmail);

		
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("usuario", meuUsuario);
     
        RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
        rd.forward(request,response);  
 

        out.close();  
    }  
} 
