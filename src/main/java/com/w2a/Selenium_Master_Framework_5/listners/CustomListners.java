package com.w2a.Selenium_Master_Framework_5.listners;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class CustomListners implements ITestListener{
	/*
	 * TODO:
	 * Add Reporting logs
	 * Add Screenshot capture on failure
	 * Add logs for test start, test pass, test failure, test skip in the HTML report
	 * Add logs for test start, test pass, test failure, test skip in the console
	 */
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("**** Execution of Test Case: " + result.getName() + " Started ****");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("**** Test Case: " + result.getName() + " Passed ****");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("**** Test Case: " + result.getName() + " Failure ****");
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("**** Test Case: " + result.getName() + " Skipped ****");
	}
	
	
	

}
