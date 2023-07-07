package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUtils {

	private static Logger Log = LogManager.getLogger();

	// Getting the value from config.property file
	// @Return: Value of passed key from config.properties file
	public static String getConfigProperty(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fstream = new FileInputStream("src//test//resources//configs//config.properties");
		prop.load(fstream);

		return prop.getProperty(key);
	}



}