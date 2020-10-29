package com.wellsfargo.batch7.ibs.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class HomePage extends HttpServlet {

	public void init() 
	{
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<html><head><title>IBS Application</title></head><body>");
		request.getRequestDispatcher("menu.jsp").include(request, response);
		
		out.println("<h1>A servletgenerated content </h1></body></html>");
	}
	
	
	

}

