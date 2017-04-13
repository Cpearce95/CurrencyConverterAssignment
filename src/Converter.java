import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;


/**
 * @author Chris Pearce, Pedro Portella
 *
 */
public class Converter {

	
	
	private static operator op = new operator();
	private static customer user = new customer();
	private static currency c = new currency();
	public static Scanner input = new Scanner(System.in);
	

	
	
	
	
	public static void main(String[] args) {
		
		
			
		
		
		try {
			c.createTransactionLogFile();
			c.WriteDefaultRatesToFile();
		}catch(IOException e){
			e.printStackTrace();
			
		}
	
		
		
		
		
		
		while(true){
				
			
				System.out.println("Please enter the full path to a CSV rates file location or enter any input to use the default rates file");
				
				user.setUserPath(input.nextLine());

				
				
				try{
					c.readCurrenciesToMap(Paths.get(user.getUserPath()));
					System.out.println("File path successful, using your rates.");
					System.out.println("---------------------------------------");
					}
				catch(Exception ex){
					try {
						c.readCurrenciesToMap(c.getDefaultPath());
						System.out.println("Invalid path, using default rates file");
						System.out.println("---------------------------------------");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
						
				}
				
				
				System.out.println("At any point an operator can now enter a PIN followed by the 4 digit pin. e.g. PIN****");
				System.out.println("--------------------------------------------------------------------------------------");
				
		

				
				
				do{ /** asks for their name*/
					System.out.println("Please enter your name");
				
					user.setName(input.nextLine());
					
				}while(op.operatorControl(user.getName(), c));	/** Loops if a valid pin was entered OR the name contains anything but characters*/
				
				
				
				
			
			do{ /** asks for the currency they want to convert from*/
			
				System.out.println("Enter a currency to convert from in the offical three letter capital format:");	
				user.setCurrencyFrom(input.nextLine());
				op.operatorControl(user.getCurrencyFrom(), c);
				}while(!c.CheckCurrencyValid(user.getCurrencyFrom()));
			
			
			
			do{ /** asks for the currency they want to convert to */
				System.out.println("Enter a currency to convert to in the official three letter capital format:");
				
				user.setCurrencyTo(input.nextLine());
				op.operatorControl(user.getCurrencyTo(), c);
			}while(!c.CheckCurrencyValid(user.getCurrencyTo()));
			
			
			
			System.out.println("How much " + user.getCurrencyFrom() + " Would you like to convert?");
			
			
			
	
		
			
			
			do{	/** asks for the amount they want to exchange */
				
				System.out.println("Please enter an amount greater than 0");
				
				
				if(input.hasNextDouble()){
					user.setAmountFrom(input.nextDouble());
					input.nextLine();
				}
				else{
					op.operatorControl(input.nextLine(), c);
				}
				
			

			}while(user.getAmountFrom()<=0);
			
				
			
			try{
			
				
				user.setAmountTo(c.getCurrencies().get(user.getCurrencyTo())/c.getCurrencies().get(user.getCurrencyFrom())*user.getAmountFrom()); 
				
				
				
				
				String placeHolder;
				
				
				do{
					System.out.printf("You will receive %.2f in " + user.getCurrencyTo(),user.getAmountTo());
					System.out.println();
					System.out.println("Do you want to proceed? Enter YES in capitals");
					placeHolder = input.nextLine();
					if(placeHolder.equals("YES")){
							System.out.println("Logging transaction to file");
							
							try {
								c.logTransaction(user.getCurrencyTo(), user.getAmountTo(), user.getName());
							} catch (IOException e) {
								
								e.printStackTrace();
							}	
							
					
					}else if (op.checkPin(placeHolder)==-1){
							System.out.println("Transaction cancelled");
						
					}	
					
				}while(op.operatorControl(placeHolder, c));	
					
			}catch(Exception e){
				System.out.println("Sorry, currency has been suspended");
			}
			
			
		System.out.println("-------Starting new transaction-------");
		
		
		//validate input, use trim, regular expressions.
		//Double check 10percent difference method maths
		}
	}
}

