package com.atmecs.php.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.atmecs.php.base.Base;
import com.atmecs.php.findLocator.FindLocators;
import com.atmecs.php.report.Report;

public class Helper extends Base {
	public FindLocators locator = new FindLocators();
	public Report report = new Report();

	/**
	 * Clear previous text in search box
	 * 
	 * @param driver
	 * @param element
	 */
	public void clearText(WebDriver driver, String element) {
		try {
			WebElement webElement = locator.findObject(driver, element);
			webElement.clear();
		} catch (Exception e) {
			e.toString();
		}
	}

	/**
	 * Determine the the state of the application whether it is the same what we are
	 * expecting or not.
	 * 
	 * @param actualDetails
	 * @param expectedDetails
	 */

	public void pageValidation(String actualDetails, String expectedDetails) {
		try {

			Assert.assertEquals(actualDetails, expectedDetails);
			report.logInfo(" Passed : " + " Expected : " + expectedDetails + " Actual : " + actualDetails);
		} catch (AssertionError assertionError) {
			report.logInfo(" Failed : " + " Expected : " + expectedDetails + " Actual : " + actualDetails);
		}

	}

	/**
	 * capable to check for the presence of all kinds of web elements available.
	 * used to verify if the web element is enabled or disabled within the web page.
	 * 
	 * @param element
	 * @return
	 */

	public boolean elementIsDisplayed(WebDriver driver, String element) {
		try {
			WebElement text = locator.findObject(driver, element);
			boolean displayed = text.isDisplayed();
			System.out.println(displayed);
			return displayed;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	

	public boolean elementIsSelected(WebDriver driver,String path, String element) {
		boolean selected = false;
		try {
			WebElement text = locator.findObject(driver,utils.propertyRead(path, element));
		    selected = text.isSelected();
			System.out.println(selected);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return selected;
	}
	

	/**
	 * pass input values to the text box(enter the values).
	 * 
	 * @param element
	 * @param values
	 */
	public void inputValuesToTheWebelement(WebDriver driver,String path, String element, String values) {
		try {

			WebElement webElement = locator.findObject(driver, utils.propertyRead(path, element));
			webElement.sendKeys(values);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Handling mouse event(Clicks at the current mouse location). Click button or
	 * whatever
	 * 
	 * @param element
	 */

	public void clickOnWebElement(WebDriver driver, String path, String elements) {
		try {

			// WebElement webElement = objRep.findObject(driver, element);
			// webElement.click();
			WebElement webElement = locator.findObject(driver, utils.propertyRead(path, elements));
			webElement.click();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * Retrieving the specified elements Text(Get Text).
	 */
	public String getText(WebDriver driver,String path, String element) throws Exception {
		String text = null;
		try {
			WebElement webElement =locator.findObject(driver, utils.propertyRead(path, element));

			text = webElement.getText();

			System.out.println("Actual text :" + text);
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	/**
	 * Scroll to bottom of the page
	 * 
	 */
	public void scrollToBottomOfThePage(WebDriver driver, String element) {
		try {
			WebElement webElement = locator.findObject(driver, element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", webElement);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * mouse over to specific web element
	 * 
	 */
	public void move(WebDriver driver, String element) {

		WebElement mouseOver = locator.findObject(driver, element);
		Actions action = new Actions(driver);
		action.moveToElement(mouseOver).perform();

	}
	public WebElement findingElement(String path,String element)
	{
		WebElement object = locator.findObject(driver,utils.propertyRead(path, element));
		return object;
	}

}
