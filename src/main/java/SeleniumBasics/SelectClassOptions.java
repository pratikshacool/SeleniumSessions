package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassOptions 
{

	public static void main(String[] args) 
	{
		 WebDriver driver;

			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
			
			Select select = new Select(driver.findElement(By.id("Form_submitForm_Industry")));
			System.out.println(select.isMultiple());
			
			select.getAllSelectedOptions();
			
			select.getFirstSelectedOption();
			
			
		

	}

}
