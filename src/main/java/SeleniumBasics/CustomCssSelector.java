package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCssSelector
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();

		//custom css:
			
		//Syntax:
	
		//id --> #id or htmltag#id
		//class --> .classname or htmltag.classname
		
		// #username
		// input#username
		// .login-email
		// input.login-email	
	
		//syntax: 
		
		//htmltag.classname#id
		
		//input.login-email#username
		
		//htmltag#id.classname
		//input#username.login-email
		
		//#id.classname
		// #username.login-email
			
		//syntax:
		
		// form-control private-form__control login-email
		// htmltag.c1.c2.c3....cn(htmltag.classname1.classname2.classname3)
		// input.form-control.private-form__control.login-email
		// .c1.c2.c3....cn
		
		//.htmltag.classname1.classname2.classname3
		// .form-control.private-form__control.login-email
	
		//htmltag.classname1.classname2.classname3#id
		// input.form-control.private-form__control.login-email#username
			
		// With css selector and xpath we can use multiple classes but with By.classname we can use only one class name
		driver.findElement(By.cssSelector("input.form-control.private-form__control.login-email"));
		driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']"));
		driver.findElement(By.className("login-email"));
			

		// htmltag[attr = 'value']
		// input[id='username'] --css selector
		//input[@id='username'] --xpath
			
		// htmltag[attr1 = 'value'][attr2 = 'value']
		// input[id='username'][type='email']
		// [id='username'][type='email']
		// [id='username'][type]
		// input[id][type]	
			
		//Parent to child
		//Syntax:
		//parenttag.classname #id
		//div.private-form__input-wrapper input#username
		
		//syntax:
		//parenttag.classname < #id
		//div.private-form__input-wrapper > input#username
		
		// ul.footer-nav > li > a
		// ul.footer-nav li a
		
		//Contains function:
		//input[id*='user'] 
		
		//Starts with
		//input[id^='user']
		
		//end with
		//input[id$='name']
		
		// input[id*='user'] -- contains
		// input[id^='user'] -- starts-with
		// input[id$='name'] -- ends-with
				
		int loginFormCount = driver.findElements(By.cssSelector("input#username, input#password, button#loginBtn")).size();
		if(loginFormCount == 3)
		{
			System.out.println("my login form is displayed with all the elements...");
		}
		
		//following-sibling in css:
		// div.private-form__input-wrapper + div
		
		//Webtables always handled by xpath not by css as backward traversing is not possible in css
		
		//nth-of-type:
		// ul.nav.navbar-nav.navbar-right li:nth-of-type(1) -- 1st  element
		// ul.nav.navbar-nav.navbar-right li:nth-of-type(n) -- all  elements
		
		//not operator in CSS:
		// form-control private-form__control login-email
		// form-control private-form__control login-password m-bottom-3
		
		// input.form-control.private-form__control:not(.login-password)
		// input.form-control.private-form__control:not(#username) // we can exclude one element at a time first collect it  and the exclude it using NOT operator
	}

}
