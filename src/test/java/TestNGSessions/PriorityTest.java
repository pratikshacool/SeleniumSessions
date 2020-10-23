package TestNGSessions;

import org.testng.annotations.Test;

public class PriorityTest 
{
	@Test(priority=3, enabled=true)
	public void aTest()
	{
		System.out.println("a Test");
	}
	
	@Test
	public void bTest()
	{
		System.out.println("b Test");
	}
	
	@Test(priority=3)
	public void cTest()
	{
		System.out.println("c Test");
	}
	
	@Test
	public void dTest()
	{
		System.out.println("d Test");
	}
	
	@Test(priority=2)
	public void eTest()
	{
		System.out.println("e Test");
	}
}
