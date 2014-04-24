package com.whitehare.simple.forms.util;

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

  public static String filter(String input)
  {
    if (!hasSpecialCharacters(input))
    {
      return input;
    }
    StringBuilder filtered = new StringBuilder(input.length());
    char c;
    for (int i = 0; i < input.length(); i++)
    {
      c = input.charAt(i);
      switch (c)
      {
      case '<':
        filtered.append("$lt;");
        break;

      case '>':
        filtered.append("$gt;");
        break;

      case '"':
        filtered.append("$quot;");
        break;

      case '&':
        filtered.append("$amp;");
        break;

      default:
        filtered.append(c);
      }
    }
    return (filtered.toString());
  }

  private static boolean hasSpecialCharacters(String input)
  {
    // TODO Auto-generated method stub
    return true;
  }

}
