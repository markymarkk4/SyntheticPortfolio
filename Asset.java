package packageA;
import java.util.*;
public class Asset{
	private String name;
	private String ticker;
	private float weight;
	private String country;
	private String reigon;
	private String currency;
	private float price;
	private float TSO;
	private float EPS;
	private float DPS;
	private float yield;
	private float earnings;
	private float marketValue;
	private float netProfit;
	public Asset(String name, String ticker, float weight, String country, String reigon, String currency, float price, float TSO, float EPS, float DPS) {
		this.name = name;
		this.ticker = ticker;
		this.weight = weight;
		this.country = country;
		this.reigon =reigon;
		this.currency = currency;
		this.price = price;
		this.TSO = TSO;
		this.EPS = EPS;
		this.DPS = DPS;
		generatePriceEarnings();
		generateDividendYield();
		generateTotalMarketValue();
		generateNetProfit();
	}
	//Please do not run this function - Will not run without an API call hence simply wrote psuedocode.
	public void updateCurrency(String newCurrency) {
		//Normally I would make some sort of API call to get an updated 
		// exchange rate, however, in this case for the sake of time I am just assuming I made that api call
//		 URL url = new URL(url);
//		 URLConnection yc = url.openConnection();
//		 BufferedReader in = new BufferedReader(
//		                          new InputStreamReader(
//		                          yc.getInputStream()));
		HashMap<String, Float> currencyMap = new HashMap<>();
		String exchangeSymbol = this.currency + "/"+newCurrency;
		this.setPrice(this.price/currencyMap.get(exchangeSymbol));
		this.setEPS(this.EPS/this.price);
		this.setDPS(this.DPS/this.price);
		generatePriceEarnings();
		generateDividendYield();
		generateTotalMarketValue();
		generateNetProfit();
		
	}
	public String toString() {
		return name + " " + ticker + " " + weight + " " + country + " " + reigon + " " + currency + " " + price + " TSO: " + TSO + " EPS: " + EPS + " DPS: " + DPS + " Yield: " + yield + " Earnings: " + earnings + " Profit: " + netProfit + " Market Value: " + marketValue;
	}
	public float generatePriceEarnings() {
		this.earnings = this.price / this.EPS;
		return this.earnings;
	}
	public float generateDividendYield() {
		this.yield = this.DPS / this.price;
		return this.yield;
	}
	public float generateTotalMarketValue() {
		this.marketValue = this.price * this.TSO;
		return this.marketValue;
	}
	public float generateNetProfit() {
		this.netProfit = this.TSO * this.EPS;
		return this.netProfit;
	}
	public float getYield() {
		return yield;
	}
	public void setYield(float yield) {
		this.yield = yield;
	}
	public float getEarnings() {
		return earnings;
	}
	public void setEarnings(float earnings) {
		this.earnings = earnings;
	}
	public float getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(float marketValue) {
		this.marketValue = marketValue;
	}
	public float getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(float netProfit) {
		this.netProfit = netProfit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getReigon() {
		return reigon;
	}
	public void setReigon(String reigon) {
		this.reigon = reigon;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTSO() {
		return TSO;
	}
	public void setTSO(float tSO) {
		TSO = tSO;
	}
	public float getEPS() {
		return EPS;
	}
	public void setEPS(float ePS) {
		EPS = ePS;
	}
	public float getDPS() {
		return DPS;
	}
	public void setDPS(float dPS) {
		DPS = dPS;
	}
}