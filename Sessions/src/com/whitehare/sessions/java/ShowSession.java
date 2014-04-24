package com.whitehare.sessions.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.whitehare.sessions.utils.ServletUtilities;

/**
 * Servlet implementation class ShowSession
 */
@WebServlet("/show-session")
public class ShowSession extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ShowSession()
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
    HttpSession session = request.getSession();

    synchronized (session)
    {
      String heading;
      Integer accessCount = (Integer) session.getAttribute("accessCount");
      if (accessCount == null)
      {
        accessCount = 0;
        heading = "Welcome Newcomer Session";
      } else
      {
        heading = "Welcome Back Session";
        accessCount = accessCount + 1;

      }
      session.setAttribute("accessCount", accessCount);

      PrintWriter out = response.getWriter();

      out.println(ServletUtilities.htmlHeadWithTitle(heading));
      out.println("<h1>" + heading + "</h1>");
      out.println("<h2>Session Information</h2>");
      out.println("<p>Accesses: " + accessCount);

      out.println(ServletUtilities.htmlFooter());

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

}
