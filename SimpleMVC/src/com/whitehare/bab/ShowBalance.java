package com.whitehare.bab;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowBalance
 */
@WebServlet("/ShowBalance")
public class ShowBalance extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ShowBalance()
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
    String customerId = request.getParameter("customerId");
    CustomerLookupService service = new CustomerSimpleMap();
    Customer customer = service.findCustomer(customerId);
    request.setAttribute("customer", customer);
    String address;
    if (customer == null)
    {
      request.setAttribute("badId", customerId);
      address = "/WEB-INF/results/unknown-customer.jsp";
    } else if (customer.getBalance() < 0)
    {
      address = "/WEB-INF/results/negative-balance.jsp";
    } else
    {
      address = "/WEB-INF/results/normal-customer.jsp";
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
    dispatcher.forward(request, response);

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
