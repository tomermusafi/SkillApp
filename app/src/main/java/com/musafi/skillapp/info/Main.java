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
//		/* Print Categories */
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

//		Person jacob = new Person("Jacob", "jacob123@gmail.com", 5);
		Category category1 = new Category("Board Games");
		SubCategory subcategory1 = new SubCategory("Chess", category1);
//		category1.addSubCategory(subcategory1);
//		
		List<Lesson> lessons = getAllLessons(30, subcategory1);
		
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
	
	public static List<Person> getAllUsers() {
		List<Person> users = new ArrayList<Person>();
		String names[] = {"Jacob", "Tomer", "Eli","Casie","Eddy","Tracey","Sharan","Noella","Amelia","Judie","Emile",
				"Jeffrey","Monroe","Nelson","Jenna","Rebekah","Suzie","Hosea","Candis","Billy","Rosalba","Eldon","Demetria", 
				"Oswaldo","Marline","Adrian","Lynnette","Shaunta","Tinisha","Miles","Lyndon","Monte","Joel","Everett",
				"Jermaine","Irwin","Arturo","Dillon","Valentina","Glennis","Faviola","Patsy","Pinkie"};
		String urls[] = {"https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
				,"https://images.pexels.com/photos/3914102/pexels-photo-3914102.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" 
				,"https://images.pexels.com/photos/733872/pexels-photo-733872.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
				,"https://images.pexels.com/photos/1181686/pexels-photo-1181686.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
				,"https://images.pexels.com/photos/1222271/pexels-photo-1222271.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
				,"https://2xkcvt35vyxycuy7x23e0em1a5g-wpengine.netdna-ssl.com/wp-content/uploads/2019/08/Dwayne-Johnson-photo-Eva-Rinaldi-wikipedia-293x300.jpg"
				,"https://static.politico.com/dims4/default/e8a2d49/2147483647/resize/1160x/quality/90/?url=https%3A%2F%2Fstatic.politico.com%2Fe6%2Ffc%2F4c2b102e4c92be07930d4981df12%2F200408-trump-2-ap-773.jpg" 
				,"https://mfa.gov.il/MFA/AboutIsrael/State/Personalities/Photos/gpo-ao-netanyahu-head.jpg"
				,"https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80"
				,"https://images.unsplash.com/photo-1528892952291-009c663ce843?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=296&q=80"
				,"https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
				,"https://www.celebrityspeakersbureau.com/wp-content/uploads/2013/06/lionel-messi.jpg"
				,"http://www.fubiz.net/wp-content/uploads/2015/01/Famous-People-Portraits-5.jpg"
				,"https://images.pexels.com/photos/1036623/pexels-photo-1036623.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"};
		for (int i = 0; i < names.length; i++) {
			String randomName = names[(int)(Math.random() * names.length)];
			int randomCoinsAmount = 1 + (int)(Math.random() * 18);
			double randomRating = 3.9 + (double)(Math.random() * 1.1);
			randomRating = Double.valueOf((String.format("%.1f", randomRating)));
			String randomUrl = urls[(int)(Math.random() * urls.length)];
			users.add(new Person(randomName, "e@e.com", randomCoinsAmount, randomRating, randomUrl));
		}
		return users;
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
	
	public static List<Lesson> getAllLessons(int numOfLessons, SubCategory subCategory) {
		List<Person> users = getAllUsers();
//		List<Category> categories = getAllCategories();
		List<Lesson> lessons = new ArrayList<Lesson>();
		for (int i = 0; i < numOfLessons; i++) {
			int randomMinutes = 0 + (int)(Math.random() * 50);
			int randomHours = 0 + (int)(Math.random() * 10);
			int randomDays = 0 + (int)(Math.random() * 3);
			LocalDateTime currentTime = LocalDateTime.now().plusMinutes(randomMinutes);
			currentTime = currentTime.plusHours(randomHours);
			currentTime = currentTime.plusDays(randomDays);
			int randomDuration = (2 + (int)(Math.random() * 8))*10;
//			Category randomCategory = categories.get(rand.nextInt(categories.size()));
//			SubCategory randomSubCategory = randomCategory.getSubCategories().get(rand.nextInt(randomCategory.getSubCategories().size()));
			
			Person randomPerson = users.get((int)(Math.random() * users.size()));
			String lessonName = randomPerson.getName() + "'s " + subCategory.getName() + " Lesson";
			int randomMaxStudents = 1 + (int)(Math.random() * 3);
			int randomOfStudentsRolled = (int)(Math.random() * randomMaxStudents);
			String randomBio = "My name is " + randomPerson.getName() + " and I'm from California. My first passion is " + subCategory.getName() + ", my second passion is teaching! "
					+ "Feel welcome to join my lesson and together we will make the world a better place :)";
			String link = "https://zoom.us/j/330807397?pwd=REdzbTVoYzJXQTdkZnRDYUFBWjYwdz09";
			lessons.add(new Lesson(lessonName, subCategory.getCategory(), subCategory, currentTime, randomDuration, randomPerson, randomMaxStudents, randomOfStudentsRolled, randomBio, link));
		}
		lessons = sortByLessonTime(lessons);
		return lessons;
	}
	
	public static List<Coupon> getAllCoupons() {
		List<Coupon> coupons = new ArrayList<Coupon>();
		
		coupons.add(new Coupon("25% off on Adidas Clothing", "CafeCafe", 20, "https://assets.adidas.com/images/w_385,h_385,f_auto,q_auto:sensitive,fl_lossy/39a7f46af8524e0fa095a95901199987_9366/tiro-19-training-pants.jpg"));
		coupons.add(new Coupon("10% off on Pizza", "Dominos", 7, "https://besttv232-ynet-images1-prod.cdn.it.best-tv.com/PicServer5/2019/11/23/9613160/big.jpg"));
		coupons.add(new Coupon("7% off on Dell Laptop", "Dell", 20, "https://www.morlevi.co.il/cache/w_600,h_500,mode_pad/notebook-vostro-15-3580-3581-apj-emea-pdp-1(1).jpg"));
		coupons.add(new Coupon("15% off on Ink", "Office Depot", 5, "https://www.mymzone.com/wp-content/uploads/2019/09/Digital-Slider-300x200.jpg"));
		coupons.add(new Coupon("20% off on Washing Machine", "Michele", 50, "https://miro.medium.com/max/1400/1*LidfgXsTgTYjzb6AY9cMFw.jpeg"));
		coupons.add(new Coupon("17% off on any Udemy Course", "Udemy", 10, "https://230027-986802-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads/2020/04/Are-Udemy-courses-worth-putting-on-resume.png"));
		coupons.add(new Coupon("80% off on Breakfast for Couple", "CafeCafe", 20, "https://pbs.twimg.com/media/DwNhJzEX0AENUn5?format=jpg&name=small"));
		
		return coupons;
	}

}
