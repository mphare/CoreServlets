package com.whitehare.cookies.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RepeatVisitor
 */
@WebServlet("/repeat-visitor")
public class RepeatVisitor extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public RepeatVisitor()
  {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    // TODO Auto-generated method stub
    boolean newbie = true;
    PrintWriter out = response.getWriter();

    Cookie[] cookies = request.getCookies();
    if (cookies != null)
    {
      for (Cookie c : cookies)
      {
        if ((c.getName().equals("repeatVisitor")) && (c.getValue().equals("yes")))
        {
          newbie = false;
          break;
        }

      }
    }

    String title;
    if (newbie)
    {
      Cookie returnVisitorCookie = new Cookie("repeatVisitor", "yes");
      // 60 seconds x 60 minutes x 24 hours x 365 days = 1 year
      returnVisitorCookie.setMaxAge(60 * 60 * 24 * 365);
      response.addCookie(returnVisitorCookie);
      title = "Welcome Aboard";

    } else
    {
      title = "Welcome Back";
    }
    response.setContentType("text/html");

    out.println("<!DOCTYPE html><html><head><title>" + title + "</title></head>" + "<body><h1>" + title + "</h1>");

    Cookie[] pcookies = request.getCookies();

    if (pcookies != null)
    {
      out.println("<table border='1'>");
      for (Cookie c : pcookies)
      {
        out.println("<tr><td>");
        out.println("Cookie Name: \n" + c.getName() + "\n");
        out.println("</td><td>");
        out.println("Cookie Value: \n" + c.getValue() + "\n");
        out.println("</td><td>");
        out.println("Cookie Domain: \n" + c.getDomain() + "\n");
        out.println("</td><td>");
        out.println("Max Age: \n" + c.getMaxAge() + "\n");
        out.println("</td><td>");
        out.println("Path: \n" + c.getPath() + "\n");
        out.println("</td><td>");
        out.println("Secure: \n" + c.getSecure() + "\n");
        out.println("</td></tr>");

      }
      out.println("</table>");
    }

    out.println("</body></html>");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    // TODO Auto-generated method stub
  }

}
