package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class CorporateGiftsUi {
	public static By corporateButton=By.xpath("//button[contains(text(),'Corporate Gifts')]");
	public static By fname=By.cssSelector("input#contactFormName");
	public static By email=By.cssSelector("input#contactFormEmail");
	public static By phn=By.cssSelector("input#contactFormPhone");
	public static By submit=By.cssSelector("input.btn");
	public static By getHome=By.cssSelector("img.small--hide");
	public static By header=By.xpath("//h1[contains(text(),'Corporate Gifts')]");
}
