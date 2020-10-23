package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept 
{ 
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(5000);
		
		
		
		/*
		 * // Id // 1st approach - Create web element + perform some actions (click, sendkeys, gettext)
			 driver.findElement(By.id("username")).sendKeys("xyz@gmail.com");
			 driver.findElement(By.id("password")).sendKeys("selenium20");
			 driver.findElement(By.id("loginBtn")).click();
			 
		 // 2. name: If its unique
		 	driver.findElement(By.name("username")).sendKeys("test@gmail.com");
		 
		 // 3. ClassName : Its not a unique attribute.  We can use it if its unique
		  	driver.findElement(By.className("login-email")).sendKeys("xyz@gmail.com");
		  
		 // 4. Xpath : Its an address of the element in HTML DOM but its not an attribute (inspect web element + copy + copy xpath)
		 	driver.findElement(By.xpath("//*[@id='username']")).sendKeys("xyz@gmail.com"); 
		 
		 // 5. CSS selector : Its not an attribute (inspect web element + copy + copy selector)
		  	driver.findElement(By.cssSelector("#username")).sendKeys("xyz@gmail.com"); 
		 
		 // 6. LinkText : Its used only for link
		  	driver.findElement(By.linkText("Sign up")).click();
		  
		  // 7. Partial LinkText : Its used for long link text
		 	driver.findElement(By.partiallinkText("Sign")).click();
		  
		  // 8. Tag Name : HTML tag
		    String header = driver.findElement(By.tagName("h1")).getText();
		    System.out.println(header);
		  
		 
		 * // 2nd approach - first we are Creating the Web element WebElement emailid =
		 * driver.findElement(By.id("username")); WebElement pwd =
		 * driver.findElement(By.id("password")); WebElement loginBtn =
		 * driver.findElement(By.id("loginBtn"));
		 * 
		 * //2nd approach- 2. we are Entering the values - Performing actions on those
		 * web element emailid.sendKeys("xyz@gmail.com"); pwd.sendKeys("selenium20");
		 * loginBtn.click();
		 */
		// 3rd approach - By locator - POM Object
		By username = By.id("username"); // Static method - calling by class name
		By pwdwrd = By.id("password");
		By loginButton = By.id("loginBtn");
		
		WebElement emailid1 =  driver.findElement(username);
		WebElement pwd1 = driver.findElement(pwdwrd);
		WebElement loginBtn1 = driver.findElement(loginButton);
		
		emailid1.sendKeys("xyz@gmail.com");
		pwd1.sendKeys("selenium20");
		loginBtn1.click();
	
		
		getElement(username).sendKeys("admin@gmail.com");
		getElement(pwdwrd).sendKeys("selenium20");
		getElement(loginButton).click();
	}
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value)
	{
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator)
	{
		getElement(locator).click();
	}
}
