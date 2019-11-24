package com.auto.steps;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.auto.elements.CartSummaryElements;
import com.auto.elements.CheckOutElements;
import com.auto.elements.HomepageElements;
import com.auto.elements.MyAccountElements;
import com.auto.elements.QuickViewElements;
import com.auto.elements.SignInElements;
import com.auto.general.Constants;
import com.auto.general.ExcelUtils;
import com.auto.general.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class StepDefinition {
	
	WebDriver driver = null;
	Actions action = null;
	public static ExtentReports report = new ExtentReports(Constants.extentLocation, true);
	public ExtentTest test;
	public String execScript;
	public JavascriptExecutor scrollBarPresent;
	public Boolean check;
	public static int count = 0;
	public String excelMessage;
	public String extentMessage = "";
	public String excelPath = "";
	public int excelPage = 0;
//	public static Set<Cookie> allCookies;
	public Select dropdown;
	String parentWindow;
	String childWindow;
	
	@Before({"@cucumber"}) 
	public void setup() {
		count++;
		excelMessage = "";
		System.out.println("Running: Test " + count);
		test = report.startTest("Acceptance Criteria" + " " + count);
		
//			Give the Excel path and the page number
		excelPath = Constants.excelLocation;
		excelPage = 1;
		ExcelUtils.setExcelFile(excelPath, excelPage);
		
//			Choose the driver below			
		driver = Utility.loadChrome(excelPath, excelPage);
//		driver = Utility.loadFirefox(excelPath, excelPage);
//		driver = Utility.loadIE(excelPath, excelPage);
		
		driver.manage().window().maximize();
		
//		if(allCookies!=null) {
//			System.out.println("asad " + count);
//			for(Cookie cookie : allCookies)
//			{
//			    driver.manage().addCookie(cookie);
//			}
//		}
		
	}
	
	@Given("^I am on the YourLogo homepage$")
	public void i_am_on_the_YourLogo_homepage() {
		driver.get(Constants.homepageURL);
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "YourLogo homepage loaded");
	}

	@When("^I Quick view the first item \"([^\"]*)\"$")
	public void i_Quick_view_the_first_item(String arg1) throws InterruptedException {
		HomepageElements homePage = PageFactory.initElements(driver, HomepageElements.class);

//		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span"))).click();
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.getElementsByClassName(\"button ajax_add_to_cart_button btn btn-default\")[0].type = \"\";");
		
//		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", homePage.getItem1());
		
//		String homeWindowId = driver.getWindowHandle();
		
		homePage.getItem1().click();
		Thread.sleep(3000);
		Utility.refreshDriver(driver);
		
//		
//	    Set <String> windows = driver.getWindowHandles();
//	    Iterator it = windows.iterator();
//	    String currentWindowId;
//
//	    while (it.hasNext()) {
//	    	currentWindowId = it.next().toString();
//	    	   if(!currentWindowId.equals(homeWindowId)) {
//	    		   driver.switchTo().window(currentWindowId);
////	    		   driver.close();
//	    		   Thread.sleep(5000);
//	    			QuickViewElements quickView = PageFactory.initElements(driver, QuickViewElements.class);
//	    			dropdown = new Select(quickView.getSizeTab());
//	    			dropdown.selectByValue(arg1);
//	    			Utility.refreshDriver(driver);
//	    			test.log(LogStatus.INFO, "'" + arg1 + "' size chosen");
//	    	   }
//	    }
		
		
		
		
//		WebElement myDynamicElement = 
//				(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[1]/div/a[1]/img")));

//		WebDriverWait some_element = new WebDriverWait(driver,100); 
//		some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[1]/div/a[1]/img")));
		
		test.log(LogStatus.INFO, "Quick viewing the first item");
	}

	@When("^I change the size of the item \"([^\"]*)\"$")
	public void i_change_the_size_of_the_item(String arg1) throws InterruptedException {
		// add another cucumber command to check if cart displays the size!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		QuickViewElements quickView = PageFactory.initElements(driver, QuickViewElements.class);
		dropdown = new Select(quickView.getSizeTab());
		dropdown.selectByValue(arg1);
		Thread.sleep(3000);
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "'" + arg1 + "' size chosen");
	}

	@When("^I add to cart$")
	public void i_add_to_cart() {
		QuickViewElements quickView = PageFactory.initElements(driver, QuickViewElements.class);
		quickView.getAddCart().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "The first item added to cart");
	}

	@When("^I continue shopping$")
	public void i_continue_shopping() {
		QuickViewElements quickView = PageFactory.initElements(driver, QuickViewElements.class);
		quickView.getContinue().submit();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Shopping continued");
	}

	@When("^I Quick view the second item \"([^\"]*)\"$")
	public void i_Quick_view_the_second_item(String arg1) {
		HomepageElements homePage = PageFactory.initElements(driver, HomepageElements.class);
		homePage.getItem2().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Quick viewing the second item");
	}
	
	@When("^I follow the same instructions, with the size \"([^\"]*)\"$")
	public void i_follow_the_same_instructions_with_the_size(String arg1) throws InterruptedException {
		i_change_the_size_of_the_item(arg1);
		i_add_to_cart();
		i_continue_shopping();
	}

	@Then("^the cart tab shows the correct items - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void the_cart_tab_shows_the_correct_items(String arg1, String arg2) {
		HomepageElements homePage = PageFactory.initElements(driver, HomepageElements.class);
		QuickViewElements quickView = PageFactory.initElements(driver, QuickViewElements.class);
		
		action.moveToElement(homePage.getCart()).perform();
		test.log(LogStatus.INFO, "Cart at hover state");
		Utility.refreshDriver(driver);
		
		String expected1 = arg1;
		String expected2 = arg2;
		String actual1 = quickView.getCartTitle1().getText();
		String actual2 = quickView.getCartTitle2().getText();
		
		if(expected1.equals(actual1) && expected2.equals(actual2)) {
			extentMessage = "The system displays the items correctly";
			excelMessage = "PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the items incorrectly";
				excelMessage = "FAILED - " + extentMessage + " (Actual: '"+ actual1 + "' AND '" + actual2 + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> " + expected1 + "AND" + expected2 + "<br />" + "<span style='font-weight:bold;'>Actual:</span> " + actual1 + "AND" + actual2 + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = "BLOCKED - Cannot check the items";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@Then("^the correct prices - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void the_correct_prices(String arg1, String arg2) {
		QuickViewElements quickView = PageFactory.initElements(driver, QuickViewElements.class);
		String expected1 = arg1;
		String expected2 = arg2;
		String actual1 = quickView.getCartCost1().getText();
		String actual2 = quickView.getCartCost2().getText();
		
		if(expected1.equals(actual1) && expected2.equals(actual2)) {
			extentMessage = "The system displays the prices correctly";
			excelMessage = excelMessage + "; PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the prices incorrectly";
				excelMessage = excelMessage + "; FAILED - " + extentMessage + " (Actual: '"+ actual1 + "' AND '" + actual2 + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> " + expected1 + "AND" + expected2 + "<br />" + "<span style='font-weight:bold;'>Actual:</span> " + actual1 + "AND" + actual2 + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = excelMessage + "; BLOCKED - Cannot check the prices";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@Then("^the sum of the two items - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void the_sum_of_the_two_items(String arg1, String arg2) {
		QuickViewElements quickView = PageFactory.initElements(driver, QuickViewElements.class);
		String expectedString1 = arg1.substring(1);
		String expectedString2 = arg2.substring(1);
		int expected = Integer.parseInt(expectedString1) + Integer.parseInt(expectedString2);

		String actualString1 = quickView.getCartCost1().getText().substring(1);
		String actualString2 = quickView.getCartCost2().getText().substring(1);
		int actual = Integer.parseInt(actualString1) + Integer.parseInt(actualString2);
		
		if(expected==actual) {
			extentMessage = "The system displays the sum of the two items correctly";
			excelMessage = excelMessage + "; PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the sum of the two items incorrectly";
				excelMessage = excelMessage + "; FAILED - " + extentMessage + " (Actual: '$"+ actual + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> $" + expected + "<br />" + "<span style='font-weight:bold;'>Actual:</span> $" + actual + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = excelMessage + "; BLOCKED - Cannot check the sum of the two items";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@Then("^the shipping fee - \"([^\"]*)\"$")
	public void the_shipping_fee(String arg1) {
		QuickViewElements quickView = PageFactory.initElements(driver, QuickViewElements.class);
		String expected = arg1;
		String actual = quickView.getCartShipping().getText();
		
		if(expected.equals(actual)) {
			extentMessage = "The system displays the shipping fee correctly";
			excelMessage = excelMessage + "; PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the shipping fee incorrectly";
				excelMessage = excelMessage + "; FAILED - " + extentMessage + " (Actual: '"+ actual + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> " + expected + "<br />" + "<span style='font-weight:bold;'>Actual:</span> " + actual + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = excelMessage + "; BLOCKED - Cannot check the shipping fee";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@Then("^the total cost including the shipping fee - \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void the_total_cost_including_the_shipping_fee(String arg1, String arg2, String arg3) {
		QuickViewElements quickView = PageFactory.initElements(driver, QuickViewElements.class);
		String expectedString1 = arg1.substring(1);
		String expectedString2 = arg2.substring(1);
		String expectedString3 = arg3.substring(1);
		int expected = Integer.parseInt(expectedString1) + Integer.parseInt(expectedString2) + Integer.parseInt(expectedString3);

		String actualString1 = quickView.getCartTotal().getText().substring(1);
		int actual = Integer.parseInt(actualString1);
		
		if(expected==actual) {
			extentMessage = "The system displays the total cost including the shipping fee correctly";
			excelMessage = excelMessage + "; PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the total cost including the shipping fee incorrectly";
				excelMessage = excelMessage + "; FAILED - " + extentMessage + " (Actual: '$"+ actual + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> $" + expected + "<br />" + "<span style='font-weight:bold;'>Actual:</span> $" + actual + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = excelMessage + "; BLOCKED - Cannot check the total cost including the shipping fee";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}
	
	@When("^I add the two items to cart - \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void i_add_the_two_items_to_cart(String arg1, String arg2, String arg3, String arg4) throws InterruptedException {
		i_Quick_view_the_first_item(arg1);
		i_follow_the_same_instructions_with_the_size(arg2);
		i_Quick_view_the_second_item(arg3);
		i_follow_the_same_instructions_with_the_size(arg4);
	}

	@When("^I click on the cart tab$")
	public void i_click_on_the_cart_tab() {
		HomepageElements homePage = PageFactory.initElements(driver, HomepageElements.class);
		homePage.getCart().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Cart clicked");
	}

	@Then("^the cart summary page shows the correct items - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void the_cart_summary_page_shows_the_correct_items(String arg1, String arg2) {
		CartSummaryElements cartSum = PageFactory.initElements(driver, CartSummaryElements.class);

		String expected1 = arg1;
		String expected2 = arg2;
		String actual1 = cartSum.getCartTitle1().getText();
		String actual2 = cartSum.getCartTitle2().getText();
		
		if(expected1.equals(actual1) && expected2.equals(actual2)) {
			extentMessage = "The system displays the items correctly";
			excelMessage = "PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the items incorrectly";
				excelMessage = "FAILED - " + extentMessage + " (Actual: '"+ actual1 + "' AND '" + actual2 + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> " + expected1 + "AND" + expected2 + "<br />" + "<span style='font-weight:bold;'>Actual:</span> " + actual1 + "AND" + actual2 + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = "BLOCKED - Cannot check the items";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}
	
	@Then("^the page shows the correct prices - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void the_page_shows_the_correct_prices(String arg1, String arg2) {
		CartSummaryElements cartSum = PageFactory.initElements(driver, CartSummaryElements.class);
		String expected1 = arg1;
		String expected2 = arg2;
		String actual1 = cartSum.getCartCost1().getText();
		String actual2 = cartSum.getCartCost2().getText();
		
		if(expected1.equals(actual1) && expected2.equals(actual2)) {
			extentMessage = "The system displays the prices correctly";
			excelMessage = excelMessage + "; PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the prices incorrectly";
				excelMessage = excelMessage + "; FAILED - " + extentMessage + " (Actual: '"+ actual1 + "' AND '" + actual2 + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> " + expected1 + "AND" + expected2 + "<br />" + "<span style='font-weight:bold;'>Actual:</span> " + actual1 + "AND" + actual2 + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = excelMessage + "; BLOCKED - Cannot check the prices";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@Then("^the page shows the sum of the two items - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void the_page_shows_the_sum_of_the_two_items(String arg1, String arg2) {
		CartSummaryElements cartSum = PageFactory.initElements(driver, CartSummaryElements.class);
		String expectedString1 = arg1.substring(1);
		String expectedString2 = arg2.substring(1);
		int expected = Integer.parseInt(expectedString1) + Integer.parseInt(expectedString2);

		String actualString1 = cartSum.getProducts().getText().substring(1);
		int actual = Integer.parseInt(actualString1);
		
		if(expected==actual) {
			extentMessage = "The system displays the sum of the two items correctly";
			excelMessage = excelMessage + "; PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the sum of the two items incorrectly";
				excelMessage = excelMessage + "; FAILED - " + extentMessage + " (Actual: '$"+ actual + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> $" + expected + "<br />" + "<span style='font-weight:bold;'>Actual:</span> $" + actual + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = excelMessage + "; BLOCKED - Cannot check the sum of the two items";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@Then("^the page shows the shipping fee - \"([^\"]*)\"$")
	public void the_page_shows_the_shipping_fee(String arg1) {
		CartSummaryElements cartSum = PageFactory.initElements(driver, CartSummaryElements.class);
		String expected = arg1;
		String actual = cartSum.getTotalShipping().getText();
		
		if(expected.equals(actual)) {
			extentMessage = "The system displays the shipping fee correctly";
			excelMessage = excelMessage + "; PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the shipping fee incorrectly";
				excelMessage = excelMessage + "; FAILED - " + extentMessage + " (Actual: '"+ actual + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> " + expected + "<br />" + "<span style='font-weight:bold;'>Actual:</span> " + actual + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = excelMessage + "; BLOCKED - Cannot check the shipping fee";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@Then("^the page shows the total cost including the shipping fee - \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void the_page_shows_the_total_cost_including_the_shipping_fee(String arg1, String arg2, String arg3) {
		CartSummaryElements cartSum = PageFactory.initElements(driver, CartSummaryElements.class);
		String expectedString1 = arg1.substring(1);
		String expectedString2 = arg2.substring(1);
		String expectedString3 = arg3.substring(1);
		int expected = Integer.parseInt(expectedString1) + Integer.parseInt(expectedString2) + Integer.parseInt(expectedString3);

		String actualString1 = cartSum.getTotalAfterTax().getText().substring(1);
		int actual = Integer.parseInt(actualString1);
		
		if(expected==actual) {
			extentMessage = "The system displays the total cost including the shipping fee correctly";
			excelMessage = excelMessage + "; PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the total cost including the shipping fee incorrectly";
				excelMessage = excelMessage + "; FAILED - " + extentMessage + " (Actual: '$"+ actual + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> $" + expected + "<br />" + "<span style='font-weight:bold;'>Actual:</span> $" + actual + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = excelMessage + "; BLOCKED - Cannot check the total cost including the shipping fee";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@When("^I click on proceed to checkout under summary$")
	public void i_click_on_proceed_to_checkout_under_summary() {
		CartSummaryElements cartSum = PageFactory.initElements(driver, CartSummaryElements.class);
		cartSum.getSummaryCheckout().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Checked out of the summary page");
	}

	@When("^I sign in using my email address \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_sign_in_using_my_email_address_and_password(String arg1, String arg2) {
		SignInElements signIn = PageFactory.initElements(driver, SignInElements.class);
		signIn.signIn("vinu89628@test.com","Scotg0v@201g");
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Signed in");
	}

	@When("^I click on proceed to checkout under address$")
	public void i_click_on_proceed_to_checkout_under_address() {
		CheckOutElements checkOut = PageFactory.initElements(driver, CheckOutElements.class);
		checkOut.getAddressCheckout().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Checked out of the address page");
	}

	@When("^I agrees to the term of service$")
	public void i_agrees_to_the_term_of_service() {
		CheckOutElements checkOut = PageFactory.initElements(driver, CheckOutElements.class);
		checkOut.getTickTerms().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Agreed to the terms of service");
	}

	@When("^I click on proceed to checkout under shipping$")
	public void i_click_on_proceed_to_checkout_under_shipping() {
		CheckOutElements checkOut = PageFactory.initElements(driver, CheckOutElements.class);
		checkOut.getShipCheckout().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Checked out of the shipping page");
	}

	@When("^I choose to pay by bank wire$")
	public void i_choose_to_pay_by_bank_wire() {
		CheckOutElements checkOut = PageFactory.initElements(driver, CheckOutElements.class);
		checkOut.getBankWire().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Chose to pay by bank wire");
	}

	@When("^I confirm my order$")
	public void i_confirm_my_order() {
		CheckOutElements checkOut = PageFactory.initElements(driver, CheckOutElements.class);
		checkOut.getConfirmOrder().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Confirmed by order");
	}

	@Then("^my order is placed and displays the corfirmation message \"([^\"]*)\"$")
	public void my_order_is_placed_and_displays_the_corfirmation_message(String arg1) {
		CheckOutElements checkOut = PageFactory.initElements(driver, CheckOutElements.class);
		String expected = arg1;
		String actual = checkOut.getMessage().getText();
		
		if(expected.equals(actual)) {
			extentMessage = "The system displays the corfirmation message correctly";
			excelMessage = "PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the corfirmation message incorrectly";
				excelMessage = "FAILED - " + extentMessage + " (Actual: '"+ actual + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> " + expected + "<br />" + "<span style='font-weight:bold;'>Actual:</span> " + actual + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = "BLOCKED - Cannot check the corfirmation message";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@Then("^the total cost is shown  - \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void the_total_cost_is_shown(String arg1, String arg2, String arg3) {
		CheckOutElements checkOut = PageFactory.initElements(driver, CheckOutElements.class);
		String expectedString1 = arg1.substring(1);
		String expectedString2 = arg2.substring(1);
		String expectedString3 = arg3.substring(1);
		int expected = Integer.parseInt(expectedString1) + Integer.parseInt(expectedString2) + Integer.parseInt(expectedString3);

		String actualString1 = checkOut.getTotalCost().getText().substring(1);
		int actual = Integer.parseInt(actualString1);
		
		if(expected==actual) {
			extentMessage = "The system displays the total cost correctly";
			excelMessage = excelMessage + "; PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the total cost incorrectly";
				excelMessage = excelMessage + "; FAILED - " + extentMessage + " (Actual: '$"+ actual + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> $" + expected + "<br />" + "<span style='font-weight:bold;'>Actual:</span> $" + actual + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = excelMessage + "; BLOCKED - Cannot check the total cost";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@When("^I click on the sign in tab$")
	public void i_click_on_the_sign_in_tab() {
		HomepageElements homePage = PageFactory.initElements(driver, HomepageElements.class);
		homePage.getLastTab().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Sign in tab is clicked");
	}

	@When("^I click on order history and details$")
	public void i_click_on_order_history_and_details() {
		MyAccountElements account = PageFactory.initElements(driver, MyAccountElements.class);
		account.getOrderHistoryBtn().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Order history and details tab is clicked");
	}

	@Then("^I see my order stating the price total - \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void i_see_my_order_stating_the_price_total(String arg1, String arg2, String arg3) {
		MyAccountElements account = PageFactory.initElements(driver, MyAccountElements.class);
		String expectedString1 = arg1.substring(1);
		String expectedString2 = arg2.substring(1);
		String expectedString3 = arg3.substring(1);
		int expected = Integer.parseInt(expectedString1) + Integer.parseInt(expectedString2) + Integer.parseInt(expectedString3);

		String actualString1 = account.getTotalPrice().getText().substring(1);
		int actual = Integer.parseInt(actualString1);
		
		if(expected==actual) {
			extentMessage = "The system displays the price total correctly";
			excelMessage = "PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the price total incorrectly";
				excelMessage = "FAILED - " + extentMessage + " (Actual: '$"+ actual + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> $" + expected + "<br />" + "<span style='font-weight:bold;'>Actual:</span> $" + actual + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = "BLOCKED - Cannot check the price total";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}

	@When("^I sign in and view the order history and details - \"([^\"]*)\" - \"([^\"]*)\"$")
	public void i_sign_in_and_view_the_order_history_and_details(String arg1, String arg2) {
		i_click_on_the_sign_in_tab();
		i_sign_in_using_my_email_address_and_password(arg1, arg2);
		i_click_on_order_history_and_details();
	}

	@When("^I click on the details link under my order$")
	public void i_click_on_the_details_link_under_my_order() {
		MyAccountElements account = PageFactory.initElements(driver, MyAccountElements.class);
		account.getDetailsTab().click();
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Details tab of my order is clicked");
	}

	@When("^I add the following message \"([^\"]*)\"$")
	public void i_add_the_following_message(String arg1) {
		MyAccountElements account = PageFactory.initElements(driver, MyAccountElements.class);
		account.addMsg(arg1);
		Utility.refreshDriver(driver);
		test.log(LogStatus.INFO, "Added the following comment: '" + arg1 + "'");
	}

	@Then("^I see my comment \"([^\"]*)\" under the message section$")
	public void i_see_my_comment_under_the_message_section(String arg1) {
		MyAccountElements account = PageFactory.initElements(driver, MyAccountElements.class);
		String expected = arg1;
		String actual = account.getCheckMsg().getText();
		
		if(expected.equals(actual)) {
			extentMessage = "The system displays the comment under the message section correctly as '" + actual + "'";
			excelMessage = "PASSED - " + extentMessage;
			test.log(LogStatus.PASS, extentMessage);
			ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
			ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
			ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
			ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
		}
		else { 
			try {
				extentMessage = "The system displays the comment under the message section incorrectly";
				excelMessage = "FAILED - " + extentMessage + " (Actual: '"+ actual + "')";
				test.log(LogStatus.FAIL, extentMessage + "<p>" + "<span style='font-weight:bold;'>Expected:</span> " + expected + "<br />" + "<span style='font-weight:bold;'>Actual:</span> " + actual + "</p>" + test.addScreenCapture(Utility.screenshot(driver)));
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
			catch (Exception e) 
			{
				excelMessage = "BLOCKED - Cannot check the comment under the message section";
				test.log(LogStatus.FAIL, "Exception while taking the screenshot: " + e.getMessage());
				ExcelUtils.setCellData(excelPath, excelMessage, count+6, 7);
				ExcelUtils.setCellData(excelPath, Utility.passFailBlock(excelMessage), count+6, 8);
				ExcelUtils.setCellData(excelPath, e.getMessage(), count+6, 9);
				ExcelUtils.setCellData(excelPath, "Tested automatically", count+6, 10);
				ExcelUtils.setCellData(excelPath, Utility.dateTime(), count+6, 11);
			}
		}
	}
	
	@After({"@cucumber"})
	public void tearDown() {
//		allCookies = driver.manage().getCookies();
		report.endTest(test);
		driver.quit();
		report.flush();
	}
}
