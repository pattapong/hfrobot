package paper2651.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import paper2651.ibCommand.IbCommand;
import paper2651.ibCommand.IbCommandEnum;
import paper2651.ibCommand.IbCommandFactory;
import paper2651.ibCommand.IbCommandManager;
import paper2651.instruction.Instruction;
import paper2651.instruction.InstructionManager;

import com.google.gson.JsonObject;
import com.ib.client.EClientSocket;

public class TradeExecutor {

	private static JsonObject appConfig;

	public static void main(String[] args) throws InterruptedException,
			IOException {

		final ArgumentParser argumentParser = new ArgumentParser();

		argumentParser.parse(args);

		final File file = new File(argumentParser.getFilePath());

		final String jsonString = FileUtils.readFileToString(file);

		final List<Instruction> instructionList = InstructionManager
				.getInstance().readInstructionFromJsonString(jsonString);

		if (argumentParser.getAppConfigPath() != null)
			appConfig = ApplicationConfiguration.getInstance(
					argumentParser.getAppConfigPath()).getJsonObject();

		if (argumentParser.getAlgoConfigPath() != null)
			AlgorithmConfiguration.getInstance(argumentParser
					.getAlgoConfigPath());

		final IbCommandManager ibCommandManager = IbCommandManager
				.getInstance();

		final EClientSocket clientSocket = ibCommandManager.getClientSocket();

		if (clientSocket.isConnected())

		{
			System.out.println("Connected");

			Thread.sleep(5000);

			startRequestMarketData(instructionList);

			startGetPositionThreadEveryXseconds();

			startGetOpenOrderEveryXseconds();

			// requestFundamentalData(instructionList);

		} else
			System.out.println("Failed connection");

	}

	private static void requestFundamentalData(
			final List<Instruction> instructionList) {
		for (final Instruction instruction : instructionList) {

			if (instruction.isEnabled()) {
				final IbCommand ibCommand = IbCommandFactory
						.getIbCommand(IbCommandEnum.RequestFundamentalData);
				ibCommand.execute(instruction);
			}
		}
	}

	private static void startGetOpenOrderEveryXseconds() {
		// Update current position every x seconds
		System.out.println("Get open orders");

		int waitTime = appConfig.get("RequestOpenOrderInterval").getAsInt();

		final GetCurrentOpenOrderThread getCurrentOpenOrderThread = new GetCurrentOpenOrderThread(
				waitTime);

		getCurrentOpenOrderThread.start();
	}

	private static void startGetPositionThreadEveryXseconds() {

		// Update current position every x seconds
		System.out.println("Get current position");

		int waitTime = appConfig.get("RequestPositionInveral").getAsInt();

		final GetCurrentPositionThread getCurrentPositionThread = new GetCurrentPositionThread(
				waitTime);

		getCurrentPositionThread.start();
	}

	private static void startRequestMarketData(
			final List<Instruction> instructionList) {

		// Start getting market data
		System.out.println("Start");

		for (final Instruction instruction : instructionList) {

			if (instruction.isEnabled()) {
				final IbCommand ibCommand = IbCommandFactory
						.getIbCommand(IbCommandEnum.RequestMarketData);
				ibCommand.execute(instruction);
			}
		}
	}
}
