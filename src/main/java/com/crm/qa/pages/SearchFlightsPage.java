package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtils;
import com.crm.qa.utilities.operators;
import com.graphbuilder.struc.LinkedList;

public class SearchFlightsPage extends TestBase {

	public SearchFlightsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//header[@class='search-bar']")
	WebElement searchFlightHeader;

	@FindBy(xpath = "//span[text()='Departure']")
	WebElement sortDeparture;

	@FindBy(xpath = "//button[text()='OKAY, GOT IT!']")
	WebElement lockPricesNotification;

	@FindBy(xpath = "//div[@class='priceSection']//div[contains(@class,'blackText')]")
	List<WebElement> flightPrice;
	
	@FindBy(xpath ="//div[contains(@id,'flight_list_item')]//div[contains(@class,'makeFlex align-items')]//div")
	List<WebElement> flightName;
	
	
	public boolean getPageHeader() {
		return searchFlightHeader.isDisplayed();
	}

	public void sortByDeparture() {
		try {
			lockPricesNotification.click();
		} catch (Exception e) {
			System.out.println("Notifications Popup is not displayed");
		}
		sortDeparture.click();
	}
	
	public void priceSort()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		TestUtils.sortByPrice(flightName, flightPrice);
	}

}
