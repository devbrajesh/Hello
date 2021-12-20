package library;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.excel;

public class page {

	// RoundTrip radio button selected
		public void RoundTripFunction(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // The Implicit Wait in Selenium is used to
			// tell the web driver to wait for a certain amount of time
			driver.findElement(By.xpath(home.RoundTrip)).click(); // Round trip radio button clicked
		}

		// Pick up values Coimbatore and chennai given to From and To textboxes respectively
		
		public void FromToFunction(WebDriver driver) throws IOException, InterruptedException {

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Implicit wait
			String st1 = excel.getDataExcel1();                       // Obtaining the value from Excel and storing it in the string Coimbatore
			String st2 = excel.getDataExcel2();                            // Obtaining the value from Excel and storing it in the string Chennai
			driver.findElement(By.xpath(home.From)).click();
			driver.findElement(By.xpath(home.From)).sendKeys(Keys.BACK_SPACE); //For pressing Enter key over a textbox
			driver.findElement(By.xpath(home.From)).sendKeys(st1);   //Entering the string value into the From textbox
			driver.findElement(By.xpath(home.From)).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(By.xpath(home.To)).click();
			// Increasing the wait time
			driver.findElement(By.xpath(home.To)).sendKeys(st2);     // Entering the string value into the To textbox
			driver.findElement(By.xpath(home.To)).sendKeys(Keys.ENTER); // For pressing Enter key over a textbox
		
		}

		// Future date entered for Depart On and Return On
		public void DateFunction(WebDriver driver) throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  // Implicit wait
			driver.findElement(By.xpath(home.DepartDate)).click(); // Next click button to show the next month of the calendar
			Thread.sleep(2000);
			driver.findElement(By.xpath(home.DepartOn)).click(); // Departure date clicked
			driver.findElement(By.xpath(home.ReturnDate)).click(); // Return date clicked
			driver.findElement(By.xpath(home.ReturnOn)).click();
			}

		// Adults 2 chosen in the list-box
		public void AdultListFunction(WebDriver driver) {

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    //Implicit wait
			driver.findElement(By.xpath(home.Adult)).click();
			driver.findElement(By.xpath(home.Adultno)).click();     
			Select s = new Select(driver.findElement(By.xpath(home.Adultno)));  //Select class used for dropdown
			s.selectByValue("2");  //Select by value
		}

		// Search Flights button clicked
		public void SearchFunction(WebDriver driver) throws IOException {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);     //implicit wait
			driver.findElement(By.xpath(home.Search)).click();                //Search flights button clicked
		}

		// print first Flights number
				public void FlightNoFunction(WebDriver driver) throws IOException {
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);     //implicit wait
					String flight1= driver.findElement(By.xpath(home.Dname)).getText();  //first Departure  flight name
					String flight2= driver.findElement(By.xpath(home.Rname)).getText(); //first returnSS  flight name
					System.out.println("Departure flight number:"+flight1);
					System.out.println("Return flight number:"+flight2);
				}

}
