import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import managers.DriverManager;
import managers.PropertyManager;
import pages.CalculatorApp;

public class AndroidAppTest {

	AndroidDriver<MobileElement> driver;
	String mode;
	CalculatorApp calculatorApp;

	@SuppressWarnings("unchecked")
	@BeforeTest(groups = { "androidApp" })
	public void setUp() throws IOException {
		mode = new PropertyManager().getExecutionMode();
		driver = (AndroidDriver<MobileElement>) new DriverManager(mode).setDriver();
		calculatorApp = new CalculatorApp(driver);
	}

	@Test(groups = { "androidApp" })
	public void calculatorTest() throws IOException {
		calculatorApp.enterNumber(1);
		calculatorApp.clickPlus();
		calculatorApp.enterNumber(2);
		assertEquals(calculatorApp.getResult(), 3);
	}

	@AfterTest(groups = { "androidApp" })
	public void teardown() {
		driver.quit();
	}

}
