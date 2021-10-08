package commons;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class GenerateReport implements ITestListener {

	@Override
	public void onStart(ITestContext arg0) {

		System.out.println("Lucy.Begin test: " + arg0.getName());

	}

	@Override
	public void onTestStart(ITestResult arg0) {

		System.out.println("Lucy.Starting test: " + arg0.getName());

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {

		System.out.println(" Lucy Test passed: " + arg0.getName());

	}

	@Override
	public void onTestFailure(ITestResult arg0) {

		System.out.println(" Lucy Test failed: " + arg0.getName());

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

		System.out.println(" Lucy Test ignored: " + arg0.getName());

	}

	@Override
	public void onFinish(ITestContext arg0) {

		System.out.println("-Lucy End test: " + arg0.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

		// TODO Auto-generated method stub

	}

}
