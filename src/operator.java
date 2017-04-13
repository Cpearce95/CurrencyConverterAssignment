

/**
 * @author Chris Pearce, Pedro Portella
 *
 */
public class operator {

	
	private final static String PIN = "1234"; /** Constant unique PIN **/
	private int pinAttempts = 3; /** integer representing the number of pinAttempts remaining */
	
	
	
	

	
	/**
	 * Decrements the amount of pin attempts a user has left
	 * 
	 */
	public void decrementPin(){
		pinAttempts--;
		System.out.println("PIN attempt used, you have " + pinAttempts + " remaining");
		System.out.println("Program resuming");
		System.out.println("---------------------------------");
	}
	
	
	
	
	
	/**
	 * Checks if the input is a pin attempt and if so, is it correct
	 * @param pinAttempt
	 * @return
	 */
	public int checkPin(String pinAttempt){
		

		
			if(pinAttempt.length()==7 && pinAttempt.substring(0, 3).equals("PIN")){
				
			
			
					if(pinAttempt.substring(3, 7).equals(PIN)){
					return 1;
					}
				
				return 0;
			}

		
		return -1;
	}
	
	
	
	
	
	
	/**
	 * 
	 * Checks if the operator pin is correct and if the operator wants to update or suspend a currency
	 * Method is bloated and needs to be split up into multiple separate methods
	 * @param currentInput
	 * @param c
	 * @return
	 */
	public boolean operatorControl(String currentInput, currency c){			
		
		if(getPinAttempts()>0){
			if(checkPin(currentInput)==1){ /** PIN IS CORRECT */
				pinSuccess();
				int holder =  UpdateOrSuspend(Converter.input.nextLine());
				if(holder ==1){			/** update a currency*/
					String s = Converter.input.nextLine();
					
					try{
						
						if(TenPercentDifference(Double.parseDouble(s.substring(3, s.length())),c.getCurrencies().get(s.substring(0, 3)))){	/**	Checks if there is a ten percent difference or greater */
							if(Converter.input.nextLine().equals("YES")){
								updateCurrencies(s.substring(0, 3), Double.parseDouble(s.substring(3, s.length())), c);
								return true;
								}
							else{
								System.out.println("Currency not updated, resuming program");
								System.out.println("------------------------------");
								return true;
							}
						}else{
							updateCurrencies(s.substring(0, 3), Double.parseDouble(s.substring(3, s.length())), c);
							return true;
						}
						
					}catch(Exception e){
						System.out.println("Invalid input, program resuming");
						System.out.println("------------------------------");
					}
					return true;
				}else if(holder == 0){			 /** suspend a currency */
					suspendCurrencies(Converter.input.nextLine(), c);
					return true;
				}
				return true;
			}else if(checkPin(currentInput)==0){	/** PIN IS WRONG */
				decrementPin();
				return true;
			}
			return false;	/** attempts remaining but input is not a PIN attempt */
		}
		System.out.println("0 pin attempts left");
		return false; /** no pin attempts remaining */
	}
	
	
	
	
	
	/**
	 * Checks if the first parameter has a 10% difference or greater from the second parameter
	 * @param newValue
	 * @param currentValue
	 * @return
	 */
	public boolean TenPercentDifference(double newValue, double currentValue){	
		
		if((newValue/currentValue)*100-100>10 || (newValue/currentValue)*100-100<-10){
			
			System.out.println("There is a difference greater than 10% in the change, enter YES to confirm update");
			return true;
		}
		
		return false;
	}
	
	
	
	/**
	 * Updates a currency exchange rate value specified by operator
	 * @param currency
	 * @param newValue
	 * @param currencyMap
	 */
	public void updateCurrencies(String currency, Double newValue, currency c){
		
		
		if(c.CheckCurrencyValid(currency)){
		
			for(String s : c.getCurrencies().keySet()){
				if(s.equals(currency)){
					c.getCurrencies().replace(currency, newValue);
					
				}
			}
		
			System.out.println(currency +  " successfully updated to " + newValue);
			System.out.println("--------------------------------");
		}else{
			System.out.println("Invalid entry, program resuming");
			System.out.println("--------------------------------");
		}
		
		
	}
	
	
	
	/**
	 * Suspends a currency specified by operator
	 * Suspends the currency until the next customer iteration
	 */
	public void suspendCurrencies(String SuspendedCurrency, currency c){	
		
		if(c.CheckCurrencyValid(SuspendedCurrency)){
			c.getCurrencies().remove(SuspendedCurrency);
			System.out.println(SuspendedCurrency + " successfully suspended until next transaction");
			System.out.println("------------------------------------------------------------------");
			return;
		}
		
		System.out.println("Currency not suspended, invalid input, program resuming");
		System.out.println("-------------------------------------------------------");
		
		
	}
	
	
	
	
	
	
	/**
	 * Prints out to the console if the user enters the correct pin
	 * 
	 */
	public void pinSuccess(){
		System.out.println("-----PIN Attempt successful-----");
		System.out.println("You can either update an exchange rate or suspend a currency");
		System.out.println("Enter UPDATE or SUSPEND");
	}
	
	
	
	
	/**
	 * Checks if the operator wants to update or suspend a currency
	 * @param command
	 * @return
	 */
	public int UpdateOrSuspend(String command){
		if(command.equals("UPDATE")){
			System.out.println("Enter the currency you would like to update in 3 letter capital format followed immediately by the exchange rate. e.g. EUR1.23");
			return 1;
		}else if(command.equals("SUSPEND")){
			System.out.println("Enter the currency you would like to suspend in 3 letter capital format. e.g. USD");
			return 0;
		}else{
			System.out.println("Invalid input, program resuming.");
			System.out.println("--------------------------------");
			return -1;
		}
	}
	
	
	
	/** getters */
	public int getPinAttempts() {
		return pinAttempts;
	}
	
	
}
