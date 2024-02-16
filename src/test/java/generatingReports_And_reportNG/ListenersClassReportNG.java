package generatingReports_And_reportNG;

import java.nio.file.Paths;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import base.Base;

public class ListenersClassReportNG extends Base implements ITestListener {
	// implements ITestListener

	// Declare Browser
	public static Browser browser;

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case is Starting :-" + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case is pass:-" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case is failed  :-" + result.getName());
		
		// add link screenshot image
		Reporter.log("<a href=\"C:\\Java\\PlayWright_In_Java\\class_26TestNG_Basic\\test_Customer_Login_failur.png\">Screenshot link</a>");
		// new tab
		Reporter.log("<a href=\"C:\\Java\\PlayWright_In_Java\\class_26TestNG_Basic\\test_Employee_Login_failur.png\"target =\"_blank\">Screenshot link</a>");
		// new line
		Reporter.log("<br>");
		// add screenshot reports
		Reporter.log("<a href=\"C:\\Java\\PlayWright_In_Java\\class_26TestNG_Basic\\test_Customer_Login_failur.png\"target =\"_blank\"><img height =200 width = 200 src=\"C:\\Java\\PlayWright_In_Java\\class_26TestNG_Basic\\test_Customer_Login_failur.png\"></a>");
		Reporter.log("<br>");
		Reporter.log("<a href=\"C:\\Java\\PlayWright_In_Java\\class_26TestNG_Basic\\test_Employee_Login_failur.png\"target =\"_blank\"><img height =200 width = 200 src=\"C:\\Java\\PlayWright_In_Java\\class_26TestNG_Basic\\test_Employee_Login_failur.png\"></a>");
		
		// Call Screenshot
		captureScreenshot(result.getMethod().getMethodName() + "_failur.png");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case is Skipped :-" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
