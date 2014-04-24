package com.whitehare.simple.forms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whitehare.simple.forms.util.ServletUtilities;

@WebServlet("/three-params")
public class ThreeParams extends HttpServlet
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    PrintWriter out = response.getWriter();
    String title = "Three Parameters";
    out.println(ServletUtilities.htmlHeadWithTitle(title));
    out.println("<ul><li>Param1: " + request.getParameter("param1") + "</li>");
    out.println("<li>Param2: " + request.getParameter("param2") + "</li>");
    out.println("<li>Param3: " + request.getParameter("param3") + "</li></ul>" + ServletUtilities.htmlFooter());

  }
}
