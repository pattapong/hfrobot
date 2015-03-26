package paper2651.ibCommand;

import java.util.ArrayList;
import java.util.List;

import paper2651.instruction.Instruction;

import com.ib.client.Contract;
import com.ib.client.MarketDataType;
import com.ib.client.TagValue;

public class IbRequestMarketData extends IbCommandAbstract implements IbCommand {

	public void execute(final Instruction instruction) {

		final Contract contract = new Contract();
		contract.m_exchange = instruction.getExchange();
		contract.m_symbol = instruction.getSymbol();
		contract.m_currency = instruction.getCurrency();
		contract.m_secType = instruction.getSecType();

		int uniqueId = instruction.getTickerId();

		final String genericTicks = "100,101,104,105,106,107,165,221,225,233,236,258,293,294,295,318";
//		final String genericTicks = "221";
		
		final boolean snapshotMktData = false;

		final List<TagValue> mktDataOptions = new ArrayList<TagValue>();

		clientSocket.reqMarketDataType(MarketDataType.REALTIME);

		clientSocket.reqMktData(uniqueId, contract, genericTicks,
				snapshotMktData, mktDataOptions);
	}
}
