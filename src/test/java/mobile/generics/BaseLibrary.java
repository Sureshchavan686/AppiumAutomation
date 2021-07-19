package mobile.generics;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Suresh R Chavan
 *
 */

import mobile.generics.GetCapability;

public class BaseLibrary extends GetCapability {

	protected WebDriverWait wait;
	protected JavascriptExecutor jsExecutor;
		public static String projectPath = System.getProperty("user.dir");

	public void sendKeysToWebElement(WebElement element, String textToSend) {

		try {
			this.waitForElement(element);
			element.clear();
			element.sendKeys(textToSend);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public WebElement waitForElement(WebElement element) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();

		} catch (Exception e) {

		}
		return element;

	}

	/*
	 * public String getURL() { ReadConfigFile file = new ReadConfigFile(); String
	 * url = file.getURL(); driver.get(url); return null;
	 * 
	 * }
	 */
	public void click(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			waitForElement(element);
			element.click();
		}

	}

	public void waitTill(String durationInSecond) {
		try {
			long n = (long) Double.parseDouble(durationInSecond);
			Thread.sleep(n * 1000);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void sendkeyBoardkey(WebElement element, Keys keyButton) {

		try {
			this.waitForElement(element);

			element.sendKeys(keyButton);
		} catch (Exception e) {

		}
	}

	public void hover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	public String getcurrentDate()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMYYYY_HHmmss");  
		LocalDateTime now = LocalDateTime.now(); 
		
		String currentDate = dtf.format(now);
		
		return currentDate;

	}
	
	/*
	 * public String getUsername() { ReadConfigFile file = new ReadConfigFile();
	 * String username = file.getUsername(); return username;
	 * 
	 * }
	 * 
	 * public String getPassword() { ReadConfigFile file = new ReadConfigFile();
	 * String password = file.getPassword(); return password;
	 * 
	 * }
	 */
	
	public String getFutureDate() {
		DateFormat dft = new SimpleDateFormat("dd-MM-yyyy");

		Calendar cal = Calendar.getInstance();

		cal.setTime(new Date());
		cal.add(Calendar.DATE, 5);

		String startDate = dft.format(cal.getTime());
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 12);

		String endDate = dft.format(cal.getTime());
		return startDate + "~" + endDate;
		
	}
	
	// Deletes the old video recording of the test
	public void deletevideos() {
		File directory = new File("./Test case recordings/");
		File[] files = directory.listFiles();
		if(files!=null) {
			for (File file : files) {
				file.delete();
			}
		}
		
	}
	
	public void deleteOldReports() throws IOException {
		String filePath = "./Extent_Reports";
	      //Creating the File object
	      File file = new File(filePath);
	      FileUtils.deleteDirectory(file);
	}
	
	

}
