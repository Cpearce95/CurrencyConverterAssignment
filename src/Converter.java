import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;


/**
 * @author Chris Pearce
 *
 */
public class Converter {

	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Path p = FileSystems.getDefault().getPath("Currencies" ,"currencies.txt"); //This is the path to the flat file with exchange rates stored
		currency c = new currency();	//This a new currency object. Used for accessing methods 
		HashMap<String, Double> currencies = c.readCurrenciesToMap(p); //Create new map and assign to value of returned Hashmap
		
		String currencyFrom; //This a string variable representing the currency user chooses to exchange from
		String currencyTo;	//This a string variable representing the currency user chooses to exchange to
		String Surname; 	//This variable stores the name of the user
		double amountFrom;	//This is the amount that user wishes to exchange	
		double amountTo;	//This is the amount that user will receive
		Scanner input = new Scanner(System.in);
		
		
	
		
		System.out.println("Please enter your Surname?");
		Surname = input.nextLine();
		
		
		do{
		
			System.out.println("Enter a currency to convert from in the offical three letter capital format:");	
			currencyFrom = input.nextLine();
			System.out.println("Enter a currency to convert to in the official three letter capital format:");
			currencyTo = input.nextLine();
		
	
				
			}while(!c.CheckCurrencyValid(currencies, currencyFrom) || !c.CheckCurrencyValid(currencies, currencyTo));
		
		
		
		System.out.println("How much " + currencyFrom + " would you like to convert to " + currencyTo);
		
		
		
		do {
			System.out.println("Please enter a value greater than 0");
			amountFrom = input.nextDouble();
		}while (amountFrom < 0);
			
		
		System.out.println();
		
	
		//get proper rates
		//do calculation 
		//do write to file
		input.close();
	}
	
}

