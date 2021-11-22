package com.mindtree.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.WhatsNewUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;
public class WhatsNew extends WhatsNewUi{
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public WhatsNew(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void addCart(String qnt,String item) throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, whatsnewButton,"Home page","Personalize Gift button", log, test);
		if (driver.findElement(header).isDisplayed()) {
			List<WebElement> listRec = driver.findElements(result);
			boolean b = false;
			for (WebElement temp : listRec) {
				if (temp.getText().equalsIgnoreCase(item)) {
					WebDriverSupport.clickByWebElement(driver, temp, "result page", item, log, test);
					b = true;
					break;
				}
			}
			Thread.sleep(3000);
			if (b) {
				if(driver.findElement(cart).isDisplayed())
				{
					driver.findElement(quantity).clear();
					WebDriverSupport.sendKeys(driver,quantity,"Cart Page","Quantity Field", log, test, qnt);
					WebDriverSupport.click(driver, cart,"Cart page", "Add to cart", log, test);
					Thread.sleep(3000);
					if(driver.findElement(formCart).isDisplayed())
					{
						WebDriverSupport.click(driver,close,"Cart Page","Close Button", log, test);
					}
					WebDriverSupport.click(driver,getHome,"cart","Bigsmall pic", log, test);
					Thread.sleep(3000);
				}
				else
				{
					ExtentLogUtilities.fail(driver, test, "add to cart page not opened", log);
					WebDriverSupport.click(driver, getHome, "cart page", "Bigsmall pic", log, test);
					Thread.sleep(5000);
					throw new PageObjectException("add to cart page not opened");
				}
			} else {
				ExtentLogUtilities.fail(driver, test, "item not found", log);
				WebDriverSupport.click(driver, getHome, "cart page", "Bigsmall pic", log, test);
				Thread.sleep(5000);
				throw new PageObjectException("item not found");
			}
		} else {
			ExtentLogUtilities.fail(driver, test, "page not opened", log);
			WebDriverSupport.click(driver, getHome, "cart page", "Bigsmall pic", log, test);
			Thread.sleep(5000);
			throw new PageObjectException("page not opened");
		}
	}
}
