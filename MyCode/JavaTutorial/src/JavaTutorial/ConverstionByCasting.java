package JavaTutorial;

public class ConverstionByCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2; 
		double d = 2;
		// a = 2
		// a = 2.0 (Implicit)
		//int a = 18.7;
		int b = (int)18.7;
		// ERROR
		     // a = 18
		// a = 0.0
		//double a = 2/3;
		double c = (double)2/3;  // a = 0.6666...
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}

}
