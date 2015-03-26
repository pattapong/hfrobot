package paper2651.algorithms;

public class AlgorithmFactory {

//test
	public static Algorithm getAlgorithm(AlgorithmEnum algorithmEnum) {

		if (algorithmEnum.equals(AlgorithmEnum.PriceDifference))
			return new PriceDifference();

		return null;
	}

	public static Algorithm getAlgorithm(String algorithmName) {
		final AlgorithmEnum algorithmEnum = AlgorithmEnum
				.getEnum(algorithmName);

		return getAlgorithm(algorithmEnum);
	}
}
