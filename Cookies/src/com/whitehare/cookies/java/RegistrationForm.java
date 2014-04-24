package com.whitehare.cookies.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whitehare.cookies.utils.CookieUtilities;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String title = "Form";
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String firstName = CookieUtilities.getCookieValue(request, "firstName", "");
    String lastName = CookieUtilities.getCookieValue(request, "lastName", "");
    String emailAddress = CookieUtilities.getCookieValue(request, "emailAddress", "");

    out.println("<!DOCTYPE html><html><head><title>" + title + "</title></head>");
    out.println("<body><h1>" + title + "</h1>");
    out.println("<form action=\"registration\">" + "First Name: <input type='text' name='firstName' value='"
        + firstName + "''><br/>" + "Last Name: <input type='text' name='lastName' value='" + lastName + "''><br/>"
        + "Email Address: <input type='text' name='emailAddress' value='" + emailAddress + "''><br/>");
    out.println("<input type='submit' value='Register'/></form>");
    out.println("</body></html>");
  }
}
