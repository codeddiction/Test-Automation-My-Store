package com.auto.general;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.auto.general.Constants;

import org.apache.commons.io.FileUtils;

public class Utility {
	
	static String destination = null;
	static String previousURL;
	public static String execScript;
	public static JavascriptExecutor scrollBarPresent;
	public static Boolean check;
	static WebDriver driver = null;
	static Actions action = null;
	
	
	

	public static String screenshot(WebDriver driver) throws IOException {
	    File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    destination = Constants.screenshotsLocation + System.currentTimeMillis() + ".png";
	    File destinationinationPath = new File(destination); 
	    FileUtils.copyFile(sourcePath, destinationinationPath);
	    System.out.println("Error found - Screenshot Taken");
	    
	    return destination;
	}
	
	
	
	
	public static Boolean checkScroll(WebDriver driver) throws IOException {
		execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		scrollBarPresent = (JavascriptExecutor) driver;
		check = (Boolean) (scrollBarPresent.executeScript(execScript));

		return check;
	}
	
	
	
	
	public static WebDriver loadChrome(String path, int pageNo) {
		String driverType = "webdriver.chrome.driver";
		System.setProperty(driverType, Constants.chromeLocation);
		driver = new ChromeDriver();
		action = new Actions(driver);
		ExcelUtils.setExcelFile(path, pageNo);
		ExcelUtils.setCellData(path, "Chrome", 4, 2);
		
		return driver;
	}
	
	
	
	
	public static WebDriver loadFirefox(String path, int pageNo) {
		String driverType = "webdriver.gecko.driver";
		System.setProperty(driverType, Constants.firefoxLocation);
		driver = new FirefoxDriver();
		action = new Actions(driver);
		ExcelUtils.setExcelFile(path, pageNo);
		ExcelUtils.setCellData(path, "Firefox", 4, 2);
		
		return driver;
	}
	
	
	
	
	public static WebDriver loadIE(String path, int pageNo) {
		String driverType = "webdriver.ie.driver";
		System.setProperty(driverType, Constants.IELocation);
		driver = new InternetExplorerDriver();
		action = new Actions(driver);
		ExcelUtils.setExcelFile(path, pageNo);
		ExcelUtils.setCellData(path, "Internet Explorer", 4, 2);
		
		return driver;
	}
	
	
	
	
	public static void refreshDriver(WebDriver driver) {		
		ExpectedCondition<Boolean> expectation = new
		ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
				}
			};
		Wait<WebDriver> wait = new WebDriverWait(driver,1000);
			try {
				wait.until(expectation);
			}
			catch(Throwable error) {
				System.out.println("Timeout waiting for Page Load Request to complete");
			}
		driver.navigate().refresh();
		}
	
	
	
	
	public static String passFailBlock(String text) {
		if(text.contains("BLOCKED")) {
			return "Blocked";
		}
		else if (text.contains("FAILED")) {
			return "Failed";
		}
		else 
			return "Passed";
	}

	

	
	public static String dateTime() {
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		 return date1;
	}
	
	
	
	
}
	
	

