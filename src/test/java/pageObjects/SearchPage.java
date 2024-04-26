package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='product-list']//child::div//img")
	List<WebElement> searchProducts;

	public boolean isProductExist(String productName) {
		boolean flag = false;

		for (WebElement product : searchProducts) {
			if (product.getAttribute("title").equals(productName)) {
				flag = true;
				break;
			}
		}

		return flag;
	}

}
