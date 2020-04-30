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
		System.out.println("Start..");
		/* Print Categories */
//		List<Category> categories = getAllCategories();
//		for (int i = 0; i < categories.size(); i++) {
//			System.out.println("Category: " + categories.get(i));
//			for (int j = 0; j < categories.get(i).getSubCategories().size(); j++) {
//				System.out.println("Sub Category: " + categories.get(i).getSubCategories().get(j));
//			}
//		}
		
		
//		for (int i = 0; i < subca.length; i++) {
//			
//		}
//		System.out.println(subCategoriesNames);
		Person jacob = new Person("Jacob", "jacob123@gmail.com", 5);
//		Category category1 = new Category("Board Games");
//		SubCategory subcategory1 = new SubCategory("Chess", category1);
//		category1.addSubCategory(subcategory1);
//		
		List<Category> categories = getAllCategories();
		List<Lesson> lessons = new ArrayList<Lesson>();
		int numOfLessons = 5;
		for (int i = 0; i < numOfLessons; i++) {
			Random rand = new Random();
			
			int randomMinutes = 0 + (int)(Math.random() * 50);
			int randomHours = 0 + (int)(Math.random() * 10);
			int randomDays = 0 + (int)(Math.random() * 2);
			LocalDateTime currentTime = LocalDateTime.now().plusMinutes(randomMinutes);
			currentTime = LocalDateTime.now().plusHours(randomHours);
			currentTime = LocalDateTime.now().plusDays(randomDays);
			
			int randomDuration = (2 + (int)(Math.random() * 8))*10;
			Category randomCategory = categories.get(rand.nextInt(categories.size()));
			SubCategory randomSubCategory = randomCategory.getSubCategories().get(rand.nextInt(randomCategory.getSubCategories().size()));
			String lessonName = randomCategory.getName() + " ->" + randomSubCategory.getName();
			
			int randomMaxStudents = 1 + (int)(Math.random() * 3);
			lessons.add(new Lesson(lessonName, randomCategory, randomSubCategory, currentTime, randomDuration, jacob, randomMaxStudents));
		}
		
		for (int i = 0; i < lessons.size(); i++) {
			System.out.println(lessons.get(i));
		}
//		int randomNum = 0 + (int)(Math.random() * 50);
//		LocalDateTime currentTime = LocalDateTime.now().plusMinutes(randomNum);
//		Lesson lesson1 = new Lesson("My Chess lesson", category1, subcategory1, currentTime, 30, person1, 1);
//		randomNum = 0 + (int)(Math.random() * 50);
//		currentTime = LocalDateTime.now().plusMinutes(randomNum);
//		Lesson lesson2 = new Lesson("My Poop lesson", category1, subcategory1, currentTime, 30, person1, 1);
////		System.out.println(lesson1.checkLessonStatus());
////		System.out.println(lesson1);
////		lesson1 = new Lesson("Eli's lesson", category, subcategory, start_time, duration, lecturer, students, maxStudents)
//		
//		
//		List<Lesson> l1 = new ArrayList<Lesson>();
//		l1.add(lesson1);
//		l1.add(lesson2);
//		for (int i = 0; i < l1.size(); i++) {
//			System.out.println(l1.get(i));
//		}
//		l1 = sortByLessonTime(l1);
////		Collections.sort(l1, new SortByTime());
//		for (int i = 0; i < l1.size(); i++) {
//			System.out.println(l1.get(i));
//		}
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
	
	public static List<Category> getAllCategories() {
		String categoriesNames[] = {"Music", "Software","DIY","Academy","Career","Lifestyle"};
		String subCategoriesNames[][] = {{"Guitar","Piano","Drums","Editing","Violin", "Darbuka"},
				{"Programming Language","UX / UI","Graphic Design","Web","MS Office","E-Commerce Development"},
				{"Knitting","Cooking","Drawing","Magic","Woodworking","Electronics"},
				{"Productivity","photography","Sports & Fitness","Foreign Languages","Writing & Blogging","Games & Puzzles"},
				{"Entrepreneurship","Leadership & Management","Marketing","Product Management","Advertising","Job Search Help"},
				{"Math","Engineering","Life Sciences","Law","History","SAT"}};
		List<Category> categories = new ArrayList<Category>();
		for (int i = 0; i < categoriesNames.length; i++) {
			Category category = new Category(categoriesNames[i]);
			for (int j = 0; j < subCategoriesNames[i].length; j++) {
				category.addSubCategory(new SubCategory(subCategoriesNames[i][j], category));
			}
			categories.add(category);
			categories.get(i).mixSubCategories();
		}
		Collections.shuffle(categories);
		return categories;
	}

}
