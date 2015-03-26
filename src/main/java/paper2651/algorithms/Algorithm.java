package paper2651.algorithms;

import paper2651.instruction.Instruction;
import paper2651.instruction.MarketData;

public interface Algorithm {

	public Instruction getParentInstruction();
	
	public void setParentInstruction(final Instruction instruction);

	public boolean toBuy(MarketData marketData);

	public boolean toSell(MarketData marketData);
}
