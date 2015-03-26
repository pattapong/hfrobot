package paper2651.ib;

import paper2651.algorithms.Algorithm;
import paper2651.ibCommand.IbCommand;
import paper2651.ibCommand.IbCommandEnum;
import paper2651.ibCommand.IbCommandFactory;
import paper2651.instruction.Instruction;
import paper2651.instruction.InstructionManager;
import paper2651.instruction.MarketData;
import paper2651.instruction.MyOrderStatus;
import paper2651.potfolio.MyPosition;
import paper2651.potfolio.Position;
import paper2651.utils.DataHelper;

import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.TickType;
import com.ib.client.UnderComp;
import com.ib.controller.OrderStatus;

public class IBWrapper implements EWrapper {

	private InstructionManager instructionReader = InstructionManager
			.getInstance();

	public static IBWrapper instance;

	public static IBWrapper getInstance() {
		if (instance == null) {
			instance = new IBWrapper();
		}
		return instance;
	}

	public void error(Exception e) {
		// TODO Auto-generated method stub

	}

	public void error(String str) {
		// TODO Auto-generated method stub

	}

	public void error(int id, int errorCode, String errorMsg) {
		// TODO Auto-generated method stub

	}

	public void connectionClosed() {
		// TODO Auto-generated method stub

	}

	public void tickPrice(int tickerId, int tickType, double price,
			int canAutoExecute) {

		final String tickName = TickType.getField(tickType);

		final Instruction instruction = instructionReader
				.getInstructionByTickerId(tickerId);

		final String symbol = instruction.getSymbol();

		System.out.println("tickPrice:	" + symbol + "	" + tickName + "	price	"
				+ price);

		final MarketData marketData = instruction.getMarketData();

		marketData.add(tickType, price);

		buyOrSell(instruction);
	}

	public void tickSize(int tickerId, int tickType, int size) {

		// final String typeName = TickType.getField(tickType);
		//
		// final String symbol = instructionReader.getInstructionByTickerId(
		// tickerId).getSymbol();

		// System.out.println("tickSize : " + symbol + " " + typeName + " size "
		// + size);

		final Instruction instruction = instructionReader
				.getInstructionByTickerId(tickerId);

		final MarketData marketData = instruction.getMarketData();

		marketData.add(tickType, size);

	}

	public void tickOptionComputation(int tickerId, int field,
			double impliedVol, double delta, double optPrice,
			double pvDividend, double gamma, double vega, double theta,
			double undPrice) {
		// TODO Auto-generated method stub

	}

	public void tickGeneric(int tickerId, int tickType, double value) {

		final String typeName = TickType.getField(tickType);

		final String symbol = instructionReader.getInstructionByTickerId(
				tickerId).getSymbol();

		System.out.println("tickGeneric : " + symbol + " " + typeName
				+ " value " + value);

		final Instruction instruction = instructionReader
				.getInstructionByTickerId(tickerId);

		final MarketData marketData = instruction.getMarketData();

		marketData.add(tickType, value);
	}

	public void tickString(int tickerId, int tickType, String value) {
		// TODO Auto-generated method stub

	}

	public void tickEFP(int tickerId, int tickType, double basisPoints,
			String formattedBasisPoints, double impliedFuture, int holdDays,
			String futureExpiry, double dividendImpact, double dividendsToExpiry) {
		// TODO Auto-generated method stub

	}

	public void orderStatus(int orderId, String status, int filled,
			int remaining, double avgFillPrice, int permId, int parentId,
			double lastFillPrice, int clientId, String whyHeld) {

		System.out.println("OrderStatus : orderId " + orderId + " status "
				+ status + " filled " + filled + " remaining " + remaining
				+ " avgFillPrice " + avgFillPrice + " permId " + permId
				+ " parentId " + parentId + " lastFillPrice " + lastFillPrice
				+ " clientId " + clientId + " whyHelp " + whyHeld);

		final OrderStatus orderStatus = DataHelper.getOrderStatus(status);

		final Instruction instruction = instructionReader
				.getInstructionByOrderId(orderId);

		if (instruction != null) {

			final MyOrderStatus myOrderStatus = instruction.getMyOrderStatus();

			myOrderStatus.updateOrderStatus(orderId, orderStatus);
		}
	}

	public void openOrder(int orderId, Contract contract, Order order,
			OrderState orderState) {

		System.out.println("openOrder:	" + orderId + "	symbol	"
				+ contract.m_symbol + "	quntity	" + order.m_totalQuantity);

		// Update openOrderManager

	}

	public void openOrderEnd() {
		// TODO Auto-generated method stub

	}

	public void updateAccountValue(String key, String value, String currency,
			String accountName) {
		// TODO Auto-generated method stub

	}

	public void updatePortfolio(Contract contract, int position,
			double marketPrice, double marketValue, double averageCost,
			double unrealizedPNL, double realizedPNL, String accountName) {
		// TODO Auto-generated method stub

	}

	public void updateAccountTime(String timeStamp) {
		// TODO Auto-generated method stub

	}

	public void accountDownloadEnd(String accountName) {
		// TODO Auto-generated method stub

	}

	public void nextValidId(int orderId) {
		// TODO Auto-generated method stub

	}

	public void contractDetails(int reqId, ContractDetails contractDetails) {
		// TODO Auto-generated method stub

	}

	public void bondContractDetails(int reqId, ContractDetails contractDetails) {
		// TODO Auto-generated method stub

	}

	public void contractDetailsEnd(int reqId) {
		// TODO Auto-generated method stub

	}

	public void execDetails(int reqId, Contract contract, Execution execution) {
		// TODO Auto-generated method stub

	}

	public void execDetailsEnd(int reqId) {
		// TODO Auto-generated method stub

	}

	public void updateMktDepth(int tickerId, int position, int operation,
			int side, double price, int size) {
		// TODO Auto-generated method stub

	}

	public void updateMktDepthL2(int tickerId, int position,
			String marketMaker, int operation, int side, double price, int size) {
		// TODO Auto-generated method stub

	}

	public void updateNewsBulletin(int msgId, int msgType, String message,
			String origExchange) {
		// TODO Auto-generated method stub

	}

	public void managedAccounts(String accountsList) {
		// TODO Auto-generated method stub

	}

	public void receiveFA(int faDataType, String xml) {
		// TODO Auto-generated method stub

	}

	public void historicalData(int reqId, String date, double open,
			double high, double low, double close, int volume, int count,
			double WAP, boolean hasGaps) {
		// TODO Auto-generated method stub

	}

	public void scannerParameters(String xml) {
		// TODO Auto-generated method stub

	}

	public void scannerData(int reqId, int rank,
			ContractDetails contractDetails, String distance, String benchmark,
			String projection, String legsStr) {
		System.out.println("scanData:	");

	}

	public void scannerDataEnd(int reqId) {
		// TODO Auto-generated method stub

	}

	public void realtimeBar(int reqId, long time, double open, double high,
			double low, double close, long volume, double wap, int count) {
		// TODO Auto-generated method stub

	}

	public void currentTime(long time) {

		System.out.print("The current time is " + DataHelper.convertTime(time));

	}

	public void fundamentalData(int reqId, String data) {
		System.out.println("fundamentalData:	reqId	" + reqId + "	data	" + data);

	}

	public void deltaNeutralValidation(int reqId, UnderComp underComp) {
		// TODO Auto-generated method stub

	}

	public void tickSnapshotEnd(int reqId) {
		// TODO Auto-generated method stub

	}

	public void marketDataType(int reqId, int marketDataType) {
		// TODO Auto-generated method stub

	}

	public void commissionReport(CommissionReport commissionReport) {
		// TODO Auto-generated method stub

	}

	MyPosition myPosition = MyPosition.getInstance();

	public void position(String account, Contract contract, int pos,
			double avgCost) {

		System.out.println("exchange	" + contract.m_exchange + "	" + " symbol	"
				+ contract.m_symbol + "	" + "position	" + pos + " avgCost	"
				+ avgCost);

		final Position position = new Position();

		position.setAccount(account);

		position.setContract(contract);

		position.setPosition(pos);

		position.setAverageCost(avgCost);

		myPosition.updatePosition(position);

		final Instruction instruction = instructionReader
				.getInstructionBySymbol(contract.m_symbol);

		buyOrSell(instruction);
	}

	private void buyOrSell(final Instruction instruction) {
		if (instruction.isEnabled()) {
			final int currentPosition = myPosition
					.getCurrentPosition(instruction);

			final int targetPosition = instruction.getTargetPosition();

			final MarketData marketData = instruction.getMarketData();

			// Check order status before continue
			final boolean hasOpenOrder = instruction.getMyOrderStatus()
					.hasOpenOrders();

			if (!hasOpenOrder) {

				if (currentPosition < targetPosition) {

					final Algorithm buyAlgorithm = instruction
							.getBuyAlgorithm();

					if (buyAlgorithm.toBuy(marketData)) {

						final IbCommand buyIbCommand = IbCommandFactory
								.getIbCommand(IbCommandEnum.Buy);

						buyIbCommand.execute(buyAlgorithm
								.getParentInstruction());

					} else {

						System.out.println(marketData.get(TickType.LAST)
								+ " is not the right price to buy");

					}

				}

				if (currentPosition > 0) {

					final Algorithm sellAlgorithm = instruction
							.getSellAlgorithm();

					if (sellAlgorithm.toSell(marketData)) {

						final IbCommand sellIbCommand = IbCommandFactory
								.getIbCommand(IbCommandEnum.Sell);

						sellIbCommand.execute(sellAlgorithm
								.getParentInstruction());

					} else {

						System.out.println(marketData.get(TickType.LAST)
								+ " is not the right price to sell");

					}

				}
			}
		}
	}

	public void positionEnd() {
		// TODO Auto-generated method stub

	}

	public void accountSummary(int reqId, String account, String tag,
			String value, String currency) {
		// TODO Auto-generated method stub

	}

	public void accountSummaryEnd(int reqId) {
		// TODO Auto-generated method stub

	}

	public void verifyMessageAPI(String apiData) {
		// TODO Auto-generated method stub

	}

	public void verifyCompleted(boolean isSuccessful, String errorText) {
		// TODO Auto-generated method stub

	}

	public void displayGroupList(int reqId, String groups) {
		// TODO Auto-generated method stub

	}

	public void displayGroupUpdated(int reqId, String contractInfo) {
		// TODO Auto-generated method stub

	}
}
