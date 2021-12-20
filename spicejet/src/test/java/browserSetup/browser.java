package browserSetup;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browser {
	@SuppressWarnings("resource")
	public WebDriver driverSetup(String url)
	{
		//multiple browser setting 
		Scanner sc = new Scanner(System.in);
		System.out.println("Press (1) for ChromeBrowser");
		System.out.println("Press (2) for FirefoxBrowser");
		System.out.println("Please enter the number for browser:");
		int num = sc.nextInt();
		WebDriver driver;
			
		switch(num)
		{
		case 1:
			 //System.setProperty(“propertyName”, “value”). 
			//It implies that it sets the system property name to its value.
			 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 //Path of Chrome driver.For Chrome version 85 and above
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("disable-infobars"); //to disable any notifications
			 driver = new ChromeDriver(options);
			 break;
		 		 
		case 2:
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			//Path of Firefox driver
			driver = new FirefoxDriver(); 
			 break;

		default:		 
			 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 //Path of Chrome driver.For hrome version 85 and below
			 driver = new ChromeDriver();
			 break;
		 
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}	
}