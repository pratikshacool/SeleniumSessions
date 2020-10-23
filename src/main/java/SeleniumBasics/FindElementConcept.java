package SeleniumBasics;


import java.util.List;

import javax.naming.LinkLoopException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementConcept 
{

	public static void main(String[] args) 
	{
		// find out total no of links on the webpage
		
		// print the text of each link
		
		// ignore the blank text link
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		
		System.out.println("total links :" + linkslist.size());
		
		for (int i =0 ; i < linkslist.size() ; i++)
		{
			String text = linkslist.get(i).getText();
			//System.out.println(text);
			if(! text.isEmpty())
			{
				// to get the property of the webelement
				System.out.println(i + "-->> " + text);
				System.out.println(linkslist.get(i).getAttribute("href"));
			}
		}
		// for each
		for (WebElement e : linkslist)
		{
			String text= e.getText();
			
			if(! text.isEmpty())
			{
				System.out.println(text);
				System.out.println(e.getAttribute("href"));
			}
		}
		
		//Streams
		
		linkslist.stream().forEach(ele -> System.out.println(ele.getText()));
	}

}
