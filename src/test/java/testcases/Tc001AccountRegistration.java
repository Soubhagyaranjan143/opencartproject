package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageobjects.Accountregistrationpage;
import pageobjects.Homepage;

public class Tc001AccountRegistration extends Baseclass {
	@Test(groups = {"Regression","Master"})
	public void test_account_registration()
	{
		logger.info("***starting TC001AccountRegistration***");
		try {
			Homepage hp =new Homepage(driver);
			hp.clickmyAccount();
			logger.info("clicked on my account link");
			hp.clickRegister();
			logger.info("clicked on register link");
		Accountregistrationpage regpage = new Accountregistrationpage(driver);
		logger.info("providing customer details");
		regpage.setFirstname(randomstring().toUpperCase());
		regpage.setLastname(randomstring().toLowerCase());
		regpage.setEmail(randomstring()+"@gmail.com");
		regpage.setTelephone(randomAlphanumeric());
		String password = randomAlphanumeric();
		regpage.setPassword(password);
		regpage.setconfirmpassword(password);
		regpage.setprivacypolicy();
		regpage.clickcontinue();
		logger.info("clicked on continue");
		
		String confmsg= regpage.getconfirmationmsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{ 
			logger.info("test passed");
			Assert.assertTrue(true);
		}
		else 
		{
			logger.error("test failed");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished TC001AccountRegistration***");
		
	}
	

}
