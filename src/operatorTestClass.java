import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;



/**
 * @author Chris Pearce, Pedro Portella
 *
 */
public class operatorTestClass {

	operator o = new operator();
	currency c = new currency();

	
	
	
	
	@Test
	public void decrementPinTest(){
		assertEquals("3 attempts left fail",3, o.getPinAttempts());
		o.decrementPin();
		assertEquals("2 attempts left fail",2, o.getPinAttempts());
		o.decrementPin();
		assertEquals("One attempt left fail",1, o.getPinAttempts());
		o.decrementPin();
		assertEquals("No attempts left fail",0, o.getPinAttempts());
	}
	
	@Test
	public void checkPinTest(){
		assertEquals("Invalid pin attempt fail",-1, o.checkPin("PIN12345"));
		assertEquals("Wrong pin but correct format fail",0, o.checkPin("PIN1235"));
		assertEquals("Correct pin fail",1, o.checkPin("PIN1234"));
	}
	
	
	@Test
	public void operatorControlTest(){
		assertFalse(o.operatorControl("1234", c));
		assertFalse(o.operatorControl("PIN12345", c));
		assertTrue(o.operatorControl("PIN4567", c));
		assertTrue(o.operatorControl("PIN1234", c));
	}
	
	
	@Test
	public void TenPercentDifferenceTest(){
		assertFalse("1st test fail",o.TenPercentDifference(9, 9.9));
		assertTrue("2nd test fail",o.TenPercentDifference(10, 9));
		assertFalse("3rd test fail",o.TenPercentDifference(-200, -201));
		assertTrue("4th test fail",o.TenPercentDifference(-76, -85.7));
	}
	
	
	@Test
	public void updateCurrenciesTest(){
		try {
			c.WriteDefaultRatesToFile();
			c.readCurrenciesToMap(c.getDefaultPath());
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
		Double d = new Double(1.7); 
		Double oldValue = c.getCurrencies().get("USD");
		o.updateCurrencies("USD", new Double(1.7), c);
		assertEquals("1st test fail",d,c.getCurrencies().get("USD"));
		assertNotEquals("2nd test fail",oldValue,c.getCurrencies().get("USD"));
		
	}
	
	
	
	@Test
	public void suspendCurrencyTest(){
		try {
			c.WriteDefaultRatesToFile();
			c.readCurrenciesToMap(c.getDefaultPath());
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
		String suspended = "USD";
		assertNotEquals("1st test fail",null, c.getCurrencies().get(suspended));
		o.suspendCurrencies(suspended, c);
		assertEquals("2nd test fail",null, c.getCurrencies().get(suspended));
		
		
	}
	
	
	
	@Test
	public void updateOrSuspendTest(){
		assertEquals("1st test fail",1, o.UpdateOrSuspend("UPDATE"));
		assertEquals("2nd test fail",0, o.UpdateOrSuspend("SUSPEND"));
		assertEquals("3rd test fail",-1, o.UpdateOrSuspend("asdasdas"));
		assertNotEquals("4th test fail",1, o.UpdateOrSuspend("SUSPEND"));
		assertNotEquals("5th test fail",0, o.UpdateOrSuspend("SUSPEND1"));
		assertNotEquals("6th test fail",-1, o.UpdateOrSuspend("UPDATE"));
	}
	
	
	
}
