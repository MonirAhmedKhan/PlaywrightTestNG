 package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;

public class Assertion_Hard_Soft extends Base {
	// Instantiate SoftAssert class
	public static SoftAssert softAssert = new SoftAssert();
	@Test
	public static void test_softFail_softPass() {
		softAssert.assertEquals("a", "a");
		System.out.println("softAssert1.assertEquals(a, a)");

		softAssert.assertEquals("a", "b");
		System.out.println("softAssert1.assertEquals(a, b)");

		softAssert.assertAll();
	}
	
	@Test
	public static void test_Employee_Login() {

		Assert.assertEquals("same", "same");
		System.out.println("Assert.assertEquals(same, same)");

		softAssert.assertEquals("a", "a");
		System.out.println("softAssert1.assertEquals(a, a)");

		softAssert.assertAll();
	}

}
