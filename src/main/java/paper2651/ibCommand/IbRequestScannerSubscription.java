package paper2651.ibCommand;

import java.util.Vector;

import paper2651.instruction.Instruction;

import com.ib.client.ScannerSubscription;
import com.ib.client.TagValue;

public class IbRequestScannerSubscription extends IbCommandAbstract implements
		IbCommand {

	public void execute(Instruction instruction) {

		final ScannerSubscription subscription = new ScannerSubscription();

		final Vector<TagValue> scannerSubscriptionOptions = new Vector<TagValue>();

		clientSocket.reqScannerSubscription(instruction.getTickerId(),
				subscription, scannerSubscriptionOptions);

	}

}
