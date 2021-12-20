package assignment.spicejet;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import browserSetup.browser;
import library.page;
import utilities.excel;
import utilities.screenshot;

public class AppTest 
{
	browser b = new browser();
	page p = new page();
	
	excel e= new excel();
	screenshot s = new screenshot();
	WebDriver driver;
		
	@BeforeMethod //The annotated method will be run before each test method.
	public void f1() throws IOException, InterruptedException, AWTException
	{
		driver = b.driverSetup("https://www.spicejet.com/");		//enter the url of site
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000); 
	}
	
	@Test //Marks a class or a method as a part of the test.
	public void f2() throws IOException, InterruptedException
	{
		e.putDataExcel(driver);
		p.RoundTripFunction(driver);  //Round trip function is called to choose round trip radio buton
		p.FromToFunction(driver);   //FromTo function is called to enter the picl up values
		p.DateFunction(driver);     //Date function is called to enter the date
		p.AdultListFunction(driver);  //AdultList function is called to choose 2 adults ine the listbox
		p.SearchFunction(driver);     //Search function is called to click on the search flights button
		p.FlightNoFunction(driver); //flight no. function is called to print first flight numbers
		s.screenshotFunction(driver);          //Screenshot function is called to capture flights running between chosen dates
	}
	
	@AfterTest //The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.
	public void f3()
	{
		driver.quit(); //Used to exit the browser
	}

}
