package com.musafi.skillapp.info;
import java.time.LocalDateTime;
import java.util.*; 

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start..");
		
		Category category1 = new Category("Board Games", "asd");
		SubCategory subcategory1 = new SubCategory("Chess", "123a", category1);
		Person person1 = new Person("1", "Jacob", "jacob@gmail.com", 5);
		LocalDateTime currentTime = LocalDateTime.now();
		Lesson lesson1 = new Lesson("My chess lesson", category1, subcategory1, currentTime, 30, person1, 1);
		
		System.out.println(lesson1);
//		lesson1 = new Lesson("Eli's lesson", category, subcategory, start_time, duration, lecturer, students, maxStudents)
	}

}
