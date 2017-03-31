import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.Date;
/**
 * @author Chris Pearce, Pedro Portella
 *
 */
public class Converter {

public static void main(String[] args) {
		
		
		currency c = new currency();
		operator op = new operator();
		customer user = new customer();
		Date date = new Date();
		Scanner input = new Scanner(System.in);
	
		
	
		
		
			
		
		
		try {
			c.createTransactionLogFile();
			c.WriteDefaultRatesToFile();
		}catch(IOException e){
			e.printStackTrace();
			
		}
	
		
		
		
		
		
		while(true){
				
				
			
				System.out.println("Please enter the full path to a CSV rates file location");
				user.setUserPath(input.nextLine());
				
				
				
				
				
				try{
					c.readCurrenciesToMap(Paths.get(user.getUserPath()));
					}
				catch(Exception ex){
					System.out.println("Invalid path, using default rates file");
					try {
						c.readCurrenciesToMap(c.getDefaultPath());
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
		
				
				
			
				System.out.println("Please enter your name");
				user.setName(input.nextLine());
			
			
			do{
			
				System.out.println("Enter a currency to convert from in the offical three letter capital format:");	
				user.setCurrencyFrom(input.nextLine());
				}while(!c.CheckCurrencyValid(c.getCurrencies(), user.getCurrencyFrom()));
			
			
			
			do{
				System.out.println("Enter a currency to convert to in the official three letter capital format:");
				
				user.setCurrencyTo(input.nextLine());
			}while(!c.CheckCurrencyValid(c.getCurrencies(), user.getCurrencyTo()));
			
			
			
			System.out.println("How much " + user.getCurrencyFrom() + " Would you like to convert?");
			
			
			
			do{
				System.out.println("Please enter an amount greater than 0");
				
				user.setAmountFrom(input.nextDouble());
				input.nextLine();
			}while(user.getAmountFrom()<0);
		
			
			user.setAmountTo(c.getCurrencies().get(user.getCurrencyTo())/c.getCurrencies().get(user.getCurrencyFrom())*user.getAmountFrom()); 
			
			System.out.printf("You will receive %.2f in " + user.getCurrencyTo(),user.getAmountTo());
			System.out.println();
			System.out.println("Do you want to proceed? Enter YES in capitals");
			
			
			
			if(input.nextLine().equals("YES")){
				System.out.println("Logging transaction to file");
				
				try {
					c.logTransaction(user.getCurrencyTo(), user.getAmountTo(), user.getName());
				} catch (IOException e) {
					
					e.printStackTrace();
				}	
				
			
			}else{
				System.out.println("Transaction cancelled");
				
				
				
			}	
		System.out.println("----Starting new transaction----");
		
		
		
		//implement operator methods into main program
		//Check input of name to avoid blank and numbers
		}
	}
	
	
}

