package com.danh.spring.service;

import java.util.List;

import com.danh.spring.entity.Customer;



public interface CustomerService {
	public List<Customer> get();
	public void save(Customer cus);
	public Customer getById(int id);
	public void delete(int id);
}
