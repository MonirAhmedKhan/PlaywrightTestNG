package test_Dependencies;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.Base;

public class CreatingTest_dependencies extends Base {
// Depend on others Method 
	// Hard dependencies
	// Soft dependencies

	@Test(priority = 1)
	public void testCase_1() {
		// Assert.fail();
		navigate("https://it.microtechlimited.com/index.html");
		assertion("//div/h1", "Welcome to MicroTech NA..");
		System.out.println("Test is pass");
	}

	@Test(priority = 2, dependsOnMethods = "testCase_1", alwaysRun = true)
	public void testCase_2() {

		System.out.println("Executing Test_2");

	}

	@Test(priority = 3, dependsOnMethods = "testCase_1", alwaysRun = false)
	public void testCase_3() {
		System.out.println("Executing Test_3");
	}

	@Test(priority = 4, dependsOnMethods = "testCase_1", alwaysRun = true)
	public void testCase_4() {
		System.out.println("Executing Test_4");
	}
}
