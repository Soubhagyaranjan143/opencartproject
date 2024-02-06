package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistrationpage extends Basepage {
	public Accountregistrationpage(WebDriver driver)
	{
	super (driver);	
	}
	@FindBy (name="firstname")
	WebElement  txtFirstname;
	@FindBy (name="lastname")
	WebElement txtLastname;
	@FindBy(name="email")
	WebElement txtEmail;
	@FindBy(name="telephone")
	WebElement txtTelephone;
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(name="confirm")
	WebElement txtConfirmpassword;
	@FindBy(name="agree")
	WebElement chkdpolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
		
	}
	public void setEmail(String email)
	{
		 txtEmail.sendKeys(email);
	}
	public void setTelephone(String tel)
	{
		 txtTelephone.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void setconfirmpassword(String pwd)
	{
		txtConfirmpassword.sendKeys(pwd);	
	}
	public void setprivacypolicy()
	{
		chkdpolicy.click();	
	}
	public void clickcontinue()
	{
		btnContinue.click();	
	}
	
	public String getconfirmationmsg()
	{
		try {
			return (msgConfirmation.getText());
			}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
