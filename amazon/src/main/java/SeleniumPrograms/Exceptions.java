package SeleniumPrograms;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Exceptions {

//Program 20:-Program to Launch FireFox browser and Navigate to google.com,Click on link called SoftQ, if link is not present take screenshot of the page and close the browser.
public static void main(String[] args) throws IOException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();

	
			//FirefoxDriver driver=new FirefoxDriver();
			driver.get("http://google.com");
			List<WebElement> links=driver.findElements(By.linkText("SoftQ"));
			if(links.size()==0)
			{
				File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile,new File("C:\\Users\\mmotupalli\\Desktop\\Mohan\\Self\\Images\\Google1.png"));
			}
			else
			{
				driver.findElement(By.linkText("SoftQ")).click();
			}
			driver.close();
		}

	}

