package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm 
{

	public static void main(String[] args) throws InterruptedException 
	{
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_Driver("chrome");
		br.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		Thread.sleep(7000);
		System.out.println(br.getPageTitle());
		
		By ValidUrl = By.id("Form_submitForm_subdomain");
		By First_Name = By.id("Form_submitForm_FirstName");
		By Last_Name = By.id("Form_submitForm_LastName");
		By Email_Id = By.id("Form_submitForm_Email");
		By Job_Title  = By.id("Form_submitForm_JobTitle");
		
		WebElement noOfEmployee = driver.findElement(By.id("Form_submitForm_NoOfEmployees"));
		Select dd_noOfEmp = new Select(noOfEmployee);
		WebElement industry = driver.findElement(By.id("Form_submitForm_Industry"));
		Select dd_industry = new Select(industry);
		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		Select dd_country = new Select(country);
		
		dd_noOfEmp.selectByIndex(5);
		
		dd_industry.selectByIndex(6);
		
		dd_country.selectByIndex(7);
		
		By Company_Name = By.id("Form_submitForm_CompanyName");
		By Contact_No = By.id("Form_submitForm_Contact");
		
		
		ElementUtil ele = new ElementUtil(driver);
		ele.doSendKeys(ValidUrl, "https://www.google.com");
		ele.doSendKeys(First_Name, "Raghav");
		ele.doSendKeys(Last_Name, "Joshi");
		ele.doSendKeys(Email_Id, "xyz@gmail.com");
		ele.doSendKeys(Job_Title, "Manager");
		ele.doSendKeys(Company_Name, "Cognizant");
		ele.doSendKeys(Contact_No, "9821455678");
		
		br.quitBrowser();
	}

}
