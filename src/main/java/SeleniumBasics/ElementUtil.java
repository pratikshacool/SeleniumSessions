package SeleniumBasics;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil 
{
	WebDriver driver;
	
	
	// Create the element
	
	public ElementUtil(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public void doSendKeys(By locator, String value)
	{
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	public void doActionsSendKeys(By locator, String value)
	{
		WebElement element = getElement(locator);
		Actions action = new Actions(driver);
		action.sendKeys(element, value).perform();	
	}
	
	public void doActionClick(By locator)
	{
		WebElement element = getElement(locator);
		Actions action = new Actions(driver);
		action.click(element).perform();
	}
	
	public String doGetText(By locator)
	{
		return getElement(locator).getText();
	}
	
	public Boolean doIsDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	
	public  Boolean checkWebElementPresent(By locator)
	{
		int elementCount = driver.findElements(locator).size();
		System.out.println("total elements count: " + elementCount + " for " + locator);
		
		if(elementCount > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	// ****************** Dropdown Utils *********************************
	
	
	public void doDropDownSelectByVisibleText(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
		
	}
	
	public void doDropDownSelectByValue(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		
	}
	
	public void doDropDownSelectByIndex(By locator, int index)
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
	
	public  List<String> getAllDropDownOptionsList(By locator)
	{
		WebElement element = getElement(locator);
		List<String> optionsValueList = new ArrayList<String>();
		
		Select select = new Select(element);
		
		List<WebElement> optionsList = select.getOptions();
		
		for(int i = 0; i < optionsList.size(); i++)
		{
			String text = optionsList.get(i).getText();
			System.out.println(text);
			optionsValueList.add(text);
		}
		return optionsValueList;
	}

	public  void selectValueFromDropDown(By locator,String value)
	{
		WebElement element = getElement(locator);
		
		
		Select select = new Select(element);
		
		List<WebElement> optionsList = select.getOptions();
		
		for(int i = 0; i < optionsList.size(); i++)
		{
			String text = optionsList.get(i).getText();
			if(text.equals(value))
			{
				optionsList.get(i).click();
				break;
			}
			
		}
		
	}
	/////************************* Wait Utils ********************************
	
	public  List<WebElement> visibilityOfAllElements(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public  List<Object> getPageLinksText(By locator, int timeOut)
	{
		//visibilityOfAllElements(locator, timeOut).stream().forEach(ele -> System.out.println(ele.getText()));
		 return visibilityOfAllElements(locator, timeOut).
		stream().filter(ele -> !ele.getText().contains(" ")).map(ele -> ele.getText()).collect(Collectors.toList());
	}
	
	public WebElement waitForElementToBeLocated(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public WebElement waitForElementToBeVisible(By locator, int timeOut)
	{
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	public String waitForPageTitlePresent(String titleValue, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(titleValue));
		return driver.getTitle();
	}
	
	public Alert waitForAlertToBePresent(int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public boolean waitForUrl(String url,int timeOut)// used to check the url(non web elements)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		return wait.until(ExpectedConditions.urlContains(url));
	}
	
	public void clickWhenReady(By locator, int timeOut)// It is used to check element is visible and enabled
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public  WebElement waitForElementWithFluentWait(By locator, int timeOut, int pollingTime) 
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(pollingTime))
					.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
