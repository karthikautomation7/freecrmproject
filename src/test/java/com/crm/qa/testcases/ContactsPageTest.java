package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	Actions action;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage = homepage.clickOnContact();
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//th[contains(text(),'Address')]"))).build().perform();
		Thread.sleep(100);
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactpage.verifyContactsLabel(),"contact label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsByName() throws InterruptedException {
		contactpage.selectContactsByName("aravind raj");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
