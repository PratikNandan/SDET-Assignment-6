package SDET201_Assignment_6;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class drag_drop_ss {
	WebDriver driver;

	@BeforeTest
	public void bt() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://v1.training-support.net/selenium/drag-drop");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}
	
@Test
public void task() throws IOException, InterruptedException {
	TakesScreenshot before = (TakesScreenshot)driver;
	File ot = before.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(ot,new File("E:\\MASAI\\UNIT 3\\Assignment\\Assignment_dragdrop_screenshot_upload_datadriven\\before.png"));
	
	WebElement drg = driver.findElement(By.xpath("//img[@id='draggable']"));
	WebElement drp = driver.findElement(By.xpath("//div[@id='droppable']"));
	
	Actions act = new Actions(driver);
	act.dragAndDrop(drg, drp).build().perform();
	Thread.sleep(3000);
	
	
	TakesScreenshot after = (TakesScreenshot)driver;
	File ot1 = after.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(ot1,new File("E:\\MASAI\\UNIT 3\\Assignment\\Assignment_dragdrop_screenshot_upload_datadriven\\after.png"));
	

}

}
