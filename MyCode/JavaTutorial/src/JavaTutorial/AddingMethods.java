package JavaTutorial;

public class AddingMethods {
	public static void newLine(){
		System.out.println("hiru");
	}
	
	public static void threeLines(){
		newLine(); newLine(); newLine();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Line 1");
		threeLines();
		System.out.println("Line 2");
	}

}
