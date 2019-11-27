package com.atmecs.php.config;

/**
 * Purpose :To maintain all path as constant for reusable
 * 
 * @author ranjitha.selvam
 *
 */

public class Constant {
	/**
	 * find element by specified time
	 * 
	 */
	public final static long element_wait = 30;
	public final static long polling_wait = 5;
	/**
	 * different browser drivers path
	 * 
	 */
	public static final String chromeDriver_path = "./drivers/chromedriver.exe";
	public static final String firefoxDriver_path = "./drivers/geckodriver.exe";
	public static final String internetDriver_path = "./drivers/IEDriverServer.exe";

	/**
	 * properties file
	 * 
	 */
	public static final String logProperties_path = "./log4j.properties";
	public static final String configFile_path = "./config.properties";

	/**
	 * Data base connection credentials
	 * 
	 */
	public static final String dbUrl = "jdbc:mysql://localhost:3306/demo";
	public static final String dbUserName = "root";
	public static final String dbPassword = "Selv@mm@lli.63";
	
	/** 
	 * Php travel website locators path
	 * 
	 */
	public static final String loginPageLoc_path="./src/test/resources/pageobject/loginpage.properties";
	public static final String homePageLoc_path="./src/test/resources/pageobject/homepage.properties";
	public static final String bookingStatusLoc_path="./src/test/resources/pageobject/bookingStatus.properties";
	
	/**
	 * php travel testdata path
	 */
    public static final String loginpageData_path="./src/test/resources/testdata/logincredential.properties";
    
}
