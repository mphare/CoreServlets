package com.whitehare.cookies.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whitehare.cookies.utils.CookieUtilities;
import com.whitehare.cookies.utils.LongLivedCookie;

/**
 * Servlet implementation class RepeatVisitor
 */
@WebServlet("/repeat-visitor2")
public class RepeatVisitor2 extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public RepeatVisitor2()
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
    String value = CookieUtilities.getCookieValue(request, "repeatVisitor2", "no");

    if (value.equals("yes"))
    {
      newbie = false;
    }
    String title;
    if (newbie)
    {
      LongLivedCookie returnVisitorCookie = new LongLivedCookie("repeatVisitor2", "yes");
      response.addCookie(returnVisitorCookie);
      title = "Welcome Aboard 2";
    } else
    {
      title = "Welcome Back 2";
    }
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

    response.setContentType("text/html");

    out.println("<!DOCTYPE html><html><head><title>" + title + "</title></head>" + "<body><h1>" + title + "</h1>");
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
