package SeleniumPrograms;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class HeaderLinks {
	
	//Program 9:- Program to Launch Firefox browser and navigate to bing.com Capture all the header links, and display on console.
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();

			driver.get("http://bing.com");
			WebElement header=driver.findElement(By.id("sc_hdu"));
			List<WebElement> links=header.findElements(By.tagName("a"));
			System.out.println(links.size());
			for(int i=0;i<links.size();i++)
			{
				System.out.println(links.get(i).getText());
			}
			driver.close();
		}

	}
