package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovement
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
		Thread.sleep(4000);
		
		WebElement content_parentMenu = driver.findElement(By.className("menulink"));
		
		// Mouse hover actions
		
		Actions action = new Actions(driver);
		//// In actions class first we need collect the action then build and perform an action on it
		action.moveToElement(content_parentMenu).build().perform(); // if only one action is performing we just need to write .perform() 
		
		driver.findElement(By.linkText("COURSES")).click();
	}

}
