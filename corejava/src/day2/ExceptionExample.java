package day2;

public class ExceptionExample {

	public static void main(String[] args) {
		Authenticator auth = new Authenticator();
		
		try {
			long code  = auth.authenticate("scott", "tiger");
			System.out.println("Auth code = "+code);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
		finally {
			System.out.println("It will always execute");
		}
	}
}
