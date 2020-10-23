package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FirefoxLaunch 
{
	static WebDriver driver;// we dont need to initialize the class variable .. its static because we are using it in static main method

	public static void main(String[] args) 
	{
		//cross browser testing:
		
		String browser = "opera";
		//WebDriver driver = null;// we need to initialize the local variable with its default value
		
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/pratiksha/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/pratiksha/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		
		else if(browser.equals("safari"))
		{
			driver = new SafariDriver();// Dont need to write setproperty as apple does not provide any .exe file 
		}
		
		else
		{
			System.out.println("plz pass the correct browser name : " + browser);
		}
		
		
		//geckodriver.exe - mozilla
		
		driver.get("http://www.google.com");// enter url

		String title = driver.getTitle();// get the title of the page
		System.out.println("page title is: " + title);

		// verification point/checkpoint: actual vs expected
		if (title.equals("Google")) 
		{
			System.out.println("correct title");
		} 
		else 
		{
			System.out.println("in correct title");
		}

		System.out.println(driver.getCurrentUrl());

		// System.out.println(driver.getPageSource());

		driver.quit();

	}

}
