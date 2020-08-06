package testObjects;

public class ObjectRepository {
	private ObjectRepository() {
	}

	public static class AmazonPageObjects {

		private static String webSearchBar = "//*[@id='twotabsearchtextbox']";
		private static String androidSearchBar = "//*[@id='nav-search-keywords']";
		private static String androidTile = "//*[contains(text(),'%s')]";
		private static String webTile = androidTile;
		private static String androidAddToCart = "//*[@id='add-to-cart-button']";
		private static String webAddToCart = androidAddToCart;
		private static String androidProceedToBuy = "//*[contains(text(),'Proceed to Buy')]";
		private static String webProceedToBuy = androidProceedToBuy;
		private static String androidPopupClose = "//*[@class='sparkle-close']";

		private AmazonPageObjects() {
		}

		public static String getAndroidPopupClose() {
			return androidPopupClose;
		}

		public static String getWebProceedToBuy() {
			return webProceedToBuy;
		}

		public static String getAndroidProceedToBuy() {
			return androidProceedToBuy;
		}

		public static String getWebAddToCart() {
			return webAddToCart;
		}

		public static String getAndroidAddToCart() {
			return androidAddToCart;
		}

		public static String getWebTile() {
			return webTile;
		}

		public static String getAndroidTile() {
			return androidTile;
		}

		public static String getAndroidSearchBar() {
			return androidSearchBar;
		}

		public static String getWebSearchBar() {
			return webSearchBar;
		}
	}

	public static class CalculatorObjects {
		private static String number = "com.google.android.calculator:id/digit_%s";
		private static String plus = "com.google.android.calculator:id/op_add";
		private static String equals = "com.google.android.calculator:id/eq";
		private static String result = "com.google.android.calculator:id/result_final";

		private CalculatorObjects() {}
		
		public static String getNumber() {
			return number;
		}

		public static String getPlus() {
			return plus;
		}

		public static String getEquals() {
			return equals;
		}

		public static String getResult() {
			return result;
		}

	}
}
