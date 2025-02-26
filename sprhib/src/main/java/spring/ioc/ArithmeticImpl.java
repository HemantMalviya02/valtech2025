package spring.ioc;

public class ArithmeticImpl implements Arithmetic {
	
	@Override
	public int add(int a, int b) {
		System.out.println("Add A = "+a+" B = "+b);
		return a+b;
	}
	@Override
	public int sub(int a, int b) {
		System.out.println("Sub A = "+a+" B = "+b);
		return a-b;
	}
	@Override
	public int mul(int a, int b) {
		System.out.println("Mul A = "+a+" B = "+b);
		return a*b;
	}
	@Override
	public int div(int a, int b) {
		System.out.println("Div A = "+a+" B = "+b);
		return a/b;
	}
}
