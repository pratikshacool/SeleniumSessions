package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForClickableElements
{
	static WebDriver driver;

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		
		
		By signupLink = By.linkText("Sign up");
				
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.elementToBeClickable(signupLink)).click();
		
//		ElementUtil ele = new ElementUtil(driver);
//		ele.clickWhenReady(signupLink, 10);

		
		WebElement  signUpLinkelElement = driver.findElement(signupLink);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(signUpLinkelElement)).click(); // element should be visible on the page of DOM. It has some height or width

		
	}

}
