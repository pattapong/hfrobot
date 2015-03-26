package paper2651.instruction;

import paper2651.algorithms.Algorithm;

public class Instruction {

	private String symbol;

	private String exchange;

	private int targetPosition;

	private String currency;

	private String secType;

	private int tickerId;

	private int quantity;

	private double limitPrice;

	private String buyAlgorithmName;

	private String sellAlgorithmName;

	private boolean enabled;

	private Algorithm buyAlgorithm;

	private Algorithm sellAlgorithm;

	private MarketData marketData = new MarketData();
	
	private MyOrderStatus myOrderStatus = new MyOrderStatus();
	
	
	public boolean equals(Instruction instruction) {
		if (instruction.getExchange().equalsIgnoreCase(exchange)
				&& instruction.getSymbol().equalsIgnoreCase(symbol))
			return true;

		return false;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSecType() {
		return secType;
	}

	public void setSecType(String secType) {
		this.secType = secType;
	}

	public int getTickerId() {
		return tickerId;
	}

	public void setTickerId(String tickerId) {
		this.tickerId = Integer.valueOf(tickerId);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = Integer.valueOf(quantity);
	}

	public double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(String limitPrice) {
		this.limitPrice = Double.valueOf(limitPrice);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = Boolean.valueOf(enabled);
	}

	public String getBuyAlgorithmName() {
		return buyAlgorithmName;
	}

	public void setBuyAlgorithmName(String buyAlgorithmName) {
		this.buyAlgorithmName = buyAlgorithmName;
	}

	public String getSellAlgorithmName() {
		return sellAlgorithmName;
	}

	public void setSellAlgorithmName(String sellAlgorithmName) {
		this.sellAlgorithmName = sellAlgorithmName;
	}

	public Algorithm getBuyAlgorithm() {
		return buyAlgorithm;
	}

	public void setBuyAlgorithm(Algorithm buyAlgorithm) {
		this.buyAlgorithm = buyAlgorithm;
	}

	public Algorithm getSellAlgorithm() {
		return sellAlgorithm;
	}

	public void setSellAlgorithm(Algorithm sellAlgorithm) {
		this.sellAlgorithm = sellAlgorithm;
	}

	public int getTargetPosition() {
		return targetPosition;
	}

	public void setTargetPosition(int targetPosition) {
		this.targetPosition = targetPosition;
	}

	public MarketData getMarketData() {
		return marketData;
	}

	public void setMarketData(MarketData marketData) {
		this.marketData = marketData;
	}

	public MyOrderStatus getMyOrderStatus() {
		return myOrderStatus;
	}
	
}
