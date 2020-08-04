import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import managers.DriverManager;
import managers.PropertyManager;
import pages.AmazonPage;

public class AmazonTest {
	WebDriver driver;
	String mode;
	AmazonPage amazonPage;

	@BeforeTest
	public void setUp() throws IOException {
		mode = new PropertyManager().getExecutionMode();
	}

	@Test
	public void addItemsToCart() throws IOException {
		driver = new DriverManager(mode).setDriver();
		amazonPage = new AmazonPage(driver,mode);
		amazonPage.searchForItem("Apple Iphone X");
		amazonPage.openFirstItemFromList();
		amazonPage.clickOnAddToCart();
		assertEquals(amazonPage.verifyInCart(), true);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
