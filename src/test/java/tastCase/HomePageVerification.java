package tastCase;

import org.testng.annotations.Test;

import base.Base;

public class HomePageVerification extends Base {
	@Test
	public static void homePageVerification() {
		System.out.println("@Test Executed");
		//startUp();
		
		navigate("https://it.microtechlimited.com/index.html");
		
		assertion("//div/h1", "Welcome to MicroTech NA.");
		
		//System.out.println("Test is pass");
		
	}

}
