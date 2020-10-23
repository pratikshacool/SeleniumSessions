package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		// Get total no of images
		
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		System.out.println("Total Images:" + imageList.size());
		
		for(int i=0; i < imageList.size(); i++)
		{
			String source =	imageList.get(i).getAttribute("src");
			String altText = imageList.get(i).getAttribute("alt");
			
			System.out.println(source);
			System.out.println(altText);
		}
		// for each
		for (WebElement e : imageList)
		{
			String text= e.getText();
			
			if(! text.isEmpty())
			{
				System.out.println(text);
				System.out.println(e.getAttribute("href"));
			}
		}
		
		// Streams
		
		
	}

}
