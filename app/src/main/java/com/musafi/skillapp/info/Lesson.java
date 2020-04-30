package com.musafi.skillapp.info;
import java.time.LocalDateTime;
import java.util.*; 

public class Lesson {
	String name;
	Category category;
	SubCategory subcategory;
	LocalDateTime start_time;
	int duration; // in minutes
	Person lecturer;
	List<Person> students;
	int maxStudents;
	
	public Lesson(String name, Category category, SubCategory subcategory, LocalDateTime start_time, int duration,
			Person lecturer, List<Person> students, int maxStudents) {
		super();
		this.name = name;
		this.category = category;
		this.subcategory = subcategory;
		this.start_time = start_time;
		this.duration = duration;
		this.lecturer = lecturer;
		this.students = students;
		this.maxStudents = maxStudents;
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
	public SubCategory getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}
	public LocalDateTime getStart_time() {
		return start_time;
	}
	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Person getLecturer() {
		return lecturer;
	}
	public void setLecturer(Person lecturer) {
		this.lecturer = lecturer;
	}

	public List<Person> getStudents() {
		return students;
	}

	public void setStudents(List<Person> students) {
		this.students = students;
	}

	public int getMaxStudents() {
		return maxStudents;
	}
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}
	
	public void addStudent(Person student) {
		this.students.add(student);
	}
	
	
}
