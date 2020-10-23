package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		//Explicitly wait->>
		
		//1. Webdriver wait
		//2. Fluent wait
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		
//		WebDriverWait wait1 = new WebDriverWait(driver, 10);
//		//wait1.until(ExpectedConditions.titleIs("Hubspot Login"));
//		wait1.until(ExpectedConditions.titleContains("Login"));
//		
//		System.out.println(driver.getTitle());
//		
		String loginTitle = waitForPageTitlePresent("Login",5);
		System.out.println(loginTitle);
		
		
		By email = By.id("username");
		By pwd = By.id("password");
		By login = By.id("loginBtn");
		By signUpLink = By.linkText("Sign up");
		By firstName = By.id("uid-firstName-5");
		
		
		
		waitForElementToBeLocated(email, 10).sendKeys("abc@gmail.com");
		
		driver.findElement(pwd).sendKeys("12345");
		driver.findElement(login).click();
		
		waitForElementToBeLocated(signUpLink, 5).click();
		
		String signUp_Title = waitForPageTitlePresent("CRM", 10);
		System.out.println(signUp_Title);
		
		waitForElementToBeLocated(firstName, 10).sendKeys("prat");
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element_email = wait.until(ExpectedConditions.presenceOfElementLocated(email));
		
		//webdriverwait is not a global wait- we can customize it
		//it will be applied to a specific element
		//we can customize this wait
		//it can be used for non web elements -- title, url, alerts
		

//		element_email.sendKeys("abc@gmail.com");
//		
//		driver.findElement(pwd).sendKeys("12345");
//		driver.findElement(login).click();
	}
	
	public static WebElement waitForElementToBeLocated(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static String waitForPageTitlePresent(String titleValue, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(titleValue));
		return driver.getTitle();
	}
}
