package testDataProvide;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import dataProvid.TestParameteization;

public class CLoging extends Base {
	@Test(dataProviderClass = TestParameteizationBasic.class, dataProvider = "allData")
	// @Test(dataProviderClass = --.class,dataProvider ="--")
	public static void test_Customer_Login(String id, String pass) {

		navigate("https://it.microtechlimited.com");

		click("//a[@href='elogin.php']");

		click("//a[@href='clogin.php']");

		fill("//input[@name='mailuid']", id);

		fill("//input[@name='pwd']", pass);

		click("//input[@name='login-submit']");

		String welcomeMessage = innerText("//h2[2]");

		System.out.println(welcomeMessage);

		assertion("//*[@id='divimg']/div/h2[2]", "Welcome David");

	}

}
