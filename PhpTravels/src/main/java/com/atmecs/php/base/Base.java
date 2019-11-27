package com.atmecs.php.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.atmecs.php.config.Constant;
import com.atmecs.php.utils.Utils;

/**
 * Different browser setup to run the script in different different browser.
 * 
 * @author ranjitha.selvam
 *
 */

public class Base {
	
	public WebDriver driver;
	public Utils utils = new Utils();

	/**
	 * Different browser setup(Chrome,Firefox,Internetexplorer)
	 * 
	 */

	public void getBrowser(String browserType) {
		try {
			//String browserType = utils.propertyRead(Constant.configFile_path, "browserName");
			if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constant.chromeDriver_path);
				driver = new ChromeDriver();
			} else if (browserType.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", Constant.firefoxDriver_path);
				driver = new FirefoxDriver();
			} else if (browserType.equalsIgnoreCase("internetExplorer")) {
				System.setProperty("webdriver.ie.driver", Constant.internetDriver_path);
				driver = new InternetExplorerDriver();
			}

			driver.manage().window().maximize();
		} catch (Exception e)

		{
			e.printStackTrace();
		}
	}

	/**
	 * Get url from property file.
	 * 
	 */
	public void getUrl(String url) {
		try {
			//String url = utils.propertyRead(Constant.configFile_path, "url");
			driver.get(url);
			// String BaseURL= System.getProperty("customproperty");
			// driver.get(BaseURL);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Close the current browse
	 * 
	 */
	public void driverClose() {
		try {
			driver.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
