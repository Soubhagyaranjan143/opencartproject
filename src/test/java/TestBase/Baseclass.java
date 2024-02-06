package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Date;
import java.util.ResourceBundle;

public class Baseclass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb= ResourceBundle.getBundle("config");
		logger= LogManager.getLogger(this.getClass());
	if(br.equalsIgnoreCase("edge"))
	{
		EdgeOptions options= new EdgeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable automation"});
      driver = new EdgeDriver(options);
	}
	else if(br.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if(br.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		logger.info("launching the browser");
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown()
	{
	logger.info("closing the app");
	driver.quit();	
	}
	
	
	public String randomstring()
	{
	 String generatedstring= RandomStringUtils.randomAlphabetic(5);
	 return generatedstring;
	}
	public String randomNumber()
	{
	 String generatednum = RandomStringUtils.randomNumeric(10);
	 return generatednum;
	}
	public String randomAlphanumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(5);
		String num= RandomStringUtils.randomNumeric(8);
		return (str+ "@"+num);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
	

}
