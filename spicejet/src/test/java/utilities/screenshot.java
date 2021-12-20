package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshot { // taking screenshot
	public void screenshotFunction(WebDriver driver) throws IOException { 
		TakesScreenshot ts = (TakesScreenshot) driver; // for taking screenshot
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/FinalPage.png")); // Name and path of the file given
		System.out.println("Successfully taken the screenshot");

	}
}