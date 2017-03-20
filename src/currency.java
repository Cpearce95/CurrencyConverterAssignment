import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris Pearce
 *
 */
public class currency {
	
	HashMap<String,Double> Currencies = new HashMap<String,Double>();	//Hash map object instantiated, this holds the currency as the key and the exchange rate as the value
	
	
	
	
	/**
	 * @param Takes a path to the flat file containing the currency conversion rates
	 * @return	A map object containing all the currencies in Hashmap<Currency, ConversionRate> format
	 */
	public HashMap<String,Double> readCurrenciesToMap(Path p){
		Currencies.clear();
		
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(p, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	
		        String[] ar = line.split(",");
		        
		        Currencies.put(ar[0],Double.parseDouble(ar[1]));
		        
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	
		return Currencies;
	}
	
	
	
	/**
	 * @param currencyMap A map containing currencies and their exchange rate
	 * @param currency A string representing a currency type
	 * @return	A boolean that represents whether the currency is contained within the map
	 */
	public boolean CheckCurrencyValid(HashMap<String, Double> currencyMap, String currency){
		
		for(String s : currencyMap.keySet()){
			if(s.equals(currency)){
				return true;
				
			}
		}
			
		
		return false;
	}
	

	
	
}
