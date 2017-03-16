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
		String surname; 	//This variable stores the name of the user
		double amountFrom;	//This is the amount that user wishes to exchange	
		double amountTo;	//This is the amount that user will receive
		Scanner input = new Scanner(System.in);
		
		
	
		while (true){
		System.out.println("Please enter your Surname?");
		surname = input.nextLine();
		
		
		do{
		
			System.out.println("Enter a currency to convert from in the offical three letter capital format:");	
			currencyFrom = input.nextLine();

		
	
				
			}while(!c.CheckCurrencyValid(currencies, currencyFrom));
		
		
		
		do{
			
		
			System.out.println("Enter a currency to convert to in the official three letter capital format:");
			currencyTo = input.nextLine();
		
		}while(!c.CheckCurrencyValid(currencies, currencyTo));
		
		
		
		System.out.println("How much " + currencyFrom + " would you like to convert to " + currencyTo);
		
		
		
		do {
			System.out.println("Please enter a value greater than 0");
			amountFrom = input.nextDouble();
			input.nextLine();
		}while (amountFrom < 0);
			
		amountTo = currencies.get(currencyTo)/currencies.get(currencyFrom)*amountFrom;
		System.out.printf("You will receive %.2f " + currencyTo, amountTo);
		System.out.println();
		System.out.println("Do you want to proceed with the transaction? Enter YES in capitals to proceed.");
		
		if (input.nextLine().equals("YES")){
			System.out.println("Transaction Log");
		//code for write to file
		}
		else{
			System.out.println("Transaction Cancelled");
			
		}
		}
		
		// input.close
	}
	
}

