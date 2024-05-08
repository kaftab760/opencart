package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_006_EndToEndTest extends BaseClass{

	
	@Test(groups= {"master"})
	public void endToendTest() throws InterruptedException
	{
		// Step 1: Account Registration
		// Step 2: Login
		// Step 3: search & add product to cart
		// Step 4: Shopping cart
		// step 5: Checkout Product
		
		
		SoftAssert myassert = new SoftAssert(); //Soft assertions
		
		//Account Registration
		System.out.println("Account Registration................");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString() + "@gmail.com");
		regpage.setPassword(randomNumber());
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		Thread.sleep(3000);

		
		String confmsg = regpage.getConfirmationMsg();
		System.out.println(confmsg);
		
		myassert.assertEquals(confmsg, "Your Account Has Been Created!"); //validation
		
		MyAccountPage mc=new MyAccountPage(driver);
		mc.clickLogout();
		Thread.sleep(3000);
		
		//Login
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin(); // Login button
		
		System.out.println("Going to My Account Page? "+ mc.isMyAccountPageExists());
		myassert.assertEquals(mc.isMyAccountPageExists(), true); //validation

		// search & add product to cart
		System.out.println("search & add product to cart...............");
		hp.enterProductName(p.getProperty("searchProductName"));
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
		if(sp.isProductExist("iPhone"))
		{
			sp.selectProduct("iPhone");
			sp.setQuantity("2");
			sp.addToCart();
			
		}
		
		Thread.sleep(3000);
		System.out.println("Added product to cart ? "+ sp.checkConfMsg());
		myassert.assertEquals(sp.checkConfMsg(),true);
		
		//Shopping cart
		System.out.println("Shopping cart...............");
		ShoppingCartPage sc=new ShoppingCartPage(driver);
		sc.clickItemsToNavigateToCart();
		sc.clickViewCart();
		Thread.sleep(3000);
		
		String totprice=sc.getTotalPrice();
		System.out.println("total price is shopping cart: "+totprice);
		myassert.assertEquals(totprice, "$246.40");   //validation
		sc.clickOnCheckout(); //navigate to checkout page
		Thread.sleep(3000);
		
		myassert.assertAll(); //conclusion
		
		
	}
	
	
}
