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
		
		Path p = FileSystems.getDefault().getPath("Currencies" ,"currencies.txt");
		currency c = new currency();
		HashMap<String, Double> currencies = c.readCurrenciesToMap(p);
		
		String currencyFrom;
		String currencyTo;
		String name;
		Scanner input = new Scanner(System.in);
		//ask for other details
		
	
		
		
		
		
		do{
		
			System.out.println("Enter a currency to convert from in the offical three letter capital format:");	
			currencyFrom = input.nextLine();
			System.out.println("Enter a currency to convert to in the official three letter capital format:");
			currencyTo = input.nextLine();
		
	
				
			}while(!c.CheckCurrencyValid(currencies, currencyFrom) || !c.CheckCurrencyValid(currencies, currencyTo));
		
		
		
		System.out.println("How much " + currencyFrom + " Would you like to convert?");
		//ask for how much
		//make sure amount is greater than 0
		//do calculation 
		
		input.close();
	}
	
}

