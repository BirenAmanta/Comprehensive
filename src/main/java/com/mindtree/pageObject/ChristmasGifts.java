package com.mindtree.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.ChristmasGiftSUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class ChristmasGifts extends ChristmasGiftSUi {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public ChristmasGifts(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void orderGift(String qunt, String item) throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, christmanButton, " Home page", "christmas gifts button", log, test);
		Thread.sleep(2000);
		if (driver.findElement(header).getText().equalsIgnoreCase("Christmas Gifts")) {
			List<WebElement> listRec = driver.findElements(result);
			boolean b = false;
			for (WebElement temp : listRec) {
				if (temp.getText().equalsIgnoreCase(item)) {
					b = true;
					WebDriverSupport.clickByWebElement(driver, temp, "result page", item, log, test);
					break;
				}
			}
			Thread.sleep(3000);
			if (b) {
				if (driver.findElement(cart).isDisplayed()) {
					driver.findElement(quantity).clear();
					WebDriverSupport.sendKeys(driver, quantity, "socks page", "quantity button ", log, test, qunt);
					WebDriverSupport.click(driver, cart, "socks page", "cart button", log, test);
					Thread.sleep(3000);
					if (driver.findElement(formCart).isDisplayed()) {
						WebDriverSupport.click(driver, close, "Cart Page", "Close Button", log, test);
					}
					WebDriverSupport.click(driver, getHome, "cart page", "Bigsmall pic", log, test);
					Thread.sleep(5000);
				} else {
					ExtentLogUtilities.fail(driver, test, "cart Page not opened", log);
					WebDriverSupport.click(driver, getHome, "cart page", "Bigsmall pic", log, test);
					Thread.sleep(5000);
					throw new PageObjectException("cart Page not opened");
				}
			} else {
				ExtentLogUtilities.fail(driver, test, "product no found", log);
				WebDriverSupport.click(driver, getHome, "cart page", "Bigsmall pic", log, test);
				Thread.sleep(5000);
				throw new PageObjectException("product no found");
			}
		} else {
			ExtentLogUtilities.fail(driver, test, "Page not opened", log);
			WebDriverSupport.click(driver, getHome, "cart page", "Bigsmall pic", log, test);
			Thread.sleep(5000);
			throw new PageObjectException("Page not opened");
		}
	}
}
