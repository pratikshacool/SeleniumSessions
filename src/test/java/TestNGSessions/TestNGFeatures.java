package TestNGSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGFeatures 
{
	
	// Global preconditions
	//Pre conditions
	//Test steps
	// Actual Vs Expected
	//Pass/Fail
	
//	before suites
//	before test
//	before class
	
//		before method
//			home page test
//		after method
	
//		before method
//			login test
//		after method
	 
//	after class
//	after test
//  after suite
	
	@BeforeSuite // Annotation will be applied on a specific method. It is used for applying this particular precondition on a particular method
	public void beforeSuite()
	{
		System.out.println("before suites---Create the user");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("before test---- Add user data");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("before class---- Database connection");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("before method--- Login into the app");
	}
	
	@Test
	public void userDataTest() // It will execute on alphabetic order
	{
		System.out.println("user data test");
	}
	
	@Test
	public void userProfileTest()
	{
		System.out.println("user profile test");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method--- Logout");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("after class---- Disconnet with DB");
	}
	

	@AfterTest
	public void afterTest()
	{
		System.out.println("after test---- Delete the user data");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("after suite--- Delete the user");
	}
	
	
	
	
	
	
	
}
