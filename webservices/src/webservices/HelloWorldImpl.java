package webservices;

public class HelloWorldImpl implements HelloWorld{

	@Override
	public String hello(String name) {
		return "Hello World!"+ name;
	}

}
