package paper2651.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import paper2651.algorithms.AlgorithmEnum;
import paper2651.utils.DataHelper;

import com.google.gson.JsonObject;

public class ApplicationConfiguration {

	public static ApplicationConfiguration instance;

	private JsonObject appConfig;

	private List<JsonObject> algorithmList = new ArrayList<JsonObject>();

	private ApplicationConfiguration(final File configFile) {

		this.appConfig = DataHelper.getJsonObject(configFile);

	}

	// Default configuration
	private ApplicationConfiguration() {

		try {

			this.appConfig = DataHelper
					.getJsonObject("AppConfig.conf");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static ApplicationConfiguration getInstance() {
		if (instance == null)
			instance = new ApplicationConfiguration();

		return instance;
	}

	public static ApplicationConfiguration getInstance(File configFile) {
		if (instance == null)
			instance = new ApplicationConfiguration(configFile);

		return instance;
	}

	public JsonObject getJsonObject() {
		return appConfig;
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
