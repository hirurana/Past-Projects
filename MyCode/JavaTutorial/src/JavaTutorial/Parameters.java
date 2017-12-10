package JavaTutorial;

public class Parameters {
	public static void printSquare(int x) {
		System.out.println(x*x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = 2;
		printSquare(value);
		printSquare(3);
		printSquare(value*2);
		printSquare((int)5.5); /*this is a double number that has been 
								converted into an integer for use in the method*/ 
	}

}

