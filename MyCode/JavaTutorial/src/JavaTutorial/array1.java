package JavaTutorial;

public class array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = new int[5];
		values[0] = 12; // CORRECT
		values[4] = 12; // CORRECT
		values[5] = 12; // WRONG!! compiles but
		// throws an Exception // at run-time
	}

}
