package SeleniumPrograms;

import java.io.File;
	import java.io.IOException;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//	public class Screenshots {
public class Screenshot {
	//Program 19:-Program to Launch FireFox browser and Navigate to google.com,and take screenshot of the page.


			public static void main(String[] args) throws IOException {
	//	FirefoxDriver driver=new FirefoxDriver();
				System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();

				driver.get("http://google.com");

	TakesScreenshot scr=(TakesScreenshot)driver;
	File srcFile=scr.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile,new File("C:\\Users\\mmotupalli\\Desktop\\Mohan\\Self\\Images\\1.png"));

			}

		}



