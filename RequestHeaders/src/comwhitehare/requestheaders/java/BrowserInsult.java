package comwhitehare.requestheaders.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class BrowserInsult
 */
@WebServlet("/browser-insult")
public class BrowserInsult extends HttpServlet
{
  private static Logger     log              = Logger.getLogger("Demo1");
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public BrowserInsult()
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
    String title, message;

    String userAgent = request.getHeader("User-Agent");
    if ((userAgent != null) && (userAgent.contains("MSIE")))
    {
      title = "Microsoft Minion";
      message = "Welcome, spineless slave to the Mighty Empire";
      log.trace(title + " : " + message);

    } else
    {
      title = "Firefox Rebal";
      message = "Enjoy it while you can. You will be assimilated";
      log.trace(title + " : " + message);
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
