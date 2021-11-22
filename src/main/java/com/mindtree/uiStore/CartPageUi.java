package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class CartPageUi {
	public static By cartButton=By.xpath("//span[contains(text(),'cart')]");
	public static By resultHeader=By.cssSelector("a.cart__product-name");
	public static By quantity=By.cssSelector("input.cart__quantity");
	public static By formCart=By.cssSelector("form.drawer__contents.cart.ajaxcart");
	public static By close=By.cssSelector("button.drawer__close-button.js-drawer-close");
}
