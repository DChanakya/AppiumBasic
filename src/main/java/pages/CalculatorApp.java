package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import testObjects.ObjectRepository;

public class CalculatorApp extends Activity{

	public CalculatorApp(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	public void enterNumber(int number) {
		String id = String.format(ObjectRepository.CalculatorObjects.getNumber(), String.valueOf(number));
		getElementById(id).click();
	}
	
	public void clickPlus() {
		getElementById(ObjectRepository.CalculatorObjects.getPlus()).click();
	}

	public int getResult() {
		getElementById(ObjectRepository.CalculatorObjects.getEquals()).click();
		return Integer.parseInt(getElementById(ObjectRepository.CalculatorObjects.getResult()).getText());
	}
}
