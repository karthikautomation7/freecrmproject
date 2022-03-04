package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	public HomePageTest() {
		super();
	}
	
	//test cases must be separated --- independent with each other
	//before each test case ---- launch the browser and login
	//@test ---- execute test case
	//after each test case ---  close the browser
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTest() {
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM","home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyContact() {
		contactpage = homepage.clickOnContact();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
