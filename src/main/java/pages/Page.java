package pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	protected String url;
	protected WebDriver driver;
	protected String mode;

	public Page() {
	}

	public Page(String url, WebDriver driver, String mode) {
		this.url = url;
		this.driver = driver;
	}

	public void openWebPage() {
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		waitForSeconds(10);
	}

	public int setModeIdentifier(String mode) {
		if (mode.equalsIgnoreCase(managers.ExecutionModes.WEB.getModeValue()))
			return 1;
		else
			return 0;
	}

	public void waitForElement(String xpath) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}

	public void waitForSeconds(int seconds)  {
		try {
		Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void switchTab() {
		Set<String> handles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();

		for (String actual : handles) {

			if (!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
			}
		}
	}
}
