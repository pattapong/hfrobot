package paper2651.ibCommand;

import com.ib.client.Contract;
import com.ib.client.Order;

import paper2651.instruction.Instruction;
import paper2651.utils.DataHelper;

public class IbSell extends IbCommandAbstract implements IbCommand {

	public void execute(final Instruction instruction) {
		
		final Contract contract = DataHelper.createContract(instruction);
		
		final Order order = DataHelper.createOrder(instruction,
				IbCommandEnum.Sell.getString());

		int orderId = order.m_orderId + 1;
		
		clientSocket.placeOrder(orderId, contract, order);
	}
}
