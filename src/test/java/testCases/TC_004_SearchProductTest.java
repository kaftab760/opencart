package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass {

	@Test(groups = { "master" })
	public void verify_productSearch() {
		logger.info(" Starting TC_004_SearchProductTets ");

		try {

			HomePage hm = new HomePage(driver);
			hm.enterProductName("mac");
			hm.clickSearch();

			SearchPage sp = new SearchPage(driver);
			boolean prodStatus = sp.isProductExist("MacBook");

			Assert.assertEquals(prodStatus, true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTets ");

	}

}
