package listeners;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenersClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case is Starting :-" + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case is pass:-" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case is failed  :-" + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case is Skipped :-"+result.getName());
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
