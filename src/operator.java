import java.util.Map;

/**
 * @author Chris Pearce, Pedro Portella
 *
 */
public class operator {

private final static String PIN = "1234"; /** Constant unique PIN **/
	
	
	/**
	 * Checks if the input is the correct pin
	 * @return	A boolean
	 */
	public boolean checkPin(String pinAttempt){
		
		if(pinAttempt.equals(PIN)){
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
	public void updateCurrencies(String currency, Double newValue, Map<String, Double> currencyMap){
		
		for(String s : currencyMap.keySet()){
			if(s.equals(currency)){
				currencyMap.replace(currency, newValue);
				
			}
		}
		
		
		
	}
	
	
	
	/**
	 * Suspends a currency specified by operator
	 */
	public void suspendCurrencies(){	//added
		
		
		
	}
	
	
	
}
