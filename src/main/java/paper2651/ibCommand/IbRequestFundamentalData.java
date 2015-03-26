package paper2651.ibCommand;

import paper2651.instruction.Instruction;
import paper2651.utils.DataHelper;

import com.ib.client.Contract;

public class IbRequestFundamentalData extends IbCommandAbstract implements IbCommand {

	public void execute(final Instruction instruction) {

		final Contract contract = DataHelper.createContract(instruction);

		int requestId = DataHelper.getUniqueId();
		
		String reportType = "ReportRatios";
		
		clientSocket.reqFundamentalData(requestId, contract, reportType );

	}

}
