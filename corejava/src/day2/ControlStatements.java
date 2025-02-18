package day2;

public class ControlStatements {
	public void testIfElse(int a) {
		if(a%2 == 0 ) {
			System.out.println("A = "+a+" is even...");
		}
		else 
			System.out.println("A = "+a+" is odd...");
	}
	
	public void testfor(int [] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void testSwitch(int a) {
		switch (a) {
			case 1:
				System.out.println("One");
				break;
			case 2:
				System.out.println("Two");
				break;
			case 3:
				System.out.println("Three");
				break;
			default:
				System.out.println("All Others");
		}
	}
	
	public int add(int iv, int... a) {
//		whereas should be the last argument
		int sum=iv;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		System.out.println("Sum is" +sum);
		return sum;	
	}
	
	public static void main(String[] args) {
		ControlStatements cs = new ControlStatements();
		cs.testIfElse(3);
		cs.testIfElse(4);
		cs.testIfElse(5);
		cs.testIfElse(-1);
		
		cs.testfor(new int[] {1,2,3});
		cs.testfor(new int[] {1,2,3,4,5});
		
		cs.testSwitch(3);
		
		cs.add(0);
		cs.add(1,2);
		cs.add(1,2,3);
		cs.add(1,2,3,4,5,6);
		
	}
}
