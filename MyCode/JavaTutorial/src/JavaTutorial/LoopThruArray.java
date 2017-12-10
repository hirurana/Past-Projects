package JavaTutorial;

public class LoopThruArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] values = new int[5]; //create the array
		
		for (int i=0; i<values.length; i++) { //loop whilst counter is less than values length
			values[i] = i;
			int y = values[i] * values[i]; 
			System.out.println(y);
		}
	}

}
