package com.whitehare.cookies.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whitehare.cookies.utils.LongLivedCookie;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public RegistrationServlet()
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
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    boolean isMissingValue = false;

    String firstName = request.getParameter("firstName");
    if (isMissing(firstName))
    {
      firstName = "Missing First Name";
      isMissingValue = true;
    }

    String lastName = request.getParameter("lastName");
    if (isMissing(lastName))
    {
      lastName = "Missing Last Name";
      isMissingValue = true;
    }

    String emailAddress = request.getParameter("emailAddress");
    if (isMissing(emailAddress))
    {
      emailAddress = "Missing Email Address";
      isMissingValue = true;
    }

    Cookie c1 = new LongLivedCookie("firstName", firstName);
    response.addCookie(c1);

    Cookie c2 = new LongLivedCookie("lastName", lastName);
    response.addCookie(c2);

    Cookie c3 = new LongLivedCookie("emailAddress", emailAddress);
    response.addCookie(c3);

    if (isMissingValue)
    {
      response.sendRedirect("registration-form");

    } else
    {
      String title = "Your Values";
      out.println("<!DOCTYPE html><html><head><title>" + title + "</title></head><body>");
      out.println("<ul>");
      out.println("<li>" + firstName + "</li>");
      out.println("<li>" + lastName + "</li>");
      out.println("<li>" + emailAddress + "</li>");
      out.println("</ul>");
      out.println("<form action='registration-form'>");
      out.println("<input type='submit'/>");
      out.println("</form>");
      out.println("</body></html>");
    }

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    // TODO Auto-generated method stub
  }

  private boolean isMissing(String value)
  {
    return (value.equals(""));
  }

}
