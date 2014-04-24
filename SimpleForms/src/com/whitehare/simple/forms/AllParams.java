package com.whitehare.simple.forms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whitehare.simple.forms.util.ServletUtilities;

@WebServlet("/all-params")
public class AllParams extends HttpServlet
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    PrintWriter out = response.getWriter();
    String title = "All Parameters";

    out.println(ServletUtilities.htmlHeadWithTitle(title));
    out.println("<h1>" + title + "</h1>");
    out.println("<table><tr><th>Parameter</th><th>Value</th></tr>");

    Enumeration<String> paramNames = request.getParameterNames();
    while (paramNames.hasMoreElements())
    {
      String paramName = (String) paramNames.nextElement();
      out.println("<tr><td>" + paramName + "</td><td>");
      String[] paramValues = request.getParameterValues(paramName);
      if (paramValues.length == 1)
      {
        String paramValue = paramValues[0];
        if (paramValue == null || paramValue.trim().equals(""))
          out.println("<i>Value is missing</i>");
        else
          out.println(paramValue);
      } else
      {
        out.println("<ul>");
        for (int i = 0; i < paramValues.length; i++)
        {
          out.println("<li>" + paramValues[i] + "</li>");
        }
        out.println("</ul>");
      }
    }

    out.println("</table>" + ServletUtilities.htmlFooter());

  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doGet(request, response);
  }
}
