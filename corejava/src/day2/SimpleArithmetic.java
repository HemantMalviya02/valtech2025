package day2;

public class SimpleArithmetic implements Arithmetic {

	@Override
	public double add(double a, double b) {
		return a+b;

	}

	@Override
	public double sub(double a, double b) {
		return a-b;

	}

	@Override
	public double mult(double a, double b) {
		return a*b;

	}

	@Override
	public double div(double a, double b) {
		return a/b;

	}
	
	
	public static void main(String[] args) {
		SimpleArithmetic obj = new SimpleArithmetic();
		System.out.println(obj.add(10,20));
		System.out.println(obj.sub(10, 20));
		System.out.println(obj.mult(10,20));
		System.out.println(obj.div(10, 20));
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}

}
