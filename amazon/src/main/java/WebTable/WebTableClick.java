package WebTable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class WebTableClick {
	//Program 43:-Program to Launch Firefox browserand Naivgate to http://opensource.demo.orangehrmlive.com/index.php/auth/login/Capture all info from the dynamic webtable table.


		WebDriver driver;

			@BeforeTest
			public void setUp()
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				driver.findElement(By.id("txtUsername")).sendKeys("Admin");
				driver.findElement(By.id("txtPassword")).sendKeys("admin");
				driver.findElement(By.id("btnLogin")).click();
			}
			@Test
			public void webtableTest()
			{
				Actions action=new Actions(driver);
				WebElement pim=driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b"));
				action.moveToElement(pim).build().perform();
				driver.findElement(By.linkText("Employee List")).click();
				
				WebElement table=driver.findElement(By.id("resultTable"));
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



