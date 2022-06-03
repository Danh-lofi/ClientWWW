package com.danh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.danh.spring.entity.Customer;
import com.danh.spring.service.CustomerService;



@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.get();
		
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.save(theCustomer);
		
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getById(id);
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {
		customerService.delete(id);
		return "redirect:/";
	}
}
