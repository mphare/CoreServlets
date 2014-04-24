package com.whitehare.simple.servlets.java;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(
			"<!DOCTYPE html>\n" +
			"<html>\n"+
			"<head><title>A Simple HTML Servlet</title></head>\n" +
			"<body>\n" +
			"<h1>A Simple HTML Servlet</h1>\n" +
			"<p>Still, a lot of HTML</p>\n" +
			"</body></html>\n"
			);
	}

}
