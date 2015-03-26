package paper2651.ibCommand;

public enum IbCommandEnum {
	Buy("BUY"), Sell("SELL"), Short("SHORT"), Position("POSITION"), RequestMarketData(
			"MARKET_DATA"), CancelMarketData("CANCEL_MARKET_DATA"), RequestCurrentTime(
			"CURRENT_TIME"), RequestOpenOrder("REQUEST_OPEN_ORDER"), RequestFundamentalData(
			"REQUEST_FUNDAMENTAL_DATA");

	private String commandString;

	IbCommandEnum(final String commandString) {
		this.commandString = commandString;
	}

	public String getString() {
		return this.commandString;
	}
}
