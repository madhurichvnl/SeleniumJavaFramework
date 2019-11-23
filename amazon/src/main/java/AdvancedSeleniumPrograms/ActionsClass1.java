package AdvancedSeleniumPrograms;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class ActionsClass1 {
	WebDriver driver;
		@BeforeTest
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://google.com");
			driver.manage().window().maximize();
		}
		@Test
		public void rightClickTest()
		{
			Actions action=new Actions(driver);
			WebElement gmail=driver.findElement(By.linkText("Gmail"));
			action.contextClick(gmail).sendKeys("L").build().perform();
		}

	}

