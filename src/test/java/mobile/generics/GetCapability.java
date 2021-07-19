package mobile.generics;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class GetCapability {
	
	public AppiumServiceBuilder builder;
	public AppiumDriverLocalService service;
	public WebDriver driver;
	
	@FindBy(xpath="//android.widget.TextView[@text='Categories']")
	public static WebElement btnCate;
	
	@BeforeSuite
	public WebDriver getDriver() throws IOException
	{
		File f = new File("src/test/java");

		File fs = new File(f, "Myntra.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("0.0.0.0");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		
		service = AppiumDriverLocalService.buildService(builder);
		service.start();

		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		return driver;
	}
	
	
	
	@Test
	public void clickOnCat()
	{
		btnCate.click();
	}

}
