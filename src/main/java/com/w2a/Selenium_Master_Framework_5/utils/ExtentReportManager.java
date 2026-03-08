package com.w2a.Selenium_Master_Framework_5.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.w2a.Selenium_Master_Framework_5.testSetUp.TestSetup;

public class ExtentReportManager extends TestSetup{

	private static ExtentSparkReporter sparkReporter;
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	public synchronized static ExtentReports initializeExtentReport()
	{
		sparkReporter= new ExtentSparkReporter(ApplicationConstants.TEST_REPORT_PATH+ApplicationConstants.TEST_REPORT_NAME);
		sparkReporter.config().setReportName("Automation Test Results");
		sparkReporter.config().setDocumentTitle("Test Results");
		sparkReporter.config().setEncoding("utf-8");//
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		System.out.println("**** Extent Report Object Created ****"+extent);
		return extent;
		
	}
	
	public static ExtentReports getExtentReport()
	{
		return ExtentReportManager.extent;
	}
	
	public synchronized static void createExtentTest(String testCaseName)
	{
		//ExtentReportManager.test=ExtentReportManager.getExtentReport().createTest(testCaseName);
		ExtentReportManager.setExtentTest(ExtentReportManager.getExtentReport().createTest(testCaseName));
	}
	
	public static ExtentTest getExtentTest()
	{
		return ExtentReportManager.test.get();
	}
	public static void setExtentTest(ExtentTest extentTest)
	{
		 ExtentReportManager.test.set(extentTest);
	}
}
