package com.chenv.javaweb.dao.factory;

import java.util.HashMap;
import java.util.Map;

import com.chenv.javaweb.dao.CustomerDAO;
import com.chenv.javaweb.dao.impl.CustomerDAOJdbcImpl;
import com.chenv.javaweb.dao.impl.CustomerDAOXMLImpl;




public class CustomerDAOFactory {

	private Map<String,CustomerDAO> daos = new HashMap<String,CustomerDAO>();
	
	private CustomerDAOFactory(){
		daos.put("jabc",new CustomerDAOJdbcImpl());
		daos.put("xml",new CustomerDAOXMLImpl());
	}
	
	private static CustomerDAOFactory instance = new CustomerDAOFactory();
	
	public static CustomerDAOFactory getInstace(){
		return instance;
	}
	
	private  String type = null;
	
	public  void setType(String type) {
		this.type = type;
	}

	public CustomerDAO getCustomerDAO(){
		return daos.get(type);
		
	}
}
