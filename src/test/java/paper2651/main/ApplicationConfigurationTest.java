package paper2651.main;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import paper2651.algorithms.AlgorithmEnum;

import com.google.gson.JsonObject;

public class ApplicationConfigurationTest {

	private ApplicationConfiguration configurationManager;

	@Before
	public void setUp() throws Exception {
		configurationManager = ApplicationConfiguration.getInstance();
	}

	@Test
	public void testGetAppConfig() {

		final JsonObject appConfig = configurationManager.getJsonObject();

		String clientId = appConfig.get("clientId").getAsString().toLowerCase();

		assertTrue(clientId.equalsIgnoreCase("du203765"));
	}

}
