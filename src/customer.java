
public class customer {

	private String currencyFrom; /** String representing the currency to be exchanged from **/
	private String currencyTo;	/** String representing the currency to be exchanged to **/
	private String name; /** Stored name of user **/
	private String UserPath; /** Path to currency rates file designated by user **/
	private double amountFrom; /** Double representing the amount the user wants to exchange **/
	private double amountTo; /** Double representing the amount the user will receive **/
	
	
	/**getters**/
	
	public double getAmountFrom() {
		return amountFrom;
	}
	
	public double getAmountTo() {
		return amountTo;
	}
	
	public String getCurrencyFrom() {
		return currencyFrom;
	}
	public String getCurrencyTo() {
		return currencyTo;
	}
	public String getName() {
		return name;
	}
	public String getUserPath() {
		return UserPath;
	}
	
	/**setters**/
	
	
	public void setAmountFrom(double amountFrom) {
		this.amountFrom = amountFrom;
	}
	public void setAmountTo(double amountTo) {
		this.amountTo = amountTo;
	}
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserPath(String userPath) {
		UserPath = userPath;
	}
		
	
}
