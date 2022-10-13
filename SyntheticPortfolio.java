package packageA;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.*; 
public class SyntheticPortfolio{
	public static void main(String[] args) {
		String splitBy = ",";
		Portfolio portfolio = new Portfolio();
		try {  
			BufferedReader br = new BufferedReader(new FileReader("fruitfolio.csv")); 
			br.readLine();
			String line = null;
			while ((line = br.readLine()) != null){  
				String[] asset = line.split(splitBy);   
				Asset a = new Asset(asset[0], asset[1],Float.valueOf(asset[2]), asset[3], asset[4], asset[5], Float.valueOf(asset[6]), Float.valueOf(asset[7]),Float.valueOf(asset[8]), Float.valueOf(asset[9]));
				portfolio.addToPortfolio(a);
			}
			br.close();
			//Brief testing
//			String[] testVals = {"TSO", "DPS", "EPS", "YIELD", "EARNINGS", "netProfit", "marketValue"};
//			for (String val : testVals) {
//				System.out.println(val);
//				List<Asset> testA = portfolio.getAttributesGreaterThan(val, 7);
//				for (Asset a : testA) {
//					System.out.println(a.toString());
//				}
//				System.out.println("Less Than");
//				List<Asset> testB = portfolio.getAttributesLessThan(val, 10);
//				for (Asset b : testB) {
//					System.out.println(b.toString());
//				}
//			}
//			String[] testValsB = {"TSO", "DPS", "EPS", "YIELD", "EARNINGS", "netProfit"};
//			for (String val : testValsB) {
//				List<Asset> testA = portfolio.generalizedMaxRankingFunction(val, 11);
//				System.out.println(val);
//				for (Asset a : testA) {
//					System.out.println(a.toString());
//				}
//				System.out.println("Min function");
//				List<Asset> testB = portfolio.generalizedMinRankingFunction(val, 11);
//				for (Asset b : testB) {
//					System.out.println(b.toString());
//				}
//			}
		}   
		catch (IOException e){  
		e.printStackTrace();  
		}  
		
	}
}