package day3;

public class SimpleInterestImpl implements SimpleInterest{
	public static void main(String[] args) {
		SimpleInterest si = new SimpleInterestImpl();
		System.out.println(si.computeInterest(2000, 12, 3));
		
		SimpleInterest newSi = new SimpleInterest() {
			@Override
			public double computeInterest(double principal, double rateOfInterest, double duration) {
				return SimpleInterest.super.computeInterest(principal, rateOfInterest, duration);
			}
		};
		System.out.println(si.computeInterest(2000, 12, 3));
//		SimpleInterest lambdaSi = (p,r,d) -> p * d * r /100;
	}
}
