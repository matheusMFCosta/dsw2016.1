package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
    	
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        
        String name=request.getParameter("name");
        
        String userName=request.getParameter("userName");  
        String userPass=request.getParameter("userPass");
        String userEmail=request.getParameter("userEmail");  
        String userCPF=request.getParameter("userCPF");
        String userPhone=request.getParameter("userPhone");  
        
        
        
        
        
        HttpSession session = request.getSession(false);
        if(session!=null)
        //session.setAttribute("name", userName);

        if(true){  
        	System.out.println("--"+name);
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
            rd.forward(request,response);  
        }  
        else{  
//            out.print("<p style=\"color:red\">Sorry username or password error</p>");  
//            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
//            rd.include(request,response);  
        }  

        out.close();  
    }  

}
