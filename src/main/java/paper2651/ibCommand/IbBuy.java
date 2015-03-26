package paper2651.ibCommand;

import paper2651.instruction.Instruction;
import paper2651.instruction.MyOrderStatus;
import paper2651.utils.DataHelper;

import com.ib.client.Contract;
import com.ib.client.Order;

public class IbBuy extends IbCommandAbstract implements IbCommand {

	public void execute(final Instruction instruction) {

		final Contract contract = DataHelper.createContract(instruction);

		final Order order = DataHelper.createOrder(instruction,
				IbCommandEnum.Buy.getString());

		int orderId = order.m_orderId + 1;
		
		clientSocket.placeOrder(orderId, contract, order);

		// initial order status
		final MyOrderStatus myOrderStatus = instruction.getMyOrderStatus();
		
		myOrderStatus.updateOrderStatus(orderId, null);
	}

}
