package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class MakeMyTripHomePage extends TestBase {

	public MakeMyTripHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Make My Trip']")
	WebElement logo;

	@FindBy(id = "fromCity")
	WebElement fromCity;

	@FindBy(id = "toCity")
	WebElement toCity;

	String cityName = "//p[contains(text(),'cityName')]";

	@FindBy(xpath = "//a[.='Search']")
	WebElement search;

	@FindBy(xpath = "//font[.='Offers']")
	WebElement randomClick;

	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}

	public SearchFlightsPage searchFlight(String from, String to) {
		fromCity.click();
		fromCity.sendKeys(from);
		driver.findElement(By.xpath(cityName.replace("cityName", from))).click();
		toCity.click();
		toCity.sendKeys(to);
		driver.findElement(By.xpath(cityName.replace("cityName", to))).click();
		driver.navigate().refresh();
		search.click();
		return new SearchFlightsPage();

	}

}