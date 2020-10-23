package TestNGSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept 
{
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void divisionTest()
	{
		System.out.println("Div Test");
		 int i =9/0;
		System.out.println("Hello");
		
		String str ="selenium";
		str =null;
		System.out.println(str.length());
	}
	
}
