package com.musafi.skillapp.info;
import java.util.*; 

public class Category {
	String name;
	List<SubCategory> subCategories;
	
	public Category(String name) {
		this.name = name;
		this.subCategories = new ArrayList<SubCategory>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	
	public void addSubCategory(SubCategory subCategory) {
		this.subCategories.add(subCategory);
	}
	
	public void mixSubCategories() {
		Collections.shuffle(this.subCategories);
	}
	@Override
	public String toString() {
		return name;
	}
}
