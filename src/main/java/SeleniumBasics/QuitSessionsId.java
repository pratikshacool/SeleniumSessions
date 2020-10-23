package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitSessionsId 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "/Users/pratiksha/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver(); //launch chrome //
		
		driver.get("http://www.google.com");//enter url 
		
		String title = driver.getTitle(); 
		System.out.println("The title of the page: " + title);
		
		driver.quit();
		//Browser is closed .. session id is still there but its invalid
	
		
		System.out.println(driver.getTitle());//NoSuchSessionException : Session ID is null. Using WebDriver after calling quit()? after quiting

		//After quit - session id is null
		//After Close - session id is invalid
		//Chromedriver.exe file is responsible to execute the server
	}

}
