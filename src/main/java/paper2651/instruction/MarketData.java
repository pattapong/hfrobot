package paper2651.instruction;

import java.util.HashMap;
import java.util.Map;

public class MarketData {

	private Map<Integer, Double> marketDataMap = new HashMap<Integer, Double>();

	public double get(int tickType) {
		if (marketDataMap.containsKey(tickType))
			return marketDataMap.get(tickType);
		return -1;
	}

	public void remove(final int tickType) {
		if (marketDataMap.containsKey(tickType))
			marketDataMap.remove(tickType);
	}

	public void add(final int tickType, final double price) {

		marketDataMap.put(tickType, price);

	}
}
