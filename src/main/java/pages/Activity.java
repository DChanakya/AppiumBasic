package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity {
	protected AndroidDriver<MobileElement> driver;

	public Activity(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public WebElement getElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement getElementById(String id) {
		return driver.findElementById(id);
	}

	public void waitForElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}

	public void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
