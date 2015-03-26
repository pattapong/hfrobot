package paper2651.algorithms;

import paper2651.instruction.Instruction;
import paper2651.instruction.MarketData;

public abstract class AlgorithmAbstract implements Algorithm {

	private Instruction parentInstruction;

	public Instruction getParentInstruction() {
		return parentInstruction;
	}

	public void setParentInstruction(final Instruction instruction) {
		this.parentInstruction = instruction;

	}

	public abstract boolean toBuy(MarketData marketData);

	public abstract boolean toSell(MarketData marketData);

}
