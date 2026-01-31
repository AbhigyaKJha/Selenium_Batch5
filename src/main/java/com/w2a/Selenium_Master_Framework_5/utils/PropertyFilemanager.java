package com.w2a.Selenium_Master_Framework_5.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilemanager {
	/*
	 * This class is responsible for managing property files for different
	 * environments
	 */

	private static Properties props;
	private static FileInputStream fis;

	public static  Properties initializePropertyFile() {
		props = new Properties();
		try {
			fis = new FileInputStream(
					ApplicationConstants.CONFIG_PROPERTY_FILE_PATH + ApplicationConstants.QA_PROPERTY_FILE_NAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			props.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return props;

	}

}
