package com.whitehare.cookies.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whitehare.cookies.utils.CookieUtilities;
import com.whitehare.cookies.utils.LongLivedCookie;

/**
 * Servlet implementation class RepeatVisitor
 */
@WebServlet("/repeat-visitor-counter")
public class RepeatVisitorCounts extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public RepeatVisitorCounts()
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

    String countString = CookieUtilities.getCookieValue(request, "accessCount", "1");

    int count = 1;
    try
    {
      count = Integer.parseInt(countString);
    } catch (NumberFormatException e)
    {

    }
    LongLivedCookie c = new LongLivedCookie("accessCount", String.valueOf(count + 1));
    response.addCookie(c);
    PrintWriter out = response.getWriter();

    String title = "Access Counter";

    response.setContentType("text/html");

    out.println("<!DOCTYPE html><html><head><title>" + title + "</title></head>" + "<body><h1>" + title + "</h1>");
    out.println("<h2>" + count + "</h2>");
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
