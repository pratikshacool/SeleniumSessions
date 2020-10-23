package MyTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest
{
	@Test(priority = 1)
	public void amazonTitleTest() 
	{
		driver.get("https://www.amazon.com");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}

	@Test(priority = 2)
	public void amazonUrlTest()
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("amazon"));
	}
	
}
