package com.atmecs.php.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.dateAndTime.DateAndTime;
import com.atmecs.php.base.Base;
import com.atmecs.php.config.Constant;
import com.atmecs.php.helper.Helper;
import com.atmecs.php.helper.Waits;
import com.atmecs.php.report.Report;

public class AutomatingPhp extends Base {
	
	public Helper helper = new Helper();
	public Waits waits = new Waits();
	public Report report = new Report();
	public DateAndTime dat=new DateAndTime();

	

	@BeforeClass
	public void browserLaunch() {
		report.logInfo("#Step 1: Browser opening");
		getBrowser(utils.propertyRead(Constant.configFile_path, "browserName"));
		report.logInfo("#Step 2: Entering  url");
		getUrl(utils.propertyRead(Constant.configFile_path, "url"));
		//getUrl();

	}
	@Test(priority=1)
	public void loginIntoApplication() throws InterruptedException
	{   waits.implicitlyWait(driver);
		helper.inputValuesToTheWebelement(driver,Constant.loginPageLoc_path,"loc_email","user@phptravels.com ");
		helper.inputValuesToTheWebelement(driver,Constant.loginPageLoc_path,"loc_pwd" , "demouser");
		helper.clickOnWebElement(driver,Constant.loginPageLoc_path,"loc_login");
		Thread.sleep(2000);
		
	}
	@Test(priority=2)
	public void validatingAccountPage() throws Exception
	{
		waits.implicitlyWait(driver);
		String text = helper.getText(driver,Constant.homePageLoc_path,"loc_hiDemoUser");
		helper.pageValidation(text,utils.propertyRead(Constant.loginpageData_path,"homepagetext"));
		Thread.sleep(3000);
		String text2 = helper.getText(driver,Constant.homePageLoc_path,"loc_dateAndTime");
		helper.pageValidation(text2, dat.dateAndTime());
		helper.clickOnWebElement(driver,Constant.homePageLoc_path,"loc_invoice");
	    helper.getText(driver,Constant.bookingStatusLoc_path,"loc_bookingId");
		
		}
	
	@AfterClass
	public void browserClose() {
		report.logInfo("Step 20:driver close");
		driver.quit();
		
	}


}
