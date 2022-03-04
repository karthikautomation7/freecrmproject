package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactslabel;
	
	//initializing page objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		boolean result;
		
		
//		WebDriverWait ww = new WebDriverWait(driver, 15);
//		ww.until(ExpectedConditions.elementToBeSelected(contactslabel));
//		System.out.println(contactslabel.getText());
//		System.out.println(contactslabel.getAttribute("innerHTML"));
		System.out.println(contactslabel.isDisplayed());
		if(contactslabel.getText().equalsIgnoreCase("Contacts"))
			result=true;
		else
			result=false;
		
		return result;
	}
	
	public void selectContactsByName(String names) throws InterruptedException {
		
		
		//action.moveToElement(driver.findElement(By.xpath("//th[contains(text(),'Address')]"))).build().perform();
		Thread.sleep(5000);
		
		List<WebElement> elemsCheckBox= driver.findElements(By.xpath("//div//td[1]"));
		System.out.println(elemsCheckBox.size());
		List<WebElement> elemsName= driver.findElements(By.xpath("//div//td[2]"));
		System.out.println(elemsName.size());
		for(int i=0;i<=elemsName.size()-1;i++) {
			if(elemsName.get(i).getText().equalsIgnoreCase(names)) {
				Thread.sleep(5000);
				
				elemsCheckBox.get(i).click();
			}
		}
		//driver.findElement(By.xpath("//a[text()='\"+names+\"']//parent::td//preceding-sibling::td/div//label")).click();
	}
////a[text()='"+names+"']//parent::td//preceding-sibling::td/div/input[@name='id'])	
////a[text()='"+names+"']//parent::td//preceding-sibling::td/div//label 	//input[@type='checkbox']
}

