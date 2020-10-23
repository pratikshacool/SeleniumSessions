package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AuthPopUpHandle
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("http://the-internet.herokuapp.com/basic_auth");
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");// pass the username and password for authentication pop up
		

	}

}
