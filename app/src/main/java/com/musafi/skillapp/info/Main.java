package com.musafi.skillapp.info;
import java.time.LocalDateTime;
import java.util.*; 

enum LessonStatus {
	FUTURE,
	NOW,
	ENDED,
	CANCELED
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start..");
		
		Category category1 = new Category("Board Games", "asd");
		SubCategory subcategory1 = new SubCategory("Chess", "123a", category1);
		Person person1 = new Person("1", "Jacob", "jacob@gmail.com", 5);
		int randomNum = 0 + (int)(Math.random() * 50);
		LocalDateTime currentTime = LocalDateTime.now().plusMinutes(randomNum);
		Lesson lesson1 = new Lesson("My Chess lesson", category1, subcategory1, currentTime, 30, person1, 1);
		randomNum = 0 + (int)(Math.random() * 50);
		currentTime = LocalDateTime.now().plusMinutes(randomNum);
		Lesson lesson2 = new Lesson("My Poop lesson", category1, subcategory1, currentTime, 30, person1, 1);
//		System.out.println(lesson1.checkLessonStatus());
//		System.out.println(lesson1);
//		lesson1 = new Lesson("Eli's lesson", category, subcategory, start_time, duration, lecturer, students, maxStudents)
		
		
		List<Lesson> l1 = new ArrayList<Lesson>();
		l1.add(lesson1);
		l1.add(lesson2);
		for (int i = 0; i < l1.size(); i++) {
			System.out.println(l1.get(i));
		}
		l1 = sortByLessonTime(l1);
//		Collections.sort(l1, new SortByTime());
		for (int i = 0; i < l1.size(); i++) {
			System.out.println(l1.get(i));
		}
	}
	
	public static List<Lesson> sortByLessonTime(List<Lesson> lessons) {
		List<Lesson> sortedLessons = new ArrayList<Lesson>();
		for (int i = 0; i < lessons.size(); i++) {
			if (lessons.get(i).getStart_time().isAfter(LocalDateTime.now())) {
				sortedLessons.add(lessons.get(i));
			}
		}
		Collections.sort(sortedLessons, new SortByTime());
		return sortedLessons;
	}

}
