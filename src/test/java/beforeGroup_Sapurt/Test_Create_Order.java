package beforeGroup_Sapurt;

import org.testng.annotations.Test;

import base.Base;

public class Test_Create_Order extends BaseGroup{
	@Test
	public static void test_Create_Order() {

		System.out.println("test_Create_Order");

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

		//close();
	}

}
