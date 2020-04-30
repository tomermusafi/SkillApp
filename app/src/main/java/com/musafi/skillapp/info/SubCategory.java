package com.musafi.skillapp.info;

public class SubCategory {
	String name;
	Category category;
	
	public SubCategory(String name, Category category) {
		this.name = name;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
