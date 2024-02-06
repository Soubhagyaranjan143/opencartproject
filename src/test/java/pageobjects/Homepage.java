package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
	public Homepage (WebDriver driver)
	{
		super (driver);
	}
	@FindBy(xpath ="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
    WebElement lnkRegister;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement lnkLogin;
	public void clickmyAccount()
	{
	lnkMyaccount.click();
	}
	public void clickRegister()
	{
	lnkRegister.click();	
	}
	public void clickLogin()
	{
	lnkLogin.click();
	}
	
}
