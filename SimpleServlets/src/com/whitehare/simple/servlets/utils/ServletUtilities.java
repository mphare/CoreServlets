package com.whitehare.simple.servlets.utils;

public class ServletUtilities
{
  public static String htmlHeadWithTitle(String title)
  {
    return ("<!DOCTYPE html>\n"
        + "<html>\n"
        + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
        + "<link rel=\"stylesheet\" href=\"/SimpleServlets/Style/Master.css\"/>"
        + "<script type=\"text/javascript\" src=\"/ExternalDWP/Scripts/overlib.js\"><!-- overLIB (c) Erik Bosrup --></script>"
        + "<head><title>" + title + "</title></head>\n" + "<body>");
  }

  public static String htmlFooter()
  {
    return ("</body></html>\n");
  }

  public static String htmlPierson()
  {
    return ("<p>I Love You Pierson</p>");
  }

}
