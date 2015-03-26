package paper2651.instruction;

import java.lang.reflect.Type;
import java.util.List;

import paper2651.algorithms.Algorithm;
import paper2651.algorithms.AlgorithmFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class InstructionManager {

	private static InstructionManager instructionReader;

	private List<Instruction> instructionList;

	public List<Instruction> readInstructionFromJsonString(String jsonString) {

		final Gson gson = new Gson();

		final Type listType = new TypeToken<List<Instruction>>() {
		}.getType();

		final JsonParser jsonParser = new JsonParser();

		final JsonObject jo = (JsonObject) jsonParser.parse(jsonString);

		final JsonArray instructionJsonArray = jo.getAsJsonArray("instruction");

		final List<Instruction> instructionList = gson.fromJson(
				instructionJsonArray.toString(), listType);

		this.instructionList = instructionList;

		for (final Instruction instruction : instructionList) {

			setBuyAlgorithm(instruction);

			setSellAlgorithm(instruction);
		}
		return instructionList;
	}

	private void setSellAlgorithm(final Instruction instruction) {

		final Algorithm sellAlgorithm = getAlgorithm(instruction
				.getSellAlgorithmName());

		instruction.setSellAlgorithm(sellAlgorithm);

		sellAlgorithm.setParentInstruction(instruction);
	}

	private void setBuyAlgorithm(final Instruction instruction) {

		final Algorithm buyAlgorithm = getAlgorithm(instruction
				.getBuyAlgorithmName());

		buyAlgorithm.setParentInstruction(instruction);

		instruction.setBuyAlgorithm(buyAlgorithm);
	}

	private Algorithm getAlgorithm(final String algorithmName) {

		return AlgorithmFactory.getAlgorithm(algorithmName);
	}

	public static InstructionManager getInstance() {
		if (instructionReader == null)
			instructionReader = new InstructionManager();
		return instructionReader;
	}

	public Instruction getInstructionByTickerId(final int tickerId) {

		if (instructionList != null) {
			for (Instruction instruction : instructionList) {
				if (instruction.getTickerId() == tickerId) {
					return instruction;
				}
			}
		}

		return null;
	}

	public Instruction getInstructionBySymbol(String symbol) {

		if (instructionList != null) {
			for (Instruction instruction : instructionList) {
				if (instruction.getSymbol().toLowerCase()
						.equalsIgnoreCase(symbol)) {
					return instruction;
				}
			}
		}

		return null;
	}

	public Instruction getInstructionByOrderId(final int orderId) {

		if (instructionList != null) {
			for (final Instruction instruction : instructionList) {
				if (instruction.isEnabled()) {
					final MyOrderStatus myOrderStatus = instruction
							.getMyOrderStatus();

					if (myOrderStatus.isExist(orderId))
						return instruction;

				}
			}
		}
		return null;
	}
}
