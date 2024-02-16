package tastCase;

import org.testng.annotations.Test;

import base.Base;
import dataProvid.DataProviderClass;

public class C_Loging extends Base{
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "empData")
	public static void test_Customer_Login(String userId, String PassWord) {

		// startUp();

		navigate("https://it.microtechlimited.com");

		click("//a[@href='elogin.php']");

		click("//a[@href='clogin.php']");

		fill("//input[@name='mailuid']", userId);

		fill("//input[@name='pwd']", PassWord);

		click("//input[@name='login-submit']");

		String welcomeMessage = innerText("//h2[2]");

		System.out.println(welcomeMessage);
		// assertThat(page.locator("body > div.fw-container > div.fw-body > div >
		// h1")).hasText("Installation");
		assertion("//*[@id='divimg']/div/h2[2]", "Welcome David");

		// close();
	}
}
