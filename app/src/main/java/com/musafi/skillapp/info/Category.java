package com.musafi.skillapp.info;
import java.util.*; 

public class Category {
	String name;
	String id;
	List<SubCategory> subCategories;	
	
	public Category(String name, String id) {
		this.name = name;
		this.id = id;
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
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	
	public void addSubCategory(SubCategory subCategory) {
		this.subCategories.add(subCategory);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
