import java.util.Scanner;
public class currency {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
	double EUR = 0.8842; //  Random number assigned to variable
	double GBP = 1.1115; //  Random number assigned to variable
	double USD = 0.7234; //  Random number assigned to variable
	double AUD = 0.6708; //  Random number assigned to variable
	double JPY = 0.3223; //  Random number assigned to variable
	
	System.out.println("What is the three letter symbol in CAPS of the currency you would like to convert from? "); 
		String UserInputCurrencyFrom = scan.nextLine(); //Users currency from
		
	while (!UserInputCurrencyFrom.equals ("EUR") || !UserInputCurrencyFrom.equals ("GBP") || !UserInputCurrencyFrom.equals ("USD") || !UserInputCurrencyFrom.equals ("AUD") || !UserInputCurrencyFrom.equals ("JPY")){
		
		System.out.println("This is not a recognised currency, please enter a recognised currency in order to proceed.");
		break;
	}
		
	if (UserInputCurrencyFrom.equals ("EUR") || UserInputCurrencyFrom.equals ("GBP") || UserInputCurrencyFrom.equals ("USD") || UserInputCurrencyFrom.equals ("AUD") || UserInputCurrencyFrom.equals ("JPY")){
		
		
	System.out.println("What is the three letter symbol in CAPS of the currency you would like to convert to? ");	
	} 
	
	
	String UserInputCurrencyTo = scan.nextLine();	// Users currency to 
	
	
	if (UserInputCurrencyTo.equals ("EUR") || UserInputCurrencyTo.equals ("GBP") || UserInputCurrencyTo.equals ("USD") || UserInputCurrencyTo.equals ("AUD") || UserInputCurrencyTo.equals ("JPY")){
		
		
	System.out.println("What value would you like to convert? "); 
	
	
		
	}	else {
		
		System.out.println("This is not a recognised currency, please enter a recognised currency in order to proceed.");
	} 
	double UserInputValue = scan.nextInt(); // How much they want to convert
	System.out.println("You would receive " + GBP / EUR * UserInputValue);
	
	
	}
}
