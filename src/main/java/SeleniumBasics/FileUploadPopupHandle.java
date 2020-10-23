package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopupHandle
{

	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/seeker/registration");
		//Thread.sleep(5000);
		
		// type= "file" // it should  be there
		
		
		driver.findElement(By.id("file-upload")).sendKeys("/Users/pratiksha/Downloads/Java-Selenium Notes.docx");
	}

}
