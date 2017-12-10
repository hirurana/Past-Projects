package Assignments;

public class FooCorporation {
	// wages calculator
	public static void wages(double basePay, int hours) {
		// defining overtime as 0
		double overtime = 0.0;

		// if the base pay is below $8.00 or working hours is over 60 then
		// produce and error
		if (basePay < 8.00 || hours > 60) {
			System.out.println("Employee is not working at legal standards");
			return;
		}

		// if hours worked is over 40 add the overtime bonus
		if (hours > 40) {
			int extraHours = hours - 40; // additional hours
			overtime = extraHours * (basePay * 1.5); // overtime addition to
														// wages
			hours = 40; // hours is reset to 40
		}

		// calculate the wage
		double wage = basePay * hours + overtime;
		System.out.println("$"
				+ new java.text.DecimalFormat("#.00").format(wage));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wages(7.50, 35);
		wages(8.20, 47);
		wages(10.00, 73);

	}

}
