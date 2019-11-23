package SeleniumPrograms;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Generalsectionclickandcaptureurls {
//Program 10:- Program to Launch Firefox browser and navigate to pvrcincemas.com Capture all the links in General Section, Click on them and capture their url's.
	public static void main(String[] args) {
		//FirefoxDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("http://pvrcinemas.com");
	//xpath of the complete section
				WebElement general=driver.findElement(By.xpath("html/body/div[7]/div[1]/div[2]"));
		List<WebElement> links=general.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getText());
			links.get(i).click();
			System.out.println(driver.getCurrentUrl());
			driver.navigate().back();
	//re-create the array list (because once u click on back button, the arrylist will be cleared)
			general=driver.findElement(By.xpath("html/body/div[7]/div[1]/div[2]"));
			links=general.findElements(By.tagName("a"));
		}
	}

}

//Note:- whenever we use “get() or navigate()” it automatically refreshes the system memory. Due to this reason we had to recreate the array list one more time in the loop after using driver. 
//Ex:-Navigate.back(); in the previous program



