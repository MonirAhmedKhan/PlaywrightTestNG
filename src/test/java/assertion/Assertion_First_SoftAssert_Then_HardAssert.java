 package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;

public class Assertion_First_SoftAssert_Then_HardAssert extends Base {
	// Instantiate SoftAssert class
	public static SoftAssert softAssert = new SoftAssert();

	@Test
	public static void test_Employee_Login() {

		navigate("https://it.microtechlimited.com");

		click("//a[@href='elogin.php']");

		fill("//input[@name='mailuid']", "testpilot@gmail.com");

		fill("//input[@name='pwd']", "1234");

		click("//input[@name='login-submit']");

		// Assertion EMP Id
		// Soft assertion
		String expected = innerText("//h2[1]");
		String actual = "Employee Id: 102";
		softAssert.assertEquals(actual, expected);
		if (expected.contains(actual)) {
			System.out.println("Test is pass");
		} else
			System.out.println("Test is fail");
		softAssert.assertEquals(actual, "failed");
		System.out.println("second assertion fail");
		// Assertion Welcome Test
		// Hard Assertion
		String welcomeTest = page.textContent("//h2[@style='text-align:center;']");
		//Assert.assertEquals(welcomeTest, "Welcome Test ");
		System.out.println(welcomeTest);

		softAssert.assertAll();
	}

}
