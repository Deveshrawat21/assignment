package com.crm.qa.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtils;

public class AolHomePage extends TestBase {

	public AolHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "login-username")
	WebElement usernameId;
	
	@FindBy(id = "login-signin")
	WebElement nextBtn;
	
	@FindBy(id = "login-passwd")
	WebElement passwordId;
	
	@FindBy(xpath = "(//a[@href='https://mail.aol.com'])[2]")
	WebElement mailBtn;
    
	@FindBy(xpath = "//span[.='Login']")
	WebElement logInBtn;
	
	@FindBy(id = "ybar-logo")
	WebElement mailLogo;
	
	
	public void loginwithvalidCredential(String userName, String passWord) {

		usernameId.sendKeys(userName);
		nextBtn.click();
		passwordId.sendKeys(passWord);
		nextBtn.click();
		String firstTab=TestUtils.getFirsttabName(driver);
		mailBtn.click();
		TestUtils.switchToSecondTab(driver, firstTab);
		logInBtn.click();

	}
	
	public ComposeMail checkForMailLogo()
	{
		mailLogo.isDisplayed();
		return new ComposeMail();
	}
}