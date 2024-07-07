package SDET201_Assignment_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datadriven {
WebDriver driver;
	
	@BeforeTest
	public void bt() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.instagram.com/accounts/login/?hl=en");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		

	}

@Test
public void task() throws IOException {
	File excel = new File("E:\\MASAI\\datadriven_assignment.xlsx");
	FileInputStream fis = new FileInputStream(excel);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet data = wb.getSheet("Sheet1");
	int rc = data.getLastRowNum();
	
	for (int i=0;i<=rc;i++)
	{
		String c1 = data.getRow(i).getCell(0).getStringCellValue();
		String c2 = data.getRow(i).getCell(1).getStringCellValue();
		
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(c1);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(c2);
		driver.findElement(By.xpath("//button[@type='submit']")).click();


	}
}

}
