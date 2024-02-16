package beforeGroup_Sapurt;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class GroupTest extends BaseGroup {
	@Test(groups="regression")
	public static void homePageVerification() {
		System.out.println("GroupTest-1 Executed");

		navigate("https://it.microtechlimited.com/index.html");

		assertion("//h1[text()='Welcome to MicroTech NA.']", "Welcome to MicroTech NA.");

		System.out.println("Test is pass");

	}

	@Test(groups="regression")
	public static void test_Customer_Login() {

		System.out.println("GroupTest-1 Executed");

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

	@Test(groups="group-2")
	public static void test_Employee_Login() {
		System.out.println("Grou Test-2 Executed");

		navigate("https://it.microtechlimited.com");

		click("//a[@href='elogin.php']");

		fill("//input[@name='mailuid']", "testpilot@gmail.com");

		fill("//input[@name='pwd']", "1234");

		click("//input[@name='login-submit']");

		// Assertion EMP Id
		String employeeId = innerText("//h2[1]");
		Assert.assertEquals(employeeId, "Employee Id: 102");
		System.out.println(employeeId);

		// Assertion Welcome Test
		String welcomeTest = page.textContent("//h2[@style='text-align:center;']");
		Assert.assertEquals(welcomeTest, "Welcome Test ");
		System.out.println(welcomeTest);

	}

	@Test(groups="group-2")
	public static void test_Create_Order() {
		System.out.println("Grou Test-2 ");

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
