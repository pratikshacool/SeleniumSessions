package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle 
{
	static WebDriver driver;

	public static void main(String[] args) 
	{

		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		WebElement industry = driver.findElement(By.id("Form_submitForm_Industry"));
		
		//dropdown with select HTML tag -- we have to use Select class in selenium
		Select select_industry = new Select(industry);
		select_industry.selectByIndex(5);
		select_industry.selectByVisibleText("Aerospace");
		select_industry.selectByValue("Education");
		
		
		By industry1 = By.id("Form_submitForm_Industry");

		doDropDownSelectByVisibleText(industry1, "Healthcare");
	}
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void doDropDownSelectByVisibleText(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
		
	}
	public static void doDropDownSelectByValue(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		
	}
	public static void doDropDownSelectByIndex(By locator, int index)
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
}
