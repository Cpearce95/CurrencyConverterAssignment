import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Chris Pearce, Pedro Portella
 *
 */

public class currency {
	
	private Date date = new Date();
	private File transactionFile = new File("transactionLog.txt"); /**File to log transactions **/
	private File currenciesFile = new File("currencies.txt"); /** Default file to store currencies **/
	private Path defaultPath = Paths.get("currencies.txt"); /**Path of the default exchange rate file */
	private HashMap<String,Double> Currencies = new HashMap<String,Double>();	/**Hash map object instantiated, this holds the currency as the key and the exchange rate as the value*/
	private String[] DefaultRates = {
			"USD,1.216222",
			"EUR,1.145509",
			"CNY,8.409075",
			"AUD,1.608457",
			"JPY,139.620875",
			"GBP,1.00000",
			"INR,80.5923",
			"RUB,70.4910",
			"CHF,1.23760",
			"CAD,1.66244"
}; /** Array that holds the default stored exchange rates in comma separated value form **/
	
	
	
	
	
	
	/**
	 * Method that creates the default currency file and writes the exchange rates to it
	 * @throws IOException
	 */
	public void  WriteDefaultRatesToFile() throws IOException{
		currenciesFile.createNewFile();
		FileWriter f = new FileWriter(currenciesFile);
		for(String s: DefaultRates){
			f.write(s + "\n");
		}
		f.close();
	}
	
	
	/**
	 * Creates the file to log transactions
	 * @throws IOException
	 */
	public void createTransactionLogFile() throws IOException{
		PrintWriter po = new PrintWriter(transactionFile);
		po.close();
		transactionFile.createNewFile();
		
	}
	
	
	/**
	 * Records the user information to the logs file.
	 * @param CurrencyTo
	 * @param AmountTo
	 * @param name
	 * @throws IOException
	 */
	public void logTransaction(String CurrencyTo, double AmountTo, String name) throws IOException{
		 FileWriter fw = new FileWriter(transactionFile, true);
		 
		 String StringAmountTo  = String.format("%.02f", AmountTo);
		 fw.write(date.toString() + " " + CurrencyTo + " " + StringAmountTo + " " + name + "\n");
				
		 fw.close();
		
	}
	
	
	

	
	
	/**
	 * @param Takes a path to the flat file containing the currency conversion rates
	 * @return	A map object containing all the currencies in Hashmap<Currency, ConversionRate> format
	 * @throws IOException 
	 */
	public void readCurrenciesToMap(Path p) throws IOException{
		Currencies.clear();
		
		Charset charset = Charset.forName("US-ASCII");
		BufferedReader reader = Files.newBufferedReader(p, charset);
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	
		        String[] ar = line.split(",");
		        
		        Currencies.put(ar[0],Double.parseDouble(ar[1]));
		        
		    }
		
		reader.close();
		
	}
	
	
	
	/**
	 * @param currencyMap A map containing currencies and their exchange rate
	 * @param currency A string representing a currency type
	 * @return	A boolean that represents whether the currency is contained within the map
	 */
	public boolean CheckCurrencyValid( String currency){
		
		for(String s : Currencies.keySet()){
			if(s.equals(currency)){
				return true;
				
			}
		}
			
		
		return false;
	}
	
	
	/**getters**/
	
	public Path getDefaultPath() {
		return defaultPath;
	}
	
	
	public File getTransactionFile() {
		return transactionFile;
	}
	
	public HashMap<String, Double> getCurrencies() {
		return Currencies;
	}
	
	public String[] getDefaultRates() {
		return DefaultRates;
	}
	
	public File getCurrenciesFile() {
		return currenciesFile;
	}
}
