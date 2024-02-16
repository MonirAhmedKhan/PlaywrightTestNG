package tastCase;

import org.testng.annotations.Test;

import base.Base;

public class Multiple_TestCase_Run extends Base {
	// TestNG all test case run alphabetical order
	//Q: How you can prioritized Test inside same Class?
	//Ans: We can define number as priority attribute value inside the Annotation.
	
	// Test Customer Login
	@Test//(priority = 1)
	public static void atest_Customer_Login() {
		System.out.println("Test 1");
		navigate("https://it.microtechlimited.com");

		click("//a[@href='elogin.php']");

		click("//a[@href='clogin.php']");

		fill("//input[@name='mailuid']", "david@gmail.com");

		fill("//input[@name='pwd']", "1234");

		click("//input[@name='login-submit']");

		String welcomeMessage = innerText("//h2[2]");
		System.out.println(welcomeMessage);
		
		assertion("//*[@id='divimg']/div/h2[2]", "Welcome David");
	}

	// Test Customer
	@Test//(priority = 2)
	public static void btest_Customer() {
		System.out.println("Test 2");
		navigate("https://it.microtechlimited.com");

		click("//a[@href='elogin.php']");

		click("//a[@href='clogin.php']");

		fill("//input[@name='mailuid']", "david@gmail.com");

		fill("//input[@name='pwd']", "1234");

		click("//input[@name='login-submit']");

		String welcomeMessage = innerText("//h2[2]");
		System.out.println(welcomeMessage);
	
		assertion("//*[@id='divimg']/div/h2[2]", "Welcome David");
	}

}
