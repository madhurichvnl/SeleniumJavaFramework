package SeleniumPrograms;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class GoairDropdownList {
	//Program 16:- Program to Launch Chrome browser and Navigate to goair.in, Click on options in From Dropdown and check that they are not present in the To Dropdown.
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();

			driver.get("http://goair.in");
			WebElement fromDrop=driver.findElement(By.id("departureCitysearchBoxUserControlCriteriaBox"));
			List<WebElement> dropdown=fromDrop.findElements(By.tagName("option"));
			for(int i=1;i<dropdown.size();i++)
			{
				String city=dropdown.get(i).getText();
				dropdown.get(i).click();
				WebElement toDrop=driver.findElement(By.id("toCitysearchBoxUserControlCriteriaBox"));
				if(toDrop.getText().contains(city))
				{
					System.out.println(city+" is not working correctly");
				}
				else
				{
					System.out.println(city+" is  working correctly");
				}
				
			}
			driver.close();
		}

	}

