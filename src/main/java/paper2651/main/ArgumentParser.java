package paper2651.main;

import java.io.File;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ArgumentParser {

	private String filePath;

	private String appConfigPath = null;

	private List<File> algoConfigPath = null;

	private final Options options = new Options();

	final CommandLineParser parser = new BasicParser();


	public ArgumentParser() {
		options.addOption("i", "instruction", true, "Instruction file (*.json)");
		options.addOption("c", "appConfig", true,
				"Application configuration file (*.conf)");
		options.addOption("a", "algorithmConfig", true,
				"Algorithm configuration file (*.aconf)");
	}

	public void parse(String[] args) {

		try {
			final CommandLine cmd = parser.parse(options, args);

			if (cmd.hasOption("i")) {
				filePath = cmd.getOptionValue("i");
			} else if (cmd.hasOption("c")) {
				appConfigPath = cmd.getOptionValue("c");
			} else if (cmd.hasOption("a")) {
				appConfigPath = cmd.getOptionValue("a");
			} else {

			}

		} catch (ParseException e) {

		}
	}

	public String getFilePath() {
		return filePath;
	}

	public File getAppConfigPath() {
		return new File(appConfigPath);
	}

	public List<File> getAlgoConfigPath() {
		return algoConfigPath;
	}

	public void setAlgoConfigPath(List<File> algoConfigPath) {
		this.algoConfigPath = algoConfigPath;
	}

}
