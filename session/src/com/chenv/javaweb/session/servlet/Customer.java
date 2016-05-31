package com.chenv.javaweb.session.servlet;

public class Customer {
	private String name = null;
	private String address = null;
	private String stlye = null;
	private String card = null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStlye() {
		return stlye;
	}
	public void setStlye(String stlye) {
		this.stlye = stlye;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public Customer(String name, String address, String stlye, String card) {
		super();
		this.name = name;
		this.address = address;
		this.stlye = stlye;
		this.card = card;
	}

	
	
}
