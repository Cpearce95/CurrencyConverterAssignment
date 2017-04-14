import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;


/**
 * @author Chris Pearce, Pedro Portella
 *
 */
public class currencyTestClass {

	currency c = new currency();
	Date time = new Date();
	
	/**
	 * Checks whether the strings written to the file are the intended rates 
	 * Compares each individual String and the entire String array
	 */
	@Test
	public void writeDefaultRatesToFileTest() {
		String[] original = {"USD,1.216222",
				"EUR,1.145509",
				"CNY,8.409075",
				"AUD,1.608457",
				"JPY,139.620875",
				"GBP,1.00000",
				"INR,80.5923",
				"RUB,70.4910",
				"CHF,1.23760",
				"CAD,1.66244"};
		String[] toCompare = new String[10];
		
		try {
			
			c.WriteDefaultRatesToFile();
			 FileReader fileReader = new FileReader(c.getCurrenciesFile());
		        BufferedReader bufferedReader = new BufferedReader(fileReader);
		       
		        String line = null;
		        int i = 0;
		        while ((line = bufferedReader.readLine()) != null) {
		            toCompare[i]  = line;
		            i++;
		        }
		        bufferedReader.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
		for(int i = 0; i<original.length-1;i++){
		assertTrue(original[i].equals(toCompare[i]));
		}
		assertTrue(Arrays.equals(original, toCompare));
		
	}
	
	
	
	
	/**
	 * Tests that the method creates the file and it actually exists
	 * 
	 */
	@Test
	public void createTransactionLogFileTest() {
		try {
			c.createTransactionLogFile();
			assertTrue(c.getTransactionFile().exists());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	
	
	/**
	 * Compares a String to the String written to the transaction log file
	 */
	@Test
	public void logTransactionTest(){
		
		
		
	try {
			String toCompare = time.toString() + " TestCurrency " + 1.01 + " TestName";
			c.createTransactionLogFile();
			c.logTransaction("TestCurrency", 1.01, "TestName");
			 FileReader fileReader = new FileReader(c.getTransactionFile());
		        BufferedReader bufferedReader = new BufferedReader(fileReader);
		       
		        String test;
		       
		        test = bufferedReader.readLine(); 
		            
		    
		        bufferedReader.close();
		       
		        assertTrue(toCompare.equals(test));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	

	

	@Test
	public void CheckCurrencyValidAndReadCurrenciesToMapTest(){
		
		try {
			c.WriteDefaultRatesToFile();
			c.readCurrenciesToMap(c.getDefaultPath());
			assertTrue(c.CheckCurrencyValid("USD"));
			assertTrue(c.CheckCurrencyValid("GBP"));
			assertTrue(c.CheckCurrencyValid("EUR"));
			assertTrue(c.CheckCurrencyValid("CNY"));
			assertFalse(c.CheckCurrencyValid("usd"));
			assertFalse(c.CheckCurrencyValid("Dollar"));
			assertFalse(c.CheckCurrencyValid("EUr"));
			assertFalse(c.CheckCurrencyValid("123"));
			assertFalse(c.CheckCurrencyValid(""));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		
	}
	
	
}
