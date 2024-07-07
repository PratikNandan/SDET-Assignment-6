package SDET201_Assignment_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class upload {
	WebDriver driver;
	
	@BeforeTest
	public void bt() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		

	}
	
@Test
public void task() throws InterruptedException {
	
	WebElement uploadElement = driver.findElement(By.id("input-4"));
	
	String filepath = "E:\\MASAI\\DemoFileUpload.txt";
	uploadElement.sendKeys(filepath);
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//span[@class='hidden-xs'])[3]")).click();
	//driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-upload']")).click();
	
	
	//Note : Program will fail as Uploading file on Original website is also not Working as of Now

			
}


}
