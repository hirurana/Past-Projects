package JavaTutorial;

public class objectLevelAccess {
	int servings;
	void feed(int servings) {
		this.servings = this.servings + servings;
	}
	
	void poop() {
		System.out.println("All better!");
		servings = 0;
	}
}

//"this" refers to the object
//aka Object-level 'servings' is updated