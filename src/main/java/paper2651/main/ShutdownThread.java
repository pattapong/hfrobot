package paper2651.main;

import java.util.List;

import paper2651.ibCommand.IbCommand;
import paper2651.ibCommand.IbCommandEnum;
import paper2651.ibCommand.IbCommandFactory;
import paper2651.instruction.Instruction;

public class ShutdownThread extends Thread {

	private List<Instruction> instructionList;
	
	public ShutdownThread(List<Instruction> instructionList){
		this.instructionList = instructionList;
	}
	
	public void run() {

		for (final Instruction instruction : instructionList) {

			final IbCommand ibCommand = IbCommandFactory
					.getIbCommand(IbCommandEnum.CancelMarketData);

			ibCommand.execute(instruction);
		}
	}
}
