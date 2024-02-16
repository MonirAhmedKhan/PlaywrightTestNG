package testDataProvide;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;

public class TestParameteizationBasic extends Base {

	@DataProvider(name = "allData")
	public Object[][] getData(Method d) {

		Object[][] data = null;
		if (d.getName().equals("test_Customer_Login")) {
			data = new Object[1][3];
			data[0][0] = "david@gmail.com";
			data[0][1] = "1234";
			data[0][2] = "https://it.microtechlimited.com";
			
		} else if (d.getName().equals("test_Employee_Login")) {

			data = new Object[1][3];
			data[0][0] = "testpilot@gmail.com";
			data[0][1] = "1234";
			data[0][2] = "https://it.microtechlimited.com";

		}
		return data;

	}
}
