package packageA;
import java.util.*;
import java.util.stream.Collectors;
public class Portfolio{
	private TreeSet<Asset> rankedMarketValue;
	private ArrayList<Asset> allAssets;
	public Portfolio() {
		Comparator<Asset> valueRanker = Comparator.comparing(Asset::getMarketValue, Collections.reverseOrder());
		this.allAssets = new ArrayList<>();
		this.rankedMarketValue = new TreeSet<>(valueRanker);
	}
	public void addToPortfolio(Asset a) {
		this.allAssets.add(a);
		this.rankedMarketValue.add(a);
	}
	public List<Asset> getTopFive(){
		return rankedMarketValue.stream().limit(5).collect(Collectors.toList());
	}
	public List<Asset> getTopN(int n){
		return rankedMarketValue.stream().limit(n).collect(Collectors.toList());
	}
	public Map<String, List<Asset>> groupByCountry(){
		return allAssets.stream().collect(Collectors.groupingBy(w -> w.getCountry()));
	}
	public Map<String, List<Asset>> groupByReigon(){
		return allAssets.stream().collect(Collectors.groupingBy(w -> w.getReigon()));
	}
	public Map<String, List<Asset>> groupByCurrency(){
		return allAssets.stream().collect(Collectors.groupingBy(w -> w.getCurrency()));
	}
	public List<Asset> getWeightsGreaterThan(int n){
		return allAssets.stream().filter(a -> a.getWeight() > n).collect(Collectors.toList());
	}
	//Methods from hear on out are a simple attempt on generalizing functions
	//Will be expanding more in the interview
	public List<Asset> getAttributesGreaterThan(String attr, int n){
		if(attr.equalsIgnoreCase("TSO"))
			return allAssets.stream().filter(a -> a.getTSO() > n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("EPS"))
			return allAssets.stream().filter(a -> a.getEPS() > n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("DPS")) 
			return allAssets.stream().filter(a -> a.getDPS() > n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("yield"))
			return allAssets.stream().filter(a -> a.getYield() > n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("earnings"))
			return allAssets.stream().filter(a -> a.getEarnings() > n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("netProfit"))
			return allAssets.stream().filter(a -> a.getNetProfit() > n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("marketValue"))
			return allAssets.stream().filter(a -> a.getMarketValue() > n).collect(Collectors.toList());
		else return null;
	}
	public List<Asset> getAttributesLessThan(String attr, int n){
		if(attr.equalsIgnoreCase("TSO"))
			return allAssets.stream().filter(a -> a.getTSO() < n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("EPS"))
			return allAssets.stream().filter(a -> a.getEPS() < n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("DPS")) 
			return allAssets.stream().filter(a -> a.getDPS() < n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("yield"))
			return allAssets.stream().filter(a -> a.getYield() < n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("earnings"))
			return allAssets.stream().filter(a -> a.getEarnings() < n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("netProfit"))
			return allAssets.stream().filter(a -> a.getNetProfit() < n).collect(Collectors.toList());
		else if(attr.equalsIgnoreCase("marketValue"))
			return allAssets.stream().filter(a -> a.getMarketValue() < n).collect(Collectors.toList());
		else return null;
	}
	public List<Asset> generalizedMaxRankingFunction(String attr, int lim){
		Comparator<Asset> ranker;
		if(attr.equalsIgnoreCase("TSO"))
			ranker = Comparator.comparing(Asset::getTSO, Collections.reverseOrder()).thenComparing(Asset::getName);
		else if(attr.equalsIgnoreCase("EPS"))
			ranker = Comparator.comparing(Asset::getEPS, Collections.reverseOrder()).thenComparing(Asset::getName);
		else if(attr.equalsIgnoreCase("DPS")) 
			ranker = Comparator.comparing(Asset::getDPS, Collections.reverseOrder()).thenComparing(Asset::getName);
		else if(attr.equalsIgnoreCase("yield"))
			ranker = Comparator.comparing(Asset::getYield, Collections.reverseOrder()).thenComparing(Asset::getName);
		else if(attr.equalsIgnoreCase("earnings"))
			ranker = Comparator.comparing(Asset::getEarnings, Collections.reverseOrder()).thenComparing(Asset::getName);
		else if(attr.equalsIgnoreCase("netProfit"))
			ranker = Comparator.comparing(Asset::getNetProfit, Collections.reverseOrder()).thenComparing(Asset::getName);
		else return null;
		TreeSet<Asset> temp = new TreeSet<Asset>(ranker);
		temp.addAll(allAssets);
		return temp.stream().limit(lim).collect(Collectors.toList());
	}
	public List<Asset> generalizedMinRankingFunction(String attr, int limit){
		Comparator<Asset> ranker;
		if(attr.equalsIgnoreCase("TSO"))
			ranker = Comparator.comparing(Asset:: getTSO).thenComparing(Asset::getName);
		else if(attr.equalsIgnoreCase("EPS"))
			ranker = Comparator.comparing(Asset:: getEPS).thenComparing(Asset::getName);
		else if(attr.equalsIgnoreCase("DPS")) 
			ranker = Comparator.comparing(Asset:: getDPS).thenComparing(Asset::getName);
		else if(attr.equalsIgnoreCase("yield"))
			ranker = Comparator.comparing(Asset:: getYield).thenComparing(Asset::getName);
		else if(attr.equalsIgnoreCase("earnings"))
			ranker = Comparator.comparing(Asset:: getEarnings).thenComparing(Asset::getName);
		else if(attr.equalsIgnoreCase("netProfit"))
			ranker = Comparator.comparing(Asset:: getNetProfit).thenComparing(Asset::getName);
		else return null;
		TreeSet<Asset> temp = new TreeSet<Asset>(ranker);
		temp.addAll(this.allAssets);
		return temp.stream().limit(limit).collect(Collectors.toList());
	}
	
}