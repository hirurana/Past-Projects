package Assignments;

public class Marathon {

	public static void fastest(String[] names, int[] times) { //Parameters are calling the arrays
		int minTime = times[0]; //setting up the variables by loading the first values in the arrays
		String minName = names[0];
		
		for(int i = 0; i < times.length; i++) { //calculates the smallest number in the times to find the fastest runner
			if (times[i] < minTime){
				minTime = times[i];
				minName = names[i];
			}
		}
		System.out.println("Fastest runner is " + minName + " with a time of " + minTime + " mins"); //displays the fastest runner's name and time.
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = { //Setting up the array containing the names
			"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"
			};
		
		int[] times = { //setting up the array containing the times of the runners.
			341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265
		};
		
		fastest(names, times); //calling the method to find to fastest runner.
	}

}
