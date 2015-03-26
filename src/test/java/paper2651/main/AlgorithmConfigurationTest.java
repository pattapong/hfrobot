package paper2651.main;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import paper2651.algorithms.AlgorithmEnum;

import com.google.gson.JsonObject;

public class AlgorithmConfigurationTest {

	private AlgorithmConfiguration algorithmConfiguration;

	@Before
	public void setUp() throws Exception {
		algorithmConfiguration = AlgorithmConfiguration.getInstance();
	}

	@Test
	public void testGetAlgorithmPriceDifferenceJson(){
		
		final JsonObject algoConfig = algorithmConfiguration.getAlgorithmJsonObject(AlgorithmEnum.PriceDifference);

		String clientId = algoConfig.get("priceDifferenceForBuy").getAsString().toLowerCase();

		assertTrue(clientId.equalsIgnoreCase("0.04"));
	}
}
