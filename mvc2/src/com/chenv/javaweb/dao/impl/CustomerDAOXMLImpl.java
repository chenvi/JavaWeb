package com.chenv.javaweb.dao.impl;

import java.util.List;

import com.chenv.javaweb.dao.CustomerDAO;
import com.chenv.javaweb.domain.CriteriaCustomer;
import com.chenv.javaweb.domain.Customer;

public class CustomerDAOXMLImpl implements CustomerDAO {

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("save");

	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Customer customer) {
		System.out.println("update");

	}

	@Override
	public void delete(Integer id) {
		System.out.println("delete");

	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
