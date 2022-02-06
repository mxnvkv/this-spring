package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

  public Customer getCustomer(int id);

  public List<Customer> getCustomers();

  public void saveCustomer(Customer customer);

}
