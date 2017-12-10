package oop;

public class Baby {
	//Fields
	//Blueprints for a baby
	String name;
	boolean isMale;
	double weight = 5.0;
	double decibels;
	int numPoops = 0;
	Baby[] Siblings;

	//Methods
	void poop() {
		numPoops += 1; 
		System.out.println("Dear mother, " + "I have pooped. Ready the diaper.");
	}
	
	//Constructor to create a baby
	Baby(String myname, boolean maleBaby){
		name = myname;
		isMale = maleBaby;
	}
	
	void sayHi(){ //method to make baby say hello
		System.out.println("Hi, my name is " + name);
	}
	
	void eat(double foodWeight){ //method to make the baby eat
		if (foodWeight >= 0 && foodWeight < weight) {
			weight = weight + foodWeight;
		}
	}
	
	static void doSomething(int x, int[] ys, Baby b){
		x = 99;
		ys[0] = 99;
		b.name = "99";
	}
	
	void cry(){ //method to make the baby cry
		System.out.println(name + " cries");
	}
	
	public static void main(String[] args){ //main method where program is run
		
		Baby shiloh = new Baby("Shiloh Jolie-Pitt", true); //creating a baby using constructor
		System.out.println(shiloh.name); //output name
		System.out.println(shiloh.numPoops); //output number of poops
		shiloh.sayHi(); //Make baby Shiloh say hi
		shiloh.eat(1); //Make baby Shiloh eat
		shiloh.poop(); //Make baby Shiloh poop
		shiloh.cry(); //Make baby Shiloh cry
		
		int i = 0;
		int[] j = {0};
		Baby k = new Baby("50", true);
		doSomething(i, j ,k);
	}
}
