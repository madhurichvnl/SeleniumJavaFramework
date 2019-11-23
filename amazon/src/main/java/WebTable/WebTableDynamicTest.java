package WebTable;


	import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	public class WebTableDynamicTest {
WebDriver driver;
		@BeforeTest
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://www.timeanddate.com/worldclock/");
			driver.manage().window().maximize();
		}
		
		@Test
		public void webtableTest()
		{
			
			driver.manage().timeouts().implicitlyWait(150,TimeUnit.SECONDS);

			WebElement table=driver.findElement(By.className("zebra fw tb-theme"));
			List<WebElement> rows=table.findElements(By.tagName("tr"));
			for(int i=0;i<rows.size();i++)
			{
				List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
				for(int j=0;j<cols.size();j++)
				{
					System.out.print(cols.get(j).getText()+"   ");
				}
				System.out.println();
			}

		}
	}


