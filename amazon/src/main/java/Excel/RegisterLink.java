package Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class RegisterLink {
	//Program to data driven to perform registration operation
WebDriver driver;


		@BeforeTest
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://newtours.demoaut.com");
			driver.manage().window().maximize();
			driver.findElement(By.linkText("REGISTER")).click();
		}
		@Test
		public void linksTest() throws IOException
		{
	FileInputStream file=new FileInputStream("C:\\Users\\madhuri\\amazon\\excel\\Register.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(file);
			XSSFSheet ws=wb.getSheet("Sheet1");
			
			int rowCount=ws.getLastRowNum();
			for(int i=1;i<=rowCount;i++)
			{
				Row r=ws.getRow(i);
				driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());
				driver.findElement(By.name("lastName")).sendKeys(r.getCell(1).getStringCellValue());
				driver.findElement(By.name("phone")).sendKeys(r.getCell(2).getStringCellValue());
				driver.findElement(By.name("userName")).sendKeys(r.getCell(3).getStringCellValue());
				driver.findElement(By.name("address1")).sendKeys(r.getCell(4).getStringCellValue());
				driver.findElement(By.name("city")).sendKeys(r.getCell(5).getStringCellValue());
				driver.findElement(By.name("state")).sendKeys(r.getCell(6).getStringCellValue());
				driver.findElement(By.name("postalCode")).sendKeys(r.getCell(7).getStringCellValue());
				driver.findElement(By.name("country")).sendKeys(r.getCell(8).getStringCellValue());
				driver.findElement(By.name("email")).sendKeys(r.getCell(9).getStringCellValue());
				driver.findElement(By.name("password")).sendKeys(r.getCell(10).getStringCellValue());
				driver.findElement(By.name("confirmPassword")).sendKeys(r.getCell(11).getStringCellValue());
				driver.findElement(By.name("register")).click();
				String x=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
				if(x.contains(r.getCell(9).getStringCellValue()))
				{
					r.createCell(12).setCellValue("Passed");
				}
				else
				{
					r.createCell(12).setCellValue("failed");
				}
				driver.navigate().back();
			}
	FileOutputStream f=new FileOutputStream("C:\\Users\\madhuri\\amazon\\excel\\Register.xlsx");
			wb.write(f);
		}
	}

