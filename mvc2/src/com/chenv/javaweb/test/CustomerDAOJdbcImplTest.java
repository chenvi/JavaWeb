package com.chenv.javaweb.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.chenv.javaweb.dao.CustomerDAO;
import com.chenv.javaweb.dao.impl.CustomerDAOJdbcImpl;
import com.chenv.javaweb.domain.CriteriaCustomer;
import com.chenv.javaweb.domain.Customer;

public class CustomerDAOJdbcImplTest {
	
	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
	
	@Test
	public void testgetForListWithCriteriaCustomer(){
		CriteriaCustomer cc = new CriteriaCustomer("a", null, null);
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		System.out.println(customers);
	}
	
	@Test
	public void testGetALL() {
		List<Customer> customers = customerDAO.getALL();
		System.out.println(customers);
	}

	@Test
	public void testSave() {
		Customer customer = new Customer(null, null, null);
		customer.setAddress("aa");
		customer.setName("cc");
		customer.setPhone("111");
		
		customerDAO.save(customer);
	}

	@Test
	public void testGetInteger() {
		Customer cust = customerDAO.get(1);
		System.out.println(cust);
	}

	@Test
	public void testDelete() {
		List<Customer> customers = customerDAO.getALL();
		customerDAO.delete(1);
		System.out.println(customers);
	}

	@Test
	public void testGetCountWithName() {
		long count = customerDAO.getCountWithName("cc");
		System.out.println(count);
	}

}
