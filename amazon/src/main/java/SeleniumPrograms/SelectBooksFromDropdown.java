package SeleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SelectBooksFromDropdown {
	//Program 13:- Program to Launch Firefox browser and navigate to amazon.in Select books from the dropdown, Enter Harry potter in the search box and click on search.


		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();

			//FirefoxDriver driver=new FirefoxDriver();
			driver.get("http://amazon.in");
			driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
			driver.findElement(By.className("nav-input")).click();
		}

	}


