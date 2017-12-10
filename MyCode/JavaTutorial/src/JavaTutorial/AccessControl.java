package JavaTutorial;

public class AccessControl {
	private String cardNumber;
	private double expenses;
	
	public void charge(double amount){
		expenses = expenses + amount;
	}
	
	public String getCardNumber(String password){
		if (password.equals("SECRET!3*!")){
			return cardNumber;
		}
		return "jerkface";
	}

}

//private access can only be used by the class
//public access can be used by all classes
