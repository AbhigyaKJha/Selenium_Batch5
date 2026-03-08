package com.w2a.Selenium_Master_Framework_5.listners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.Selenium_Master_Framework_5.utils.ExtentReportManager;
import com.w2a.Selenium_Master_Framework_5.utils.TestUtils;

public class CustomListners implements ITestListener {
	/*
	 * TODO: Add Reporting logs Add Screenshot capture on failure Add logs for test
	 * start, test pass, test failure, test skip in the HTML report Add logs for
	 * test start, test pass, test failure, test skip in the console
	 */
	@Parameters("browser")
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("**** Execution of Test Case: " + result.getName() + " Started ****");
		ExtentReportManager.createExtentTest(result.getName());
		String testStartMessage = "Execution of Test Case: " + result.getName() + " Started";
		Markup m = MarkupHelper.createLabel(testStartMessage, ExtentColor.BLUE);
		ExtentReportManager.getExtentTest().info(m);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("**** Test Case: " + result.getName() + " Passed ****");
		String testSuccessMessage = "Test Case: " + result.getName() + " Passed";
		Markup m = MarkupHelper.createLabel(testSuccessMessage, ExtentColor.GREEN);
		ExtentReportManager.getExtentTest().pass(m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//Capture Screenshot and attach to report
		
		System.out.println("**** Test Case: " + result.getName() + " Failure ****");
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String exceptionStackTrace = Arrays.toString(result.getThrowable().getStackTrace());

		// System.out.println(failedTestCaseInfo.getThrowable().getStackTrace().toString());
		ExtentReportManager.getExtentTest()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see the error details"
						+ "</font>" + "</b >" + "</summary>" + exceptionStackTrace.replaceAll(",", "<br>")
						+ "</details>" + " \n");
		
		ExtentReportManager.getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.screenshotPath+TestUtils.screenshotName).build());
		System.out.println(TestUtils.screenshotPath+TestUtils.screenshotName);
		String testFailureMessage = "Test Case: " + result.getName() + " Failed";
		Markup m = MarkupHelper.createLabel(testFailureMessage, ExtentColor.RED);
		ExtentReportManager.getExtentTest().fail(m);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("**** Test Case: " + result.getName() + " Skipped ****");
		String testSkippedMessage = "Test Case: " + result.getName() + " Skipped";
		Markup m = MarkupHelper.createLabel(testSkippedMessage, ExtentColor.ORANGE);
		ExtentReportManager.getExtentTest().skip(m);
	}
	
	@Override
	public void onFinish(ITestContext result) {
		ExtentReportManager.getExtentReport().flush();
	}

}
