package testPackage;


public class MyResource implements AutoCloseable {

	@Override
	public void close() throws ClassCastException {
		System.out.println("JVM closes my resource");
	}
	
	public String getString() {
		return "Hello World!";
	}
}

