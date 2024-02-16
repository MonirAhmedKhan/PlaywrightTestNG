package dataProvid;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;

public class TestParameteizationBasic extends Base{
	@Test(dataProvider = "getData")
	public void doLoging(String a, String b) {
		System.out.println("Data Provider "+a + "---" + b);
		navigate("https://it.microtechlimited.com");


	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[3][2];
		data[0][0] = "david@gmail.com";
		data[0][1] = "1234";
		
		data[1][0] = "testpilot@gmail.com";
		data[1][1] = "1234";
		
		data[2][0] = "test@gmail.com";
		data[2][1] = "123456";

		return data;

	}
}
