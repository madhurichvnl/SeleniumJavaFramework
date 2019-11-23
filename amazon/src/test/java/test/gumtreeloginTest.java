package test;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import webpages.gumtreelogin;

public class gumtreeloginTest {
	static WebDriver driver=null;
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	@BeforeSuite
	public void extentreport()
	{
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	@BeforeTest	
	public void Testsetup() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();



		driver.get("http://gumtree.com.au");
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();

	}
	@Test
	public void test() throws IOException, InterruptedException
	{
		Row r=null;
		gumtreelogin pageobj=new gumtreelogin(driver);


		pageobj.setGumtree_signin();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageobj.setemailid("vnlm842@gmail.com");
		pageobj.setpswd("venkata@11");
		pageobj.setLogin_button();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(pageobj.message_button)); 
		pageobj.setMessage_button();
		FileInputStream file=new FileInputStream ("C:\\Users\\madhuri\\amazon\\excel\\data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheet("Sheet1");
		WebElement input = (new WebDriverWait(driver, 80)).until(ExpectedConditions.presenceOfElementLocated(By.className("messenger-conversation-list")));
		System.out.println("here you go");
		Thread.sleep(2000);
		List<WebElement> elements = input.findElements(By.className("messenger-conversation__name"));
		Thread.sleep(2000);
		System.out.println("Number of elements:" +elements.size());

		Thread.sleep(2000);
		for (int i=0; i<elements.size();i++){
			r= ws.createRow(i+1);
			r.createCell(0).setCellValue(elements.get(i).getText());
		}
		System.out.println("created first cell");
		List<WebElement> descelement = input.findElements(By.className("messenger-conversation__message"));
		for (int i=0; i<descelement.size();i++){
			r=ws.getRow(i+1);
			r.createCell(1).setCellValue(descelement.get(i).getText());
		}
		FileOutputStream f=new FileOutputStream("C:\\Users\\madhuri\\amazon\\excel\\data.xlsx");
		wb.write(f);
	}

	@AfterSuite
	public void extentreportshutdown()
	{
		extent.flush();
	}
}
