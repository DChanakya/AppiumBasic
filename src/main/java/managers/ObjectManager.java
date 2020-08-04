package managers;
import java.io.IOException;

import pageObjects.AmazonPageObjects;
import testObjects.ObjectRepository;

public class ObjectManager {
	private String executionMode = "";
	AmazonPageObjects amazonPageObjects;
	ObjectRepository objectRepository;

	public ObjectManager() throws IOException {
		objectRepository = new ObjectRepository();
		executionMode = new PropertyManager().getExecutionMode();
	}

	public AmazonPageObjects assignAmazonPageObjects() {
		amazonPageObjects = new AmazonPageObjects();
		if (executionMode.equals(ExecutionModes.WEB.getModeValue())) {
			amazonPageObjects.setSearchBar(objectRepository.getWebSearchBar());
			amazonPageObjects.setFirstTile(objectRepository.getWebTile());
			amazonPageObjects.setAddToCartButton(objectRepository.getWebAddToCart());
			amazonPageObjects.setProceedToBuy(objectRepository.getWebProceedToBuy());

		} else if (executionMode.equals(ExecutionModes.ANDROID.getModeValue())) {
			amazonPageObjects.setSearchBar(objectRepository.getAndroidSearchBar());
			amazonPageObjects.setFirstTile(objectRepository.getAndroidTile());
			amazonPageObjects.setAddToCartButton(objectRepository.getAndroidAddToCart());
			amazonPageObjects.setProceedToBuy(objectRepository.getAndroidProceedToBuy());
		}
		return amazonPageObjects;
	}
}
