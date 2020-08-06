package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import managers.ExecutionModes;
import testObjects.ObjectRepository;

public class AmazonPage extends Page {
	public String URL = "https://www.amazon.in/";
	private int elementIdentifier;
	private String[] searchBar = { ObjectRepository.AmazonPageObjects.getAndroidSearchBar(), ObjectRepository.AmazonPageObjects.getWebSearchBar() };
	private String[] firstTile = { ObjectRepository.AmazonPageObjects.getAndroidTile(), ObjectRepository.AmazonPageObjects.getWebTile() };
	private String[] addToCartButton = { ObjectRepository.AmazonPageObjects.getAndroidAddToCart(), ObjectRepository.AmazonPageObjects.getWebAddToCart() };
	private String[] proceedToBuy = { ObjectRepository.AmazonPageObjects.getAndroidProceedToBuy(),
			ObjectRepository.AmazonPageObjects.getWebProceedToBuy() };
	private String mode;
	public AmazonPage(String url, WebDriver driver, String mode) {
		super(url, driver, mode);
	}

	public AmazonPage(WebDriver driver, String mode) {
		super("", driver, mode);
		url = URL;
		openWebPage();
		elementIdentifier = setModeIdentifier(mode);
		this.mode = mode;
	}

	public void searchForItem(String item) {
		driver.findElement(By.xpath(searchBar[elementIdentifier])).click();
		driver.findElement(By.xpath(searchBar[elementIdentifier])).sendKeys(item);
		driver.findElement(By.xpath(searchBar[elementIdentifier])).sendKeys(Keys.ENTER);
	}

	public void openItemFromList(String item) {
		String xpath = String.format(firstTile[elementIdentifier], item);
		waitForElement(xpath);
		driver.findElement(By.xpath(xpath)).click();
	}

	public void clickOnAddToCart() {
		if (mode.equalsIgnoreCase(ExecutionModes.ANDROIDWEB.getModeValue()))
			closeAndroidPopup();
		else
			switchTab();
		waitForElement(addToCartButton[elementIdentifier]);
		driver.findElement(By.xpath(addToCartButton[elementIdentifier])).click();
	}

	public boolean verifyInCart() {
		waitForSeconds(3);
		return (driver.findElement(By.xpath(proceedToBuy[elementIdentifier])).getText().contains("Proceed to Buy"));
	}

	public void closeAndroidPopup() {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class);
			wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath(ObjectRepository.AmazonPageObjects.getAndroidPopupClose()));
				}
			}).click();
		} catch (Exception e) {
		}
	}

}
