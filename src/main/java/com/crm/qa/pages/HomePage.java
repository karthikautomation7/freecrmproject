package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Free account')]")
	WebElement accounttype;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement deals;
	
//	@FindBy(xpath="//span[contains(text(),'Tasks')]")
//	WebElement tasks; 
	
	//initializing page objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		//actions
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public ContactsPage clickOnContact() {
			contacts.click();
			return new ContactsPage();
		}
		
		public DealsPage clickOnDeal() {
			deals.click();
			return new DealsPage();
		}
}
