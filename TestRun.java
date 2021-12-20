import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestRun {
public static void main(String args[])
{
	System.out.println("Hello");
	System.setProperty("webdriver.chrome.driver", "D:\\JAVA Selenium 2021\\Executables\\chromedriver.exe");
	ChromeDriver driver= new ChromeDriver();
	String baseUrl = "http://demo.guru99.com/test/newtours/";
    System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
            

    driver.get("http://demo.guru99.com/test/simple_context_menu.html");
    driver.manage().window().maximize();

    driver.get("http://demo.guru99.com/test/simple_context_menu.html");
    driver.manage().window().maximize();
    //Double click the button to launch an alertbox
    Actions action = new Actions(driver);
    WebElement link =driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
    action.doubleClick(link).perform();
    //Switch to the alert box and click on OK button
    Alert alert = driver.switchTo().alert();
    System.out.println("Alert Text\n" +alert.getText());
    alert.accept();
    //Closing the driver instance
    //driver.quit();
}
}
