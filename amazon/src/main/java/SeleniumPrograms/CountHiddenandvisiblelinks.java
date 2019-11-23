package SeleniumPrograms;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CountHiddenandvisiblelinks {
	//Program 12:-Program to Launch Firefox browser and navigate to google.com Capture all the links, Find how many links are visible and how many are hidden.



	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();

	  int Vis=0;
	  int Hide=0;
	  // TODO Auto-generated method stub
	  //FirefoxDriver driver=new FirefoxDriver();
	  driver.get("http://google.com");
	  List<WebElement> links=driver.findElements(By.tagName("a"));
	  System.out.println(links.size());
	    for(int i=0;i<links.size();i++)
	             {
	    	System.out.println(links.get(i).getText());
	      System.out.println(driver.getCurrentUrl());
	      if(links.get(i).isDisplayed()==true)
	      	{
	       	Vis=Vis+1;
 }
	      else
	            {
		     Hide=Hide+1;
	            }
	          }
	    
	    System.out.println("invisible"+Hide);
	    System.out.println("visible"+Vis);

		}
	}



