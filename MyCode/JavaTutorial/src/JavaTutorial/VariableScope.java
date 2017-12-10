package JavaTutorial;

public class VariableScope {
	
	public static void printSquare(int x) {
		System.out.println("printSquare x = " + x); 
		x = x * x;
		System.out.println("printSquare x = " + x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5;
		System.out.println("main x = " + x); 
		printSquare(x); 
		System.out.println("main x = " + x);
	}

}
