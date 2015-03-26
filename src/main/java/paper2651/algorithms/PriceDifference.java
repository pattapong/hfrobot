package paper2651.algorithms;

import paper2651.instruction.MarketData;
import paper2651.main.AlgorithmConfiguration;
import paper2651.potfolio.MyPosition;

import com.google.gson.JsonObject;
import com.ib.client.TickType;

public class PriceDifference extends AlgorithmAbstract implements Algorithm {

	private JsonObject algoConfig = AlgorithmConfiguration.getInstance()
			.getAlgorithmJsonObject(AlgorithmEnum.PriceDifference);

	@Override
	public boolean toBuy(MarketData marketData) {

		final MyPosition myPosition = MyPosition.getInstance();

		final double lastPrice = marketData.get(TickType.LAST);

		final double averagePrice = myPosition.getAveragePrice(super
				.getParentInstruction());

		if (averagePrice == -1 || averagePrice == 0)
			return true;
		else {
			final double delta = averagePrice - lastPrice;

			if (delta >= algoConfig.get("priceDifferenceForBuy").getAsDouble())
				return true;
		}

		return false;
	}

	@Override
	public boolean toSell(MarketData marketData) {

		final MyPosition myPosition = MyPosition.getInstance();

		final double lastPrice = marketData.get(TickType.LAST);

		final double averagePrice = myPosition.getAveragePrice(super
				.getParentInstruction());

		final double delta = lastPrice - averagePrice;

		if (delta >= algoConfig.get("priceDifferenceForSell").getAsDouble())
			return true;

		return false;
	}

}
