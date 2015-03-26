package paper2651.ibCommand;

import paper2651.instruction.Instruction;

public class IbPosition extends IbCommandAbstract implements IbCommand {

	public void execute(final Instruction instruction) {
		clientSocket.reqPositions();
	}

}
