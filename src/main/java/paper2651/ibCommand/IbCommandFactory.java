package paper2651.ibCommand;

public class IbCommandFactory {

	public static IbCommand getIbCommand(final IbCommandEnum commanEnum) {
	
		if (commanEnum.equals(IbCommandEnum.RequestMarketData))
			return new IbRequestMarketData();
		else if (commanEnum.equals(IbCommandEnum.Buy))
			return new IbBuy();
		else if (commanEnum.equals(IbCommandEnum.Sell))
			return new IbSell();
		else if (commanEnum.equals(IbCommandEnum.Position))
			return new IbPosition();
		else if (commanEnum.equals(IbCommandEnum.CancelMarketData))
			return new IbCancelMarketData();
		else if (commanEnum.equals(IbCommandEnum.RequestCurrentTime))
			return new IbRequestCurrentTime();
		else if (commanEnum.equals(IbCommandEnum.RequestOpenOrder))
			return new IbRequestOpenOrders();
		else if (commanEnum.equals(IbCommandEnum.RequestFundamentalData))
			return new IbRequestFundamentalData();
		return null;
	}

}
