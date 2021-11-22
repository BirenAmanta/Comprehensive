package com.mindtree.pageObject;

import java.util.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.CartPageUi;
import com.mindtree.utilities.ExcelSheetRead;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class CartPage extends CartPageUi{

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public CartPage(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void check() throws ReusableComponentException, Exception
	{
		WebDriverSupport.click(driver,cartButton,"Home Page","Cart Button", log, test);
		if(driver.findElement(formCart).isDisplayed())
		{
			List<WebElement>cartList=driver.findElements(resultHeader);
			Set<String>cartSet=new HashSet<>();
			for(WebElement temp:cartList)
			{
				cartSet.add(temp.getText());
			}
			List<WebElement>cartListValue=driver.findElements(quantity);
			for(WebElement temp:cartListValue)
			{
				
				cartSet.add(temp.getAttribute("value"));
			}
			System.out.println(cartSet);
			if(cartSet.size()>0)
			{
				boolean b=true;
				for(String key:ExcelSheetRead.excelData.keySet())
				{
					if(!cartSet.contains(ExcelSheetRead.excelData.get(key)))
					{
						b=false;
						break;
					}
				}
				if(b)
				{
					ExtentLogUtilities.pass(driver, test,"All products Added to cart", log);
				}
				else
				{
					ExtentLogUtilities.fail(driver, test,"All products not Added to cart", log);
					throw new PageObjectException("All products not Added to cart");
				}
			}
			else
			{
				throw new PageObjectException("cart is empty");
			}
		}
		else
		{
			throw new PageObjectException("cart page not opened");
		}
	}
}
