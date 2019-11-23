package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webpages.gumtreelogin;

public class ScreenShot {
	WebDriver driver;

	@BeforeTest	
	public void Testsetup() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://gumtree.com.au");
		driver.manage().window().maximize();
	}
	@Test
	public void screenshot()
	{
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
		driver.findElement(By.linkText("Jobs")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TakesScreenshot scr=(TakesScreenshot)driver;
		File srcFile=scr.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File("C:\\Users\\madhuri\\amazon\\Images\\1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}