package com.w2a.Selenium_Master_Framework_5.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserOptions {
	
	/*
	 * 
	 * 
	 * This class is responsible for handling browser options and capabilities for different browsers
	 * 
	 */
	
	
	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", chromePrefs);
		return options;
	}

}
