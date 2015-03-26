package paper2651.algorithms;

public enum AlgorithmEnum {
	PriceDifference;

	public static AlgorithmEnum getEnum(final String algorithmClass) {
		
		if (algorithmClass.equalsIgnoreCase(PriceDifference.toString().toLowerCase()))
			return PriceDifference;
		
		return null;
	}

}
