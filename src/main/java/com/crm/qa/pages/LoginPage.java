package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//pagefactory -- OR
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signupbtn;
	
	@FindBy(xpath="//div[@class='onesignal-bell-launcher-button']")
	WebElement bell;
	
	//initializing page objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateBell() {
		return bell.isDisplayed();
	}
	
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbtn.click();
		return new HomePage();	
	}
	
}
