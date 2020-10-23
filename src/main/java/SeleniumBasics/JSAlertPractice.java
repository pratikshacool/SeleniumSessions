package SeleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertPractice 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		if(text.equals("I am a JS Prompt"))
		{
		
			System.out.println("Correct alert message");
		}
		
		alert.sendKeys("Hello");// for entering text into the JS prompt
		alert.accept();
		//alert.dismiss();
		
		
		

	}

}
