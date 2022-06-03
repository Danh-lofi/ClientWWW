package com.danh.spring.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.danh.spring.entity.Customer;



@Service
public class CustomerServiceImpl implements CustomerService{
	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public CustomerServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String url) {
		restTemplate = theRestTemplate;
		crmRestUrl = url;
		logger.info("Load property: crm.rest.url" + crmRestUrl);
	}
	
	@Override
	public List<Customer> get() {
		
		logger.info("in getCustomers(): Calling REST API" + crmRestUrl);
		
		ResponseEntity<List<Customer>> responseEntity = 
				restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Customer>>() {}); 
		
		//get the list of customers from response
		List<Customer> customers = responseEntity.getBody();
		logger.info("in getCustomers(): customers" + customers);
		
		return customers;
	}

	@Override
	public void save(Customer cus) {
		logger.info("in saveCustomer(): Calling REST API " + crmRestUrl);
		
		int id = cus.getId();
		
		//make REST call
		if(id == 0) {
			//add customer
			restTemplate.postForEntity(crmRestUrl, cus, String.class);
		}else {
			//update customer
			restTemplate.put(crmRestUrl, cus);
		}
		
		logger.info("in saveCustomer(): success");
	}

	@Override
	public Customer getById(int id) {
		logger.info("in getCustomerById(): Calling REST API " + crmRestUrl);
		
		//make REST call
		Customer theCustomer = restTemplate.getForObject(crmRestUrl + "/" + id, Customer.class);
		
		return theCustomer;
	}

	@Override
	public void delete(int id) {
		logger.info("in deleteCustomer(): Calling REST API " + crmRestUrl);
		
		//make REST call
		restTemplate.delete(crmRestUrl + "/" + id);
		
		logger.info("in deteteCustomer(): deteted customer id = " + id);
		
	}

}
