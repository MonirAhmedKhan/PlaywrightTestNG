package dataProvid;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameteization {

	@DataProvider(name = "allData")
	public Object[][] getData(Method m) {

		Object[][] data = null;
		if (m.getName().equals("test_Employee_Login")) {

			data = new Object[1][2];
			data[0][0] = "testpilot@gmail.com";
			data[0][1] = "1234";

//		data[1][0] = "test@gmail.com";
//		data[1][1] = "123456";
		} else if (m.getName().equals("test_Customer_Login")) {
			data = new Object[1][2];
			data[0][0] = "david@gmail.com";
			data[0][1] = "1234";

		}

		return data;

	}
}
