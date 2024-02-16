 package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;

public class Assertion_First_HardAssert_Then_SoftAssert extends Base {
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
		Assert.assertEquals(actual, expected);
		if (expected.contains(actual)) {
			System.out.println("Test is pass");
		} else
			System.out.println("Test is fail");

		// Assertion Welcome Test
		// Hard Assertion
		String welcomeTest = page.textContent("//h2[@style='text-align:center;']");
		softAssert.assertEquals(welcomeTest, "Welcome Test ");
		System.out.println(welcomeTest);

		softAssert.assertAll();
	}

}
