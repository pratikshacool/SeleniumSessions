package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseVsQuit 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "/Users/pratiksha/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver(); //launch chrome //Seesion id- 9927b1bb5944e3d0770ad1e8e242f0ff
		//9a37a0f05edb4d3f09a5fd90c6117148
		
		driver.get("http://www.google.com");//enter url //Sid-9927b1bb5944e3d0770ad1e8e242f0ff
		
		String title = driver.getTitle(); //Sid - 9927b1bb5944e3d0770ad1e8e242f0ff
		System.out.println("The title of the page: " + title);
		
		driver.close();//Sid-9927b1bb5944e3d0770ad1e8e242f0ff
		//Browser is closed .. session id is still there but its invalid
		
		 driver = new ChromeDriver(); // new connection established with new session id
		
		System.out.println(driver.getTitle());//Session ID is invalid after closing the driver
		
			//After quit - session id is null
			//After Close - session id is invalid
			//Chromedriver.exe file is responsible to execute the server
	}

}
