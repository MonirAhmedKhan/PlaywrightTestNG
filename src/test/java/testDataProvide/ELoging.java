package testDataProvide;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.Base;

public class ELoging extends Base {
	@Test(dataProviderClass = TestParameteizationBasic.class,dataProvider ="allData")
	public static void test_Employee_Login(String eID,String ePass,String url) {

		navigate(url);

		click("//a[@href='elogin.php']");

		fill("//input[@name='mailuid']", eID);

		fill("//input[@name='pwd']", ePass);

		click("//input[@name='login-submit']");

		String employeeId = innerText("//h2[1]");
		Assert.assertEquals(employeeId, "Employee Id: 102");
		System.out.println(employeeId);

		String welcomeTest = page.textContent("//h2[@style='text-align:center;']");
		Assert.assertEquals(welcomeTest, "Welcome Test ");
		System.out.println(welcomeTest);

	}

}
