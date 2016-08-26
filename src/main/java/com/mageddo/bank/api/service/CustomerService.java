package com.mageddo.bank.api.service;

import java.util.List;

import com.mageddo.bank.api.dao.CustomerDAO;
import com.mageddo.bank.api.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by elvis on 13/08/16.
 */
@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public List<CustomerEntity> findByName(String name){
		return this.customerDAO.findByName(name);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void createCustomer(CustomerEntity customer) {
		customerDAO.create(customer);
	}

}
