package com.auto.general;

public class Constants {
	
//		Change to the location of the Project (should be automated in the future)
	public static final String pathTestData = "C:\\Users\\LENOVO\\Google Drive\\Job\\Scottish Government\\Automated Test Framework\\";
//	public static final String pathTestData = System.getProperty("user.dir") + "\\";

//		The location of the drivers
	public static final String chromeLocation = pathTestData + "Drivers\\chromedriver.exe";
	public static final String firefoxLocation = pathTestData + "Drivers\\geckodriver.exe";
	public static final String IELocation = pathTestData + "Drivers\\IEDriverServer.exe";

//		Features files
	public static final String featureFileLocation = pathTestData + "src\\test\\java\\com\\features\\Cucumber.feature";
	
//		Screenshot
	public static final String screenshotsLocation = pathTestData + "target\\test-report\\extent-report\\screenshots\\";
	
//		Excel report
	public static final String excelLocation = Constants.pathTestData + "Reports\\Excel-report.xlsx";
	
//		Extent report
	public static final String extentLocation = Constants.pathTestData + "Reports\\Extent-report.html";
	
//		URL	
	public static final String homepageURL = "http://automationpractice.com";
}
