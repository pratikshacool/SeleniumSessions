package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class JqueryDropDownHandle 
{	
	static WebDriver driver;
	static String SELECT_ALL_OPTIONS = "all"; 	 

	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		Thread.sleep(2000);
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);
		By choices_span = By.xpath("//span[@class='comboTreeItemTitle']");
		
		
		//Multiselection
		//selectChoiceFromDropDown(choices_span, "choice 6 2 2",  "choice 3",  "choice 6 2 3", "choice 7");//it will select single choice
		
		//Single selection
		//selectChoiceFromDropDown(choices_span , "choice 2");// it will select single choice
		
		// select all
		selectChoiceFromDropDown(choices_span , JqueryDropDownHandle.SELECT_ALL_OPTIONS);
	}
	
	
	/**
	 *  This method is used to select single, multiple and all the choices from the dropdown
	 *  Please pass the unique values
	 * @param locator 
	 * @param value...
	 */
	public static void selectChoiceFromDropDown(By locator, String... value)// string array (...) value parameter gives you string array
	{
		
		List <WebElement> choiceList = driver.findElements(locator);
		if(! value[0].equalsIgnoreCase("all"))
		{
			for(int i = 0; i < choiceList.size(); i++)
			{
				String text = choiceList.get(i).getText();
				System.out.println(text);
				
				for(int j = 0; j < value.length; j++)
				{
					if(text.equals(value[j]))
					{
						choiceList.get(i).click();
						break;
					}
				}
			}
		}
		
		// select all values:
		else
		{
			try
			{
				for(int a = 0; a< choiceList.size(); a++)
					choiceList.get(a).click();
			}
		
			catch(Exception e)
			{
				
			}
				
		}
	}

}
