package AdvancedSeleniumPrograms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class ActionsClass {
	WebDriver driver;
		@BeforeTest
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://yssofindia.org");
			driver.manage().window().maximize();
		}
		@Test
		public void mouseHoverTest()
		{
			Actions action=new Actions(driver);
			WebElement aboutYss=driver.findElement(By.xpath("//*[@id='topmenu']/div/ul/li[5]/a/img"));
			WebElement contactUs=driver.findElement(By.xpath("//*[@id='topmenu']/div/ul/li[5]/ul/li[9]/a"));
			action.moveToElement(aboutYss).moveToElement(contactUs).build().perform();
			WebElement emailUs=driver.findElement(By.xpath("//*[@id='topmenu']/div/ul/li[5]/ul/li[9]/ul/li[1]/a"));
			emailUs.click();
			}
	}




