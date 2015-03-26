package paper2651.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import paper2651.algorithms.AlgorithmEnum;
import paper2651.utils.DataHelper;

import com.google.gson.JsonObject;

public class AlgorithmConfiguration {

	public static AlgorithmConfiguration instance;

	private List<JsonObject> algorithmList = new ArrayList<JsonObject>();

	private AlgorithmConfiguration(final List<File> configFiles) {

		for (final File configFile : configFiles) {
			algorithmList.add(DataHelper.getJsonObject(configFile));
		}
	}

	// Default configuration
	private AlgorithmConfiguration() {

		try {

			algorithmList.add(DataHelper.getJsonObject("PriceDifference.aconf"));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static AlgorithmConfiguration getInstance() {
		if (instance == null)
			instance = new AlgorithmConfiguration();

		return instance;
	}

	public static AlgorithmConfiguration getInstance(List<File> configFiles) {
		if (instance == null)
			instance = new AlgorithmConfiguration(configFiles);

		return instance;
	}

	public JsonObject getAlgorithmJsonObject(AlgorithmEnum algorithmEnum) {

		for (final JsonObject nextAlgorithmJsonObject : algorithmList) {

			if (nextAlgorithmJsonObject.get("name").getAsString()
					.equalsIgnoreCase(algorithmEnum.toString()))
				return nextAlgorithmJsonObject;

		}

		return null;
	}

}
