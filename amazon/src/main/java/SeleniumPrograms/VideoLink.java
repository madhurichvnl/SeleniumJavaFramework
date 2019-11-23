package SeleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VideoLink {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("http://bing.com");
		String expUrl="http://www.bing.com/?scope=video&nr=1";
		driver.findElement(By.linkText("Videos")).click();
		String actUrl=driver.findElement(By.linkText("Videos")).getAttribute("href");
		System.out.println(actUrl);
		if(actUrl.equals(expUrl))
		{
			System.out.println("Videos link is working correctly");
		}
		else
		{
			System.out.println("Videos link is not working correctly");
		}
		driver.close();
	}



}
