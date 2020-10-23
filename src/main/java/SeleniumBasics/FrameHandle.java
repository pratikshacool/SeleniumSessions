package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(2);// first need to switch the focus on frame then only driver can access the frame element
		//driver.switchTo().frame("main");// we can access it by name attribute because index might be change
		driver.switchTo().frame(driver.findElement(By.name("main"))); //Create the frame webelement and the switch to frame by using name attribute
		
		String text = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();

	}

}