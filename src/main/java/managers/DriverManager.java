package managers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.collect.ImmutableMap;

public class DriverManager {
	String mode;
	WebDriver driver;
	DesiredCapabilities capabilities;
	public DriverManager(String mode) {
		this.mode = mode;
	}

	public WebDriver setDriver() throws MalformedURLException {
		if (mode.equalsIgnoreCase(ExecutionModes.ANDROID.getModeValue())) {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "Android Emulator");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("chromedriverExecutableDir",	System.getProperty("user.dir") + "\\src\\test\\resources");
			capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			URL url = new URL("http://0.0.0.0:4723/wd/hub");
//			driver= new AppiumDriver<MobileElement>(url,capabilities);
			driver = new RemoteWebDriver(url, capabilities);
		}
		else if (mode.equalsIgnoreCase(ExecutionModes.WEB.getModeValue())) {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "Windows");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("chromedriverExecutableDir",	System.getProperty("user.dir") + "\\src\\test\\resources");
//			URL url = new URL("");
//			driver = new RemoteWebDriver(url, capabilities);	
		    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		return driver;

	}

}
