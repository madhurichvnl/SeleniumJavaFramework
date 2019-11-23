/*:- Program to Launch Firefox browser and navigate to google and validate Gmail link*/
package SeleniumPrograms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ValidateGmailLink {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("http://google.com");
		String expTitle="Gmail";
		driver.findElement(By.linkText("Gmail")).click();
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		if(expTitle.startsWith(actTitle))
		{
			System.out.println("Gmail Link Working Properly");
		}
		else
		{
			System.out.println("Gmail Link Not Working Properly");
		}
		driver.close();
	}

}



