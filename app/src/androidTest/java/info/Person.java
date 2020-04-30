package info;

public class Person {
	String id;
	String name;
	String email;
	Lesson lessons[];
	Category followCategories[];
	SubCategory followSubcategories[];
	int currentAmount;
	
	public Person(String id, String name, String email, Lesson[] lessons, Category[] followCategories,
			SubCategory[] followSubcategories, int currentAmount) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.lessons = lessons;
		this.followCategories = followCategories;
		this.followSubcategories = followSubcategories;
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

	public Lesson[] getLessons() {
		return lessons;
	}

	public void setLessons(Lesson[] lessons) {
		this.lessons = lessons;
	}

	public Category[] getFollowCategories() {
		return followCategories;
	}

	public void setFollowCategories(Category[] followCategories) {
		this.followCategories = followCategories;
	}

	public SubCategory[] getFollowSubcategories() {
		return followSubcategories;
	}

	public void setFollowSubcategories(SubCategory[] followSubcategories) {
		this.followSubcategories = followSubcategories;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}

	
}
