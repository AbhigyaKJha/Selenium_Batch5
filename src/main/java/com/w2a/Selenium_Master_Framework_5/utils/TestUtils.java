package com.w2a.Selenium_Master_Framework_5.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtils {
	public static String screenshotPath;
	public static String screenshotName;
	
	public static void captureScreenshot() throws IOException
	{
		System.out.println("**** Capturing Screenshot ****");
		screenshotPath=ApplicationConstants.SCREENSHOT_PATH;
		
		TakesScreenshot ts= (TakesScreenshot) DriverManager.getDriver();
		File sourceFile= ts.getScreenshotAs(OutputType.FILE);
		Date d= new Date();
		screenshotName= d.toString().replace(":", "_").replace(" ", "_")+".png";
		FileUtils.copyFile(sourceFile, new File(screenshotPath+screenshotName));
		
		// TODO : add code to capture screenshot and save it to the specified location
		
	}

}
