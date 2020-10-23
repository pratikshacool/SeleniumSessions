package SeleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowPopUpHandle
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.popuptest.com/goodpopups.html");
		
		driver.findElement(By.linkText("Good PopUp #3")).click();
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator(); // Iterator is used to get the data from those collection which are not maintaining any index 
		// Iterator point just above the set object
		// It does not have any values so that we need to move the pointer to next location 
		
		String parentWindowId = it.next();
		System.out.println("parent window id is: " + parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("child window id is: " + childWindowId);
		
		driver.switchTo().window(childWindowId);
		System.out.println("Child window title is :" + driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window title is :" + driver.getTitle());
		
		driver.quit();
	}

}
