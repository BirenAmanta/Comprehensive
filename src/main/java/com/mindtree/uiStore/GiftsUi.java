package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class GiftsUi {
	public static By header =By.cssSelector("h1.section-header--title.h1");
	public static By giftsButton=By.xpath("//a[@data-dropdown-rel='gifts']");
	public static By dropDown=By.xpath("(//ul[@class='site-nav__dropdown text-left'])[1] //a");
	public static By result = By.cssSelector("div.grid-product__title");
	public static By quantity = By.xpath("//input[@id='quantity']");
	public static By cart = By.xpath("//button[@name='add']");
	public static By formCart=By.cssSelector("form.drawer__contents.cart.ajaxcart");
	public static By close=By.cssSelector("button.drawer__close-button.js-drawer-close");
	public static By getHome=By.cssSelector("img.small--hide");
}
