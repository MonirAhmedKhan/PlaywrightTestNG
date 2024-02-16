package test_Dependencies;

import org.testng.annotations.Test;

import base.Base;

public class CreatingTest extends Base {
// Depend on others Method 
	// Hard dependencies
	// Soft dependencies

	@Test
	public void testCase_1() {
		// Assert.fail();
		navigate("https://it.microtechlimited.com/index.html");
		assertion("//div/h1", "Welcome to MicroTech NA.");
		System.out.println("Test is pass");
	}

	@Test
	public void testCase_2() {

		System.out.println("Executing Test_2");

	}

	@Test
	public void testCase_3() {
		System.out.println("Executing Test_3");
	}

	@Test
	public void testCase_4() {
		System.out.println("Executing Test_4");
	}
}
