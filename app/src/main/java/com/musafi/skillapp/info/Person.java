package com.musafi.skillapp.info;
import java.util.*;

public class Person {
	String id;
	String name;
	String email;
	List<Lesson> lessons;
	List<Category> followCategories;
	List<SubCategory> followSubcategories;
	int currentAmount;
	
	public Person(String id, String name, String email, int currentAmount) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.currentAmount = currentAmount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}

	public void addLesson(Lesson lesson) {
		this.lessons.add(lesson);
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	
	public void addCategory(Category category) {
		this.followCategories.add(category);
	}
	
	public void addSubCategory(SubCategory subcategory) {
		this.followSubcategories.add(subcategory);
	}

	public List<Category> getFollowCategories() {
		return followCategories;
	}

	public void setFollowCategories(List<Category> followCategories) {
		this.followCategories = followCategories;
	}

	public List<SubCategory> getFollowSubcategories() {
		return followSubcategories;
	}

	public void setFollowSubcategories(List<SubCategory> followSubcategories) {
		this.followSubcategories = followSubcategories;
	}
}
