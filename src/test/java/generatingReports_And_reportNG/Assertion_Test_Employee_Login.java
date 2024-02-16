package generatingReports_And_reportNG;

import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import base.Base;

@Listeners(generatingReports_And_reportNG.ListenersClassReportNG.class)

public class Assertion_Test_Employee_Login extends Base {
	// Instantiate SoftAssert class
	public static SoftAssert softAssert = new SoftAssert();

	@Test
	public static void homePageVerification() {

		navigate("https://it.microtechlimited.com");

		assertion("//div/h1", "Welcome to MicroTech NA.");

	}

	@Test
	public static void test_Customer_Login() {
		// Assert.fail();
		navigate("https://it.microtechlimited.com");

		click("//a[@href='elogin.php']");

		click("//a[@href='clogin.php']");

		fill("//input[@name='mailuid']", "david@gmail.com");

		fill("//input[@name='pwd']", "1234");

		click("//input[@name='login-submit']");

		String welcomeMessage = innerText("//h2[2]");
		System.out.println(welcomeMessage);
		assertion("//*[@id='divimg']/div/h2[2]", "Welcome Davidd");

		// Skied This test
		// throw new SkipException("Skiping This Test");

	}

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
		String actual = "Employee Id: 1022";
		softAssert.assertEquals(actual, expected);

		if (expected.contains(actual)) {
			System.out.println("Test is pass");
		} else
			System.out.println("Test is fail");

		// Assertion Welcome Test
		// Hard Assertion
		String welcomeTest = page.textContent("//h2[@style='text-align:center;']");
		Assert.assertEquals(welcomeTest, "Welcome Test ");
		System.out.println(welcomeTest);

		softAssert.assertAll();
	}

	@Test
	public static void test_Create_Order() {

		navigate("https://it.microtechlimited.com");

		click("//a[@href='elogin.php']");

		fill("//input[@name='mailuid']", "testpilot@gmail.com");

		fill("//input[@name='pwd']", "1234");

		click("//input[@name='login-submit']");

		click("//a[text()='Product Order']");

		selectOption("//select[@name='prodId']", "Camera");

		fill("//input[@name='ordDate']", "11/21/2023");

		click("//button[@type='submit']");

		System.out.println("Order Done");

	}
	
}
