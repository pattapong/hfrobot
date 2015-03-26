package paper2651.instruction;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import paper2651.utils.DataHelper;

public class InstructionReaderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadInstructionFromJsonString() {

		try {

			final String jsonString = DataHelper.getJsonString(
					"instruction.json");

			final List<Instruction> instructionList = InstructionManager
					.getInstance().readInstructionFromJsonString(jsonString);

			assertTrue(instructionList.get(0).getSymbol()
					.equalsIgnoreCase("td"));
			assertTrue(instructionList.get(0).getExchange()
					.equalsIgnoreCase("tse"));
			assertTrue(instructionList.get(0).getTargetPosition() == 100);

		} catch (IOException e) {
			fail("Failed");

		}

	}

}
