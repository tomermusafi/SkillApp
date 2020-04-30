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
	int numOfStudentsRolled;
	String bio;
	
	public Lesson(String name, Category category, SubCategory subcategory, LocalDateTime start_time, int duration,
			Person lecturer, int maxStudents, int numOfStudentsRolled, String bio) {
		this.name = name;
		this.category = category;
		this.subcategory = subcategory;
		this.start_time = start_time;
		this.duration = duration;
		this.lecturer = lecturer;
		this.maxStudents = maxStudents;
		this.students = new ArrayList<Person>();
		this.numOfStudentsRolled = numOfStudentsRolled;
		this.bio = bio;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getNumOfStudentsRolled() {
		return numOfStudentsRolled;
	}

	public void setNumOfStudentsRolled(int numOfStudentsRolled) {
		this.numOfStudentsRolled = numOfStudentsRolled;
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

	public String getStartTimeDate() {
		return start_time.getDayOfMonth()+"/"+start_time.getMonthValue()+"/20";
	}
	
	public String getStartTimeHourMinute() {
		String hour = Integer.toString(start_time.getHour());
		if (Integer.parseInt(hour) < 10) {
			hour = "0" + hour;
		}
		
		int minutee = 5*(Math.round(start_time.getMinute()/5));
		String minute = Integer.toString(minutee);
		if (Integer.parseInt(minute) < 10) {
			minute = "0" + minute;
		}
		return hour+":"+minute;
	}
	
	@Override
	public String toString() {
		return "Lesson [name=" + name + ", category=" + category + ", subcategory=" + subcategory + ", start_time="
				+ getStartTimeDate() + " " + getStartTimeHourMinute() + ", duration=" + duration + ", lecturer=" + lecturer + ", Students=" + numOfStudentsRolled + "/" + maxStudents
				+ ", maxStudents=" + maxStudents + "]" + "Rating: " + this.lecturer.getRating() + "Bio: " + bio;
	}
	
	public LessonStatus checkLessonStatus() {
		start_time = start_time.minusMinutes(29);
		System.out.println(start_time);
		if (LocalDateTime.now().isAfter(start_time) && LocalDateTime.now().isBefore(start_time.plusMinutes(30))) {
			return LessonStatus.NOW;
		} else if (LocalDateTime.now().isAfter(start_time.plusMinutes(30))) {
			return LessonStatus.ENDED;
		}
		return LessonStatus.FUTURE;
	}
	
}

class SortByTime implements Comparator<Lesson> {

	@Override
	public int compare(Lesson lesson1, Lesson lesson2) {
		return lesson1.start_time.compareTo(lesson2.start_time);
	}
	
}
