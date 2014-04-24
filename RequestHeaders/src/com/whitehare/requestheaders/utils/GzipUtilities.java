package com.whitehare.requestheaders.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author mphare
 * 
 */
public class GzipUtilities
{
  public static boolean isGzipSupported(HttpServletRequest request)
  {
    String encodings = request.getHeader("Accept-Encoding");
    return ((encodings != null) && (encodings.contains("gzip")));
  }

  /**
   * 
   * @param request
   * @return
   */
  public static boolean isGzipDisabled(HttpServletRequest request)
  {
    String flag = request.getParameter("disableGzip");
    return ((flag != null) && (!flag.equalsIgnoreCase("false")));
  }

  /**
   * 
   * @param response
   * @return
   * @throws IOException
   */
  public static PrintWriter getGzipWriter(HttpServletResponse response) throws IOException
  {
    return (new PrintWriter(new GZIPOutputStream(response.getOutputStream())));
  }
}
