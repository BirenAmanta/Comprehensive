package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class HomePageLogInUi {
	public static By header=By.xpath("//h1[contains(text(),'Login')]");
	public static By logInButton=By.cssSelector("a.site-nav__link.site-nav__link--icon.signinlink");
	public static By email=By.cssSelector("input#CustomerEmail");
	public static By pass=By.cssSelector("input#CustomerPassword");
	public static By signin=By.cssSelector("input.btn.btn--full");
	public static By myAcc=By.cssSelector("h2.section-header__title");
	public static By getHome=By.cssSelector("img.small--hide");
}
