package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//imp wait - is a dynamic wait - it is the maximum timeout for the element to load
		//its only applicable for webelements on the page
		//findElement and findElements -- whenever you are creating webelement
		//global wait -- its applicable for all webelements throughout the driver session
		//it wont work with non webelements -- title, url

		//Thread.sleep(5000); // Static wait used to wait for the webelement to be loaded in the webpage
		
		driver.findElement(By.id("username")).sendKeys("abc@gmail.com");
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);// nullify the implicit wait
		
		driver.findElement(By.id("password")).sendKeys("abc@123");
		driver.findElement(By.id("loginBtn")).click();
	
		//e4
		//e5
		//e6 -- clicking on it--a new page is coming
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// new wait
		
		//e7 -- need some wait..element is coming after 5 seconds
	}

}
