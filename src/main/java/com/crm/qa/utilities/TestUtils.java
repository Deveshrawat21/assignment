package com.crm.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import flight.Flight;

public class TestUtils {

	static DateFormat dateFormat;
	static Date date;

	public static final long PAGE_LOAD_TIMEOUT = 100;

	public static final long IMPLICIT_WAIT = 20;

	public static final String WORKSAPCE_PATH = "D://SeleniumFrameworkForInterview//Selenium-POM-TestNG-Maven-master//Selenium-POM-TestNG-Maven-master//src//drivers"; // provide path of workspace from your local machine

	public static final String SCREENSHOT_PATH = WORKSAPCE_PATH + "//Screenshot//";
	
	public static final String DateFormat = "yyyyMMddHH:mm:ss";

	public static String getDate(String format) {
		dateFormat = new SimpleDateFormat(format);
		date = new Date();
		return dateFormat.format(date);
	}

	public static void takeScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(SCREENSHOT_PATH + "//screenshot//" + getDate(DateFormat) + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void sortByPrice(List<WebElement> flightName, List<WebElement> flightPrice)
	{
		ArrayList<Flight> arraylist = new ArrayList<Flight>();
		for (int i = 0; i <flightName.size() ; i++) {
			arraylist.add(new Flight(flightName.get(i).getText(),flightPrice.get(i).getText()));
		}
		Collections.sort(arraylist);
		System.out.println(arraylist.get(1).getName()+" "+arraylist.get(1).getPrice());
	}
	
	public static void switchToSecondTab(WebDriver driver,String firstTab)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(firstTab)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Switch to second window");
				break;
			}
		}
	}
	public static String getFirsttabName(WebDriver driver)
	{
		return driver.getWindowHandle();
		
	}
}
