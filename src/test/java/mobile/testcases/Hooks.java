package mobile.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import mobile.generics.GetCapability;



public class Hooks extends GetCapability {
	
	public WebDriver driver;
	LaunchApp ap = new LaunchApp();
	
	
	@BeforeSuite
	public void connectEmulator() throws IOException
	{
		driver = getDriver();
	}
	
//	@Test
//	public void launch()
//	{
//		ap.clickOnCat();
//	}

//	@After()
//	public void teardown(Method scenario) throws Exception {
//		if (scenario.isFailed()) 
//		{
//			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
//			scenario.attach(fileContent, "image/png", "screenshot");
//		}
//		System.out.println("browser closed");
//		//EKMScreenRecorder.stopRecording();
//		driver.quit();
//		
//
//	}
}
