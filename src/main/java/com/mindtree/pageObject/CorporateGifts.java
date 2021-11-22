package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.CorporateGiftsUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class CorporateGifts extends CorporateGiftsUi {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public CorporateGifts(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void fillDetails(String name, String Gmail, String phno) throws ReusableComponentException, Exception {

		WebDriverSupport.click(driver, corporateButton, "Home Page", "Corporate Button", log, test);
		Thread.sleep(2000);
		if (driver.findElement(header).isDisplayed()) {
			WebDriverSupport.sendKeys(driver, fname, "Corporate form Page", "Name", log, test, name);
			WebDriverSupport.sendKeys(driver, email, "Corporate form Page", "email", log, test, Gmail);
			WebDriverSupport.sendKeys(driver, phn, "Corporate form Page", "Phone No.", log, test, phno);
			WebDriverSupport.click(driver, submit, "Corporate form Page", "Submit Button", log, test);
			Thread.sleep(2000);
			WebDriverSupport.click(driver, getHome, "cart page", "Bigsmall pic", log, test);
			Thread.sleep(5000);
		} else {
			ExtentLogUtilities.fail(driver, test, "Page not opened", log);
			WebDriverSupport.click(driver, getHome, "cart page", "Bigsmall pic", log, test);
			Thread.sleep(5000);
			throw new PageObjectException("Page not opened");
		}
	}

}
