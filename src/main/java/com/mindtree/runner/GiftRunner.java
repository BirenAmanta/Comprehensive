package com.mindtree.runner;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mindtree.pageObject.*;
import com.mindtree.exceptions.*;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class GiftRunner extends Base  {
	static Logger log;
	static ExtentTest test;
	static ExtentReports report;

	public GiftRunner() throws UtilityException, Exception {
		super();
	}

	@BeforeTest()
	public void initializeDriver() throws ApplicationException
	{
		try {
			report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
					+ System.currentTimeMillis() + "-.html");
			log = Logger.getLogger(GiftRunner.class.getName());
			driver=initialize();
			test = report.startTest("Home Page");
			driver.get(GetProperties.get.getProperty("url"));
			driver.manage().window().maximize();
			ExtentLogUtilities.pass(driver, test, "URL Opened", log);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	@Test(priority=1,dataProvider="getTitle")
	public void validateTitle(String title) throws ApplicationException{
		test = report.startTest("Validate Title");
		try {
			new ValidPage(driver,log, test).validate(title);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[] getTitle()
	{
		Object data[]=new Object[1];
		data[0]=get.getProperty("title");
		return data;
	}
	@Test(priority=2,dataProvider="getData")
	public void LogIn(String uid,String pw) throws ApplicationException{
		test = report.startTest("Log in");
		try {
			new HomePageLogIn(driver, log, test).login(uid, pw);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[] getData()
	{
		Object data[][]=new Object[1][2];
		data[0][0]=excelData.get("id");
		data[0][1]=excelData.get("pw");
		return data;
	}
	@Test(priority=3,dataProvider="getPerData")
	public void PersonalizeGift(String qnt,String name,String item) throws ApplicationException{
		test = report.startTest("Personalized Gift");
		try {
			new PersonalizedGifts(driver, log, test).Getbottle(qnt,name,item);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getPerData()
	{
		Object[][] val = new Object[1][3];
		val[0][0] =excelData.get("personalize quantity");
		val[0][1] =excelData.get("personalize  name");
		val[0][2] =excelData.get("personalize gift name");
		return val;
	}
	@Test(priority=4,dataProvider="getWhtData")
	public void WhtsNewGift(String qnt,String item) throws ApplicationException{
		test = report.startTest("What's New Gift");
		try {
			new WhatsNew(driver, log, test).addCart(qnt, item);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getWhtData()
	{
		Object[][] val = new Object[1][2];
		val[0][0] =excelData.get("what's new gift quantity");
		val[0][1] =excelData.get("what's new gift name");
		return val;
	}
	@Test(priority=5,dataProvider="getChrisData")
	public void ChristmasGift(String qnt,String item) throws ApplicationException{
		test = report.startTest("Christmas Gift");
		try {
			new ChristmasGifts(driver, log, test).orderGift(qnt, item);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getChrisData()
	{
		Object[][] val = new Object[1][2];
		val[0][0] =excelData.get("christmas quantity");
		val[0][1] =excelData.get("christmas item");
		return val;
	}
	@Test(priority=6,dataProvider="getScrtData")
	public void SecretSantaGift(String qnt,String item) throws ApplicationException{
		test = report.startTest("Secret Santa Gift");
		try {
			new SecretSanta(driver, log, test).orderSecret(qnt, item);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getScrtData()
	{
		Object[][] val = new Object[1][2];
		val[0][0] =excelData.get("secret santa quantity");
		val[0][1] =excelData.get("secret santa item");
		return val;
	}
	@Test(priority=7,dataProvider="getHmData")
	public void homeDecor(String qnt,String item) throws ApplicationException{
		test = report.startTest("Home Decor");
		try {
			new HomeDecor(driver, log, test).homeDec(qnt, item);
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getHmData()
	{
		Object[][] val = new Object[1][2];
		val[0][0] =excelData.get("home decor quantity");
		val[0][1] =excelData.get("home decor item");
		return val;
	}
	@Test(priority=8,dataProvider="getGiftData")
	public void Gifts(String type,String qnt,String item) throws ApplicationException{
		test = report.startTest("Gifts");
		try {
			new Gifts(driver, log, test).orderGift(type, qnt, item);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getGiftData()
	{
		Object[][] val = new Object[1][3];
		val[0][0] =excelData.get("gifts type");
		val[0][1] =excelData.get("gifts quantity");
		val[0][2] =excelData.get("gifts items");
		return val;
	}
	@Test(priority=9,dataProvider="getCopData")
	public void cropDetailSubmit(String name,String gmail,String phn) throws ApplicationException{
		test = report.startTest("Corporate Gifts");
		try {
			new CorporateGifts(driver, log, test).fillDetails(name, gmail, phn);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getCopData()
	{
		Object[][] val = new Object[1][3];
		val[0][0] =excelData.get("corporate Name");
		val[0][1] =excelData.get("corporate Email");
		val[0][2] =excelData.get("corporate phn");
		return val;
	}
	@Test(priority=10)
	public void cartValidate() throws ApplicationException
	{
		test = report.startTest("Cart Validation");
		try
		{
			new CartPage(driver, log, test).check();
			report.endTest(test);
			report.flush();
		}
		catch(Exception e)
		{
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@AfterTest
	public void disClose()
	{
		driver.close();
	}
}
