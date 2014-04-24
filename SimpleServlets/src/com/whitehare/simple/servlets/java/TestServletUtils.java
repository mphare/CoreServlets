package com.whitehare.simple.servlets.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whitehare.simple.servlets.utils.ServletUtilities;

@WebServlet("/testServletUtils")
public class TestServletUtils extends HttpServlet
{

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Simple Servlet with ServletUtils";
    out.println(ServletUtilities.htmlHeadWithTitle(title) + "<h1>" + title + "</h1>\n"
        + "<p>Still, a lot of HTML, but now with CSS and Utilities</p>\n" + ServletUtilities.htmlPierson()
        + ServletUtilities.htmlFooter());
  }

}
