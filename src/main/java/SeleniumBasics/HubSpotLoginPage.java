package SeleniumBasics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HubSpotLoginPage 
{

	public static void main(String[] args) throws InterruptedException 
	{
		By username = By.id("username"); // Static method - calling by class name
		By pwdwrd = By.id("password");
		By loginButton = By.id("loginBtn");
		
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_Driver("chrome");
		br.launchUrl("ttps://app.hubspot.com/login");
		Thread.sleep(5000);
		System.out.println(br.getPageTitle());
		
		
		ElementUtil ele = new ElementUtil(driver);
		ele.doSendKeys(username, "xyz@gmail.com");
		ele.doSendKeys(pwdwrd, "selenium20");
		ele.doClick(loginButton);
		
		br.quitBrowser();
	}

}
