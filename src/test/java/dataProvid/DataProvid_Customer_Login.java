package dataProvid;

import org.testng.annotations.Test;

import base.Base;

//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DataProvid_Customer_Login extends Base {

	// Login as Customer
	@Test(dataProviderClass = TestParameteization.class,dataProvider = "allData" )
	public static void test_Customer_Login(String userId ,String passWord) {

	//	startUp();

		navigate("https://it.microtechlimited.com");

		click("//a[@href='elogin.php']");

		click("//a[@href='clogin.php']");

		fill("//input[@name='mailuid']", userId);

		fill("//input[@name='pwd']", passWord);

		click("//input[@name='login-submit']");

		String welcomeMessage = innerText("//h2[2]");

		System.out.println(welcomeMessage);
		// assertThat(page.locator("body > div.fw-container > div.fw-body > div >
		// h1")).hasText("Installation");
		assertion("//*[@id='divimg']/div/h2[2]", "Welcome David");
		
		//close();
	}

}
