package paper2651.ibCommand;

import paper2651.instruction.Instruction;

public class IbRequestScannerParameters extends IbCommandAbstract implements
		IbCommand {

	public void execute(Instruction instruction) {
		clientSocket.reqScannerParameters();

	}

}
