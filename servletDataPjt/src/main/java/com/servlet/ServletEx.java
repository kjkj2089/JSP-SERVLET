package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx
 */
public class ServletEx extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId = getServletConfig().getInitParameter("adminId");
		String adminPw = getServletConfig().getInitParameter("adminPw");
		
		PrintWriter out = response.getWriter();
		out.print("<p>adminId : " + adminId + "</p>");
		out.print("<p>adminPw : " + adminPw + "</p>");
		
		String imgDir =getServletContext().getInitParameter("imgDir");
		String testServerIp =getServletContext().getInitParameter("testServerIp");
		
		out.print("<p>imgDir : " + imgDir + "</p>");
		out.print("<p>testServerIp : " + testServerIp + "</p>");
		
		getServletContext().setAttribute("connectedIp", "165.62.58.33");
		getServletContext().setAttribute("connectedUser", "gilddong");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
