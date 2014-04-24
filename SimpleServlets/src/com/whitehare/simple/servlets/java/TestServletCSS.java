package com.whitehare.simple.servlets.java;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/testServletCSS")
public class TestServletCSS extends HttpServlet {
	
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
			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">" +
			"<link rel=\"stylesheet\" href=\"/SimpleServlets/Style/Master.css\"/>"+
			"<script type=\"text/javascript\" src=\"/ExternalDWP/Scripts/overlib.js\"><!-- overLIB (c) Erik Bosrup --></script>" +
			"<head><title>A Simple HTML Servlet with CSS</title></head>\n" +
			"<body>\n" +
			"<h1>A Simple HTML Servlet</h1>\n" +
			"<p>Still, a lot of HTML, but now with CSS</p>\n" +
			"</body></html>\n"
			);
	}

}
