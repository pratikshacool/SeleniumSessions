package SeleniumBasics;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser 
{

	public static void main(String[] args) 
	{
		// No browser is launched
	    // Testing is happening in the background
		// Slightly faster than normal UI version
		
		//WebDriverManager.chromedriver().setup();
		//ChromeOptions co = new ChromeOptions();// It actually block the UI- UI is not getting launched.. Disadvantages for heavy applications
		//co.addArguments("--headless");
		
		//WebDriver driver = new ChromeDriver(co);
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		
		WebDriver driver = new FirefoxDriver(fo);
		driver.get("http:www.amazon.com");
		
		String title = driver.getTitle();
		System.out.println("Title of the page" + title);
		driver.quit();
	}

}
