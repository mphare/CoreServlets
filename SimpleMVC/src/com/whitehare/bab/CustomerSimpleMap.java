package com.whitehare.bab;

import java.util.Map;

import com.whitehare.bab.model.Customer;

public class CustomerSimpleMap implements CustomerLookupService
{
  private Map<String, Customer> customers;

  public CustomerSimpleMap()
  {

  }

  public Customer findCustomer(String id)
  {
    if (id != null)
    {
      return (customers.get(id.toLowerCase()));
    } else
    {
      return (null);
    }
  }

}
