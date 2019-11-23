package SeleniumPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HiddenorVisibleLinks {
	//Program 11:-Program to Launch Firefox browser and navigate to google.com Capture all the links, Skip the hidden links and click on visible links and capture their urls.
	public static void main(String[] args) {
		//FirefoxDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{
			if(links.get(i).isDisplayed())
			{
				System.out.println(links.get(i).getText());
				links.get(i).click();
				System.out.println(driver.getCurrentUrl());
				driver.navigate().back();
				links=driver.findElements(By.tagName("a"));
			}
		}
	}

}




