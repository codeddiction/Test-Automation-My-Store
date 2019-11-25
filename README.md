# Test Automation

# Requirements
1.	Java – The Automation Tester will need experience in this programming language. 
2.	Maven – This is a build automation tool used primarily for Java projects.
3.	Download the Eclipse IDE
4.	Java Development Kit (JDK) – Download the zip file under the ‘Link’ column and in the row of “Binary zip archive” – https://maven.apache.org/download.cgi
5.	Download the Cucumber plugin – Open Eclipse > Choose “Help” in the navigation tab > Select “Eclipse Marketplace” > Search “cucumber” > Install “Nature” and “Cucumber Eclipse Plugin”. Once they are downloaded, restart Eclipse
6.	Git – see the next section for more – “Where to find the code and how to manage it”
7.	Install the following browsers: Firefox and Chrome 

# Where to find the code
Here is the link to the code: https://github.com/codeddiction/Test-Automation-My-Store
Here are Git commands you will need:
1.	git clone https://github.com/codeddiction/Test-Automation-My-Store.git – To clone the project
2.	git status – To check the status of the working directory and the staging area
3.	git add . – To add changes you have made, from the working repository to the staging area 
4.	git commit –m “[your message]” – To save the changes that’s currently in the staging area, to the local repository
5.	git push – To transfer commits from the local repository, to a remote repository
6.	git pull – To ensure you have the latest code

# What you need to know before test execution

1.	Update the location of the project – Navigate to src/main/java > com.auto.general > Constants.java > update “pathTestData”.
2.  In "StepDefinitions.java" under com.auto.steps, you can choose your desired browser to test on by enabling one of the following lines. However, "loadFirefox" is the only driver that works properly. "loadIE" does not work and it's there for future development.

//			Choose the driver below			
		driver = Utility.loadChrome(excelPath, excelPage);
//		driver = Utility.loadFirefox(excelPath, excelPage);
//		driver = Utility.loadIE(excelPath, excelPage);

3.	Under src/main/java, there are two ways to execute tests:
	1)	Open "Cucumber.feature" file under com.auto.features > right click on the file > find “Run as” > select “Cucumber feature”
	2)	Open "Runner.java" file under com.auto.runners > hit "Run"

# About the project
1.	The “Utility” class contains all the common methods. The class is located under src/main/java > com.auto.general
2. The "ExcelUtils" class is in place to log test results into a spreadsheet. Please do not interfer with the file.
3.	The xpaths/IDs are the tags of the elements on a website. They are found under src/main/java > com.auto.elements.
4.	Cucumber reports are automatically created. However, excel spreadsheets must be in place prior to test execution. After the test suites (in excel format) are created, manually store them in their folder under “Reports” – results will be populated in the spreadsheets at execution. Note: please do not alter the format of the spreadsheets.
5.  “chromedriver.exe”, “geckodriver.exe” and “IEDriverServer.exe” drivers are currently installed to access Chrome, Firefox and Internet Explorer respectively. 



# For future development
1.	To enable the runner to be executed via command line.
2.	Manually updating the URL of the project location in the common constants isn’t ideal. This should be automated.
3.	Code written in the step definition files can be simplified by creating methods in the Utility class.
4.	The project is purely designed for web-browser testing. Integrating Appium would be ideal to allow mobile testing. 
5.	Excel spreadsheets must be in place prior to test execution. A method for this can be created in the "ExcelUtils" class. 
6.	WebDriver currently works for Chrome and Firefox only. Internet Explorer and Microsoft Edge must be incorporated. 


