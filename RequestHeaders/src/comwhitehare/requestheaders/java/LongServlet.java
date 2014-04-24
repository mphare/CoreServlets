package comwhitehare.requestheaders.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.whitehare.requestheaders.utils.GzipUtilities;

/**
 * Servlet implementation class LongServlet
 */
@WebServlet("/long-servlet")
public class LongServlet extends HttpServlet
{

  private static final long serialVersionUID = 1L;
  private static Logger     log              = Logger.getLogger("Demo1");

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LongServlet()
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
    log.trace("Doing GET");
    // TODO Auto-generated method stub
    response.setContentType("text/html");
    PrintWriter out;
    if (GzipUtilities.isGzipSupported(request) && GzipUtilities.isGzipDisabled(request))
    {
      log.debug("GZip Header");
      out = GzipUtilities.getGzipWriter(response);
      response.setHeader("Content-Encoding", "gzip");

    } else
    {
      log.debug("Non-GZip Header");
      out = response.getWriter();
    }
    String title = "Long Response";
    out.println("<!DOCTYPE html>" + "<html><head><title>" + title + "</title></head>");
    String line = "Blah, Blah, Blah.. Yadda, Yadda, Yadda..";
    for (int i = 0; i < 1000; i++)
    {
      out.println(line + "<br/>");
    }
    out.println("</body></html>");
    out.close();
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
