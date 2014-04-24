package com.whitehare.cookies.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtilities
{
  public static String getCookieValue(HttpServletRequest request, String cookieName, String defaultValue)
  {
    Cookie[] cookies = request.getCookies();
    if (cookies != null)
    {
      for (Cookie cookie : cookies)
      {
        if (cookieName.equals(cookie.getName()))
        {
          return (cookie.getValue());
        }
      }
    }
    return (defaultValue);
  }

  public static void setCookieValue(HttpServletRequest request, String cookieName, String cookieValue)
  {
    Cookie cookie = findCookieByName(request, cookieName);
    cookie.setValue(cookieValue);
  }

  private static Cookie findCookieByName(HttpServletRequest request, String cookieName)
  {
    Cookie[] cookies = request.getCookies();
    if (cookies != null)
    {
      for (Cookie c : cookies)
      {
        if ((c.getName().equals(cookieName)))
        {
          return c;
        }

      }

    }

    return null;
  }
}
