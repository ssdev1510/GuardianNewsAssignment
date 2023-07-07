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

	// Check the score of two strings how much it matches. If the percentage is more
	// than 30% than it is return true otherwise false
	// @Return : Boolean > True in case of two string matching score is greater than
	// 30 other wise false
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

	// Get number of similar articles from other sources
	// @Return : integer > number of articles
	public static boolean checkOtherResoucesCountGreaterOrEqualTwo(int googleCount, int BBCCount, int expectedCouunt) {
		return googleCount >= expectedCouunt || BBCCount >= expectedCouunt;

	}

	// Screenshots

}