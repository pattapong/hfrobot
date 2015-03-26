package paper2651.utils;

import ib.Config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import paper2651.instruction.Instruction;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ib.client.Contract;
import com.ib.client.Order;
import com.ib.controller.OrderStatus;
import com.ib.controller.OrderType;

public class DataHelper {

	public static int getUniqueId() {
		return (int) (System.currentTimeMillis() / 1000);
	}

	public static String convertTime(final long time) {
		final Date date = new Date(time);
		final DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
		return formatter.format(date);
	}

	public boolean isMarketOpened(long time) throws ParseException {
		final Date date = new Date(time);

		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		Date nineThirty = parser.parse("09:30");
		Date fourPM = parser.parse("04:00");

		if (date.after(nineThirty) && date.before(fourPM)) {
			return true;
		}

		return false;
	}

	public static JsonObject getJsonObject(String jsonFileName)
			throws IOException {

		String jsonString = getJsonString(jsonFileName);

		return parseJsonStringToJsonObject(jsonString);
	}

	public static String getJsonString(String jsonFileName) throws IOException {
		final InputStream inputStream = Config.class.getClassLoader()
				.getResourceAsStream(jsonFileName);

		final StringWriter writer = new StringWriter();

		Charset encoding = null;

		IOUtils.copy(inputStream, writer, encoding);

		String jsonString = writer.toString();

		return jsonString;
	}

	public static Order createOrder(final Instruction instruction,
			final String orderType) {

		final Order order = new Order();

		order.m_action = orderType;

		order.m_orderType = OrderType.MKT.getApiString();

		order.m_totalQuantity = instruction.getQuantity();

		order.m_orderId = getUniqueId();

		return order;
	}

	public static Contract createContract(final Instruction instruction) {

		final Contract contract = new Contract();

		contract.m_exchange = instruction.getExchange();

		contract.m_symbol = instruction.getSymbol();

		contract.m_currency = instruction.getCurrency();

		contract.m_secType = instruction.getSecType();

		return contract;
	}

	public static OrderStatus getOrderStatus(String status) {

		for (final OrderStatus orderStatus : OrderStatus.values()) {
			if (orderStatus.toString().toLowerCase().equalsIgnoreCase(status))
				return orderStatus;
		}

		return null;
	}

	public static JsonObject getJsonObject(File file) {

		try {

			final String jsonString = FileUtils.readFileToString(file);

			return parseJsonStringToJsonObject(jsonString);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	public static JsonObject parseJsonStringToJsonObject(final String jsonString) {

		final JsonParser jsonParser = new JsonParser();

		return (JsonObject) jsonParser.parse(jsonString);
	}

}
