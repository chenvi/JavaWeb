package com.chenv.javaweb.dao;

import java.util.List;

import com.chenv.javaweb.domain.CriteriaCustomer;
import com.chenv.javaweb.domain.Customer;

public interface CustomerDAO {
	
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	
	public List<Customer> getALL();
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void update(Customer customer);
	public void delete(Integer id);
	
	public long getCountWithName(String name);
	
	
	
}
