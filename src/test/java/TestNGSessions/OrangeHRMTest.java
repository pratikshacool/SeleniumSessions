package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest 
{
	WebDriver driver;
	
	@BeforeTest
	public void setUp() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
	}
	
	
	@Test(priority=1) // It will not be executed on the basis of alphabetic order
	public void orangeHRMLogoTest() 
	{
		Assert.assertTrue(driver.findElement(By.className("nav-logo")).isDisplayed());
	}
	
	@Test(priority=2)
	public void freeTrialButtonTest() 
	{	
		String text = driver.findElement(By.xpath("//a[@href='/orangehrm-30-day-trial/']")).getText();
		System.out.println("free trial button text is : " + text);
		Assert.assertEquals(text, "FREE 30 DAY TRIAL");
	}
	
	@Test(priority=3)
	public void featureLinkTest() 
	{
		Assert.assertTrue(driver.findElement(By.linkText("Features")).isDisplayed());
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}
	
	
	
	
	
	
	
}
