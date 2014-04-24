package com.whitehare.requestheaders.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaders
 */
@WebServlet("/show-request-headers")
public class RequestHeaders extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public RequestHeaders()
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
    String title = "Simple Request Headers";
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTPYE html>" + "<html><head><title>" + title + "</title>" + "<body><h1>" + title + "</h1>"
        + "<b>Request Method: </b>" + request.getMethod() + "<br/>" + "<b>Request URI: </b>" + request.getRequestURI()
        + "<br/>" + "<b>Request URL: </b>" + request.getRequestURI() + "<br/>" + "<b>Request Protocol: </b>"
        + request.getProtocol() + "<br/><br/>"
        + "<table border = '1'><tr><th>Header Names</th><th>Header Values</th></tr>");
    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements())
    {
      String headerName = headerNames.nextElement();
      out.println("<tr><td>" + headerName + "</td><td>" + request.getHeader(headerName));
    }
    out.println("</tr></td></table></body></html>");

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doGet(request, response);
  }

}
