package SeleniumPrograms;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Capturedropdownforfield {
	//Program 15:- Program to Launch Firefox browser and Navigate to newtours.demoaut.com, Click on Register link,Capture all the elements in dropdown,Click on the options and check if they are getting selected.
	public static void main(String[] args) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
			//FirefoxDriver driver=new FirefoxDriver();
			driver.get("http://newtours.demoaut.com");
			driver.findElement(By.linkText("REGISTER")).click();
			WebElement drop=driver.findElement(By.name("country"));
			List<WebElement> dropdown=drop.findElements(By.tagName("option"));
			System.out.println(dropdown.size());
			for(int i=0;i<dropdown.size();i++)
			{
				dropdown.get(i).click();
				if(dropdown.get(i).isSelected())
				{
					System.out.println(dropdown.get(i).getText()+" is active");
				}
				else
				{
					System.out.println(dropdown.get(i).getText()+" is inactive");
				}
			}
			driver.close();
		}

	}



