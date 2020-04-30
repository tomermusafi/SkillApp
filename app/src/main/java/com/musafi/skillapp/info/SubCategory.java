package com.musafi.skillapp.info;

public class SubCategory {
	String name;
	String id;
	Category category;
	
	public SubCategory(String name, String id, Category category) {
		this.name = name;
		this.id = id;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
