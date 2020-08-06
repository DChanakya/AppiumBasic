import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import managers.DriverManager;
import managers.PropertyManager;
import pages.AmazonPage;

public class WebTest {
	WebDriver driver;
	String mode;
	AmazonPage amazonPage;

	@BeforeTest(groups = { "androidWeb", "web" })
	public void setUp() throws IOException {
		mode = new PropertyManager().getExecutionMode();
	}

	@Test(groups = { "androidWeb", "web" })
	public void amazonTest_AddItemsToCart() throws IOException {
		driver = new DriverManager(mode).setDriver();
		amazonPage = new AmazonPage(driver, mode);
		amazonPage.searchForItem("Apple iPhone 11");
		amazonPage.openItemFromList("Apple iPhone 11 (64GB) - Black");
//		amazonPage.clickOnAddToCart();
//		assertEquals(amazonPage.verifyInCart(), true);
	}

	@AfterTest(groups = { "androidWeb", "web" })
	public void teardown() {
		driver.quit();
	}
}
