package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/seg")
public class ServletGet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectedIp = (String) getServletContext().getAttribute("connectedIp");
		String connectedUser = (String) getServletContext().getAttribute("connectedUser");

		PrintWriter out = response.getWriter();
		out.print("<p>connectedIp : " + connectedIp + "</>");
		out.print("<p>connectedUser : " + connectedUser + "</>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
