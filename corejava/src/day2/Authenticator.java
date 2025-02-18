package day2;

import java.util.Random;

public class Authenticator {
	public long authenticate(String name, String pass)throws Exception {
		if("scott".equals(name) && "tiger".equals(pass)) {
			return new Random().nextLong();
		}
		throw new Exception("Only Scott is allowed");
	}
}
