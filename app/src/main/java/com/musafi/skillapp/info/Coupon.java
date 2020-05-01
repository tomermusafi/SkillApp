package com.musafi.skillapp.info;

public class Coupon {
	String name;
	String company;
	int price;
	String url;
	
	public Coupon(String name, String company, int price, String url) {
		this.name = name;
		this.company = company;
		this.price = price;
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
