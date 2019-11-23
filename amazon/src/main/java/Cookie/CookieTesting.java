package Cookie;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//Cookies are javascript programs which stored on the client side, whenever we open any web application. Cookies contain information about our previously used information like usernames, passwords etc.
public class CookieTesting {
	//Program 44:-Program to Launch FireFox browserand Naivgate to http://mirror.co.uk,capture all the cookies and delete all the cookies.
WebDriver driver;
			@BeforeTest
			public void setUp()
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://mirror.co.uk");
				driver.manage().window().maximize();
			}
			@Test
			public void  cookiesTest()
			{
				Set<Cookie> myCookies=driver.manage().getCookies();
				System.out.println(myCookies.size());
				Iterator<Cookie> it=myCookies.iterator();
				while(it.hasNext())
				{
					Cookie c=it.next();
					System.out.println(c.getName()+"---"+c.getDomain());
				}
				driver.manage().deleteAllCookies();
				myCookies=driver.manage().getCookies();
				System.out.println(myCookies.size());
			}
		}




