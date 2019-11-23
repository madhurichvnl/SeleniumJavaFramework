package AlertsHandling;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class AlertTest {
	WebDriver driver;

		@BeforeTest
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
			
			driver.get("http://google.com");
			driver.manage().window().maximize();
		}
		@Test
		public void alertTest()
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("alert('Hello Friends');");
			//Sleeper.sleepTightInSeconds(4);
			Alert myalert=driver.switchTo().alert();
			myalert.accept();
		}
	}



