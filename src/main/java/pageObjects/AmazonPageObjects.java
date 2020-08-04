package pageObjects;

public class AmazonPageObjects {
	private String searchBar = "";
	private String firstTile = "";
	private String addToCartButton = "";
	private String proceedToBuy = "";
	
	public String getProceedToBuy() {
		return proceedToBuy;
	}

	public void setProceedToBuy(String proceedToBuy) {
		this.proceedToBuy = proceedToBuy;
	}

	public String getAddToCartButton() {
		return addToCartButton;
	}

	public void setAddToCartButton(String addToCartButton) {
		this.addToCartButton = addToCartButton;
	}

	public String getFirstTile() {
		return firstTile;
	}

	public void setFirstTile(String firstTile) {
		this.firstTile = firstTile;
	}

	public String getSearchBar() {
		return searchBar;
	}

	public void setSearchBar(String searchBar) {
		this.searchBar = searchBar;
	}

}
