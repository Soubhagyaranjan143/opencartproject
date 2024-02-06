package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageobjects.Homepage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class Tc002LoginTest extends Baseclass{
	@Test(groups= {"Sanity","Master"})
	public void test_login()
	{
		logger.info("Starting Tc002LoginTest");
		try {
			Homepage hp =new Homepage(driver);
			hp.clickmyAccount();
			hp.clickLogin();
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPassword(rb.getString("password"));
			lp.clickLogin();
			
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExist();
			Assert.assertEquals(targetpage,true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Finished Tc002LoginTest");
	}

}
