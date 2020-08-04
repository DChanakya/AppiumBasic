import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ChromeTest {
	public ChromeTest() {
		// TODO Auto-generated constructor stub
	}
WebDriver driver;
//	AppiumDriver<MobileElement> driver;
	//@BeforeTest
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("chromedriverExecutableDir",System.getProperty("user.dir") + "\\src\\test\\resources");
		capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
//		driver= new AppiumDriver<MobileElement>(url,capabilities);
		driver=new RemoteWebDriver(url, capabilities);

	}

	

	//@Test
	public void amazonTest() {
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("nav-search-keywords")).sendKeys("Apple Iphone X");
		driver.findElement(By.id("nav-search-keywords")).sendKeys(Keys.ENTER);

	}

	//@AfterTest
	public void teardown(){
//		driver.quit();
	}
}