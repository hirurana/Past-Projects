package JavaTutorial;

public class gettingMaxValInArray {
	
	public static void main(String[] args) {
		//Creating the array
		int[] numbers = {
				1, 6, 4, 3, 5, 9
		};
		
		int maxValue = numbers[0];
		
		//for loop to work through the values in the array
		for (int counter = 1; counter < numbers.length; counter++){
		//int counter = 1 is the initialization of the variable counter
		//counter < numbers.length is telling the program to work through the array as many times as the array is in length
		//counter++ tells the program to add 1 to the counter every time it goes around in a loop
			
			if(numbers[counter] > maxValue){ //if the current value loaded from the array is greater than the currently found maximum value then...
				maxValue = numbers[counter]; //replace the maximum value currently stored because the program has found a bigger value
			}
		}
		System.out.println(maxValue); //print the largest value in the array
	}

}

/** The programs logic
 * the program first loads the first value in the array, which is 1, and stores it by default as the max value
 * then the program compares 1 with the next value in the array to see if it is greater
 * if so, then the program will replace the max value (which is currently 1) with the new maximum value
 * then it moves on throughout the array repeating this processes
 * 6 > 1? yes make 6 the new max value
 * 4 > 6? no keep 6 as max value
 * 3 > 6? no
 * 5 > 6? no
 * 9 > 6? yes make 9 the new max value
 */

//for minimum value just change "if(numbers[counter] > maxValue){" to if(numbers[counter] < minValue){ 
