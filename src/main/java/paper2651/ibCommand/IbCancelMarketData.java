package paper2651.ibCommand;

import paper2651.instruction.Instruction;

public class IbCancelMarketData extends IbCommandAbstract implements IbCommand {

	public void execute(final Instruction instruction) {
		clientSocket.cancelMktData(instruction.getTickerId());
	}

}
