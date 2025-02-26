package day3;
public interface SimpleInterest {
	public default double computeInterest(double principal, double rateOfInterest,
			double duration) {
		return principal * rateOfInterest * duration / 100;
	}
}
