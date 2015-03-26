package paper2651.instruction;

import java.util.HashMap;
import java.util.Map;

import com.ib.controller.OrderStatus;

public class MyOrderStatus {
	private Map<Integer, OrderStatus> orderStatusMap = new HashMap<Integer, OrderStatus>();

	public void updateOrderStatus(final int orderId,
			final OrderStatus orderStatus) {

		if (orderStatus == OrderStatus.Filled) {
			orderStatusMap.remove(orderId);
		} else {
			orderStatusMap.put(orderId, orderStatus);
		}

	}

	public void removeOrderStatus(final int orderId) {
		orderStatusMap.remove(orderId);
	}

	public boolean hasOpenOrders() {

		for (final OrderStatus orderStatus : orderStatusMap.values()) {
			if (orderStatus != null && orderStatus.isActive())
				return true;
		}
		return false;
	}

	public boolean isActive(final int orderId) {
		return orderStatusMap.get(orderId).isActive();
	}

	public Map<Integer, OrderStatus> getOrderStatusMap() {
		return orderStatusMap;
	}

	public boolean isExist(final int orderId) {
		return orderStatusMap.containsKey(orderId);
	}
}
