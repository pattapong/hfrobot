package paper2651.potfolio;

import java.util.HashMap;
import java.util.Map;

import paper2651.instruction.Instruction;

import com.ib.client.Contract;

public class MyPosition {

	private Map<String, Position> positionMap = new HashMap<String, Position>();

	private static MyPosition myPosition;

	public static MyPosition getInstance() {

		if (myPosition == null) {
			myPosition = new MyPosition();
		}

		return myPosition;
	}

	public void updatePosition(Position position) {

		final Contract contract = position.getContract();

		final String key = contract.m_exchange + "." + contract.m_symbol;

		positionMap.put(key.toLowerCase(), position);

	}

	public double getAveragePrice(final Instruction instruction) {

		final String key = instruction.getExchange() + "."
				+ instruction.getSymbol();

		final Position position = positionMap.get(key.toLowerCase());
		
		if (position != null)
			return position.getAvgCost();
		
		return -1;
	}

	public int getCurrentPosition(final Instruction instruction) {

		final String key = instruction.getExchange() + "."
				+ instruction.getSymbol();

		final Position position = positionMap.get(key.toLowerCase());

		if (position != null)
			return position.getPosition();
		
		return 0;
	}

}
