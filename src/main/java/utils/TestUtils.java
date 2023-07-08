package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUtils {

	private static Logger Log = LogManager.getLogger();

	/**
	 * Getting the value from config.property file
	 * 
	 * @Return: Value of passed key from config.properties file
	 **/
	public static String getConfigProperty(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fstream = new FileInputStream("src//test//resources//configs//config.properties");
		prop.load(fstream);

		return prop.getProperty(key);
	}

	/**
	 * Generate the score of percentage of matching two strings. If the percentage
	 * is more than 50% than it is return true otherwise false.
	 * @Return : Boolean > True in case of two string matching score is greater than
	 *         50 percentage other wise false
	 **/
	public static boolean checkStringsSimilarityScore(String guardianNews, String otherSourceNews) {
		boolean result = false;
		int count = 0;
		guardianNews = guardianNews.toLowerCase();
		otherSourceNews = otherSourceNews.toLowerCase();

		String[] otherSourceNewsWords = otherSourceNews.split("[\\s':-]+");
		for (String str : otherSourceNewsWords) {
			if (guardianNews.contains(str)) {
				count++;
				double score = (double) count / otherSourceNewsWords.length;
				Log.debug(score);
				if (score > 0.50) {
					result = true;
					break;
				} else {
					continue;
				}
			}
		}
		return result;
	}

	/**
	 * Get count of similar articles from other sources and match with expected count
	 * 
	 * @Return : Boolean : True in case matching expected count otherwise false
	 **/
	public static boolean checkOtherResoucesCountGreaterOrEqualTwo(int googleCount, int BBCCount, int expectedCount) {
		return googleCount >= expectedCount || BBCCount >= expectedCount;

	}

	// Screenshots

}