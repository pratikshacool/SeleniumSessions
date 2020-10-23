package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath_1
{

	public static void main(String[] args)
	{
		
		WebDriver driver = new ChromeDriver();
		
		
		// xpath: its a locator not an attribute in HTML DOM
		//1. Absolute xpath
		//2. Relative xpath
		

		//abs xpath: //html/body/div[2]/div/div[3]/div[4]/div/input
		
		//relative xpath: custom xpath using xpath functions and axes

		//Synatx:
		// htmltag[@attr1='value']
			
		//input[@id='username']
		//input[@type='email']
		
		// htmltag[@attr1='value' and @attr2='value']
		//input[@id='username' and @type='email']
		//input[@id='username' and @type]
		//input[@id and @type] - if you are getting only one element
		
		//text() -It is used when only text is available. for link, header, footer etc
		//Syntax:
		//htmltag[text()='value']
		//h2[text()='Refreshing business software that your teams will love'
		//a[text()='Platform']
		
		//htmltag[@id='value' and text()='value']
		//a[@href='/platform/' and text()='Platform']
		//a[text()='Platform' and @href='/platform/']
		
		
		//contains() - It is used for dynamic attribute or dynamic text
		//Syngtax:
		//htmltag[contains(@attr1, value)]
		//input[contains(@id,'username')]
		//input[contains(@id, 'user')]
		//input[contains(@id, 'name')]
		
		//input[contains(@id, 'user_')]
		//<id = 'user_123'>
		//<id = 'user_12343'>
		//<id = 'user_123323'>
		
		
		//contains with text():
		//a[contains(text(),'Platform')]
		//a[contains(text(),'Plat')]
		//a[contains(text(),'Plat') and @href='/platform/']
		//a[contains(text(),'Plat') and contains(@href='/platform/')]
		//input[contains(@type, 'submit') and contains(@value, 'Login')]
		
		
		//Class attribute in xpath:
		
		//input[@class='form-control private-form__control login-email']
		driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")); // We can use more than one class in xpath
		driver.findElement(By.className("form-control private-form__control login-email"));  //we can use only one class name with By.className
		
		// Indexing:
		
		//input[contains(@class,form-control)]- 2
		//(//input[contains(@class,'form-control')])[1]- 1 if the two field has same class
		//(//input[contains(@class,'form-control')])[position()=2]
		// (//input[@type='text'])[position()=6]
		//(//input[@type='text'])[last()]
		
		//starts-with();
		
		//input[starts-with(@id,'Form_submitForm_F')]
		//input[starts-with(@name,'First')]
		
		//parent to child:
		//single slash / - means direct child
		//ul[@class='footer-nav']/li/a
		//div[contains(@class,'copyrights-nav')]/a
		
		//double slash --> direct + indirect child 
		
		//div[contains(@class,'copyrights-nav')]/a --> 8
		//div[contains(@class,'copyrights-nav')]//a -->8
		
		
		//form[@id='hs-login']/div --> 8 (/- direct child)
		//form[@id='hs-login']//div --> 20 (//- indirect child)
		
		//backward traversing: child to parent
		
		//input[@id='username']/../../../../../../..
		
		
		//child to parent: parent tag
		
		//input[@id='username']//parent::div ---> Immediate parent of the child
		//input[@id='username']//ancestor::form ---> Grandparent of the child
		//input[@id='username']//ancestor::div
		
		//parent to child : child tag
		
		//div[@class='private-form__input-wrapper']//child::input -- 2
		//div[@class='private-form__input-wrapper']//child::input[@id='username'] --1
		
		//parent to child:
		
		//form[@id='hs-login']/div --> 8 (/- direct child)
		//form[@id='hs-login']//div 
		//form[@id='hs-login']/div --> 8
		//form[@id='hs-login']//div --> 20g
		
		//form[@id='Form_submitForm']//following::input[@type='text'] -6
		//input[@id='Form_submitForm_FirstName']//preceding::div --> 60	
		
		
		//Xpath Axes:
		//a[text()='Aanuj D']//parent::td//preceding-sibling::td/input[@type='checkbox']
		//a[text()='Aashish P']//parent::td//preceding-sibling::td/input[@type='checkbox']
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
