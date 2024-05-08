package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage
	{
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	//@FindBy(xpath="//button[@aria-expanded='false']")
	@FindBy(xpath="//i[@class='fa-solid fa-cart-shopping']//parent::button")
	WebElement btnItems;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement lnkViewCart;
	
	@FindBy(xpath="//*[@id='checkout-total']//tr[4]//strong[text()='Total']//following::td")
	
	//*[@id='checkout-total']//tr[4]//strong[text()="Total"]//following::td
	WebElement lblTotalPrice;  //$202.00
	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement btnCheckout;
	
	public void clickItemsToNavigateToCart()
	{
		btnItems.click();
	}
	
	public void clickViewCart()
	{
		lnkViewCart.click();
	}
	
	public String getTotalPrice()
	{
		return lblTotalPrice.getText();
	}
	
	public void clickOnCheckout()
	{
		btnCheckout.click();
	}
}
