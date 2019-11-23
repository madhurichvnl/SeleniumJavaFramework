package RadioButton;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class ButtonTest {
	//Program 45:-Program to Launch FireFox browserand Naivgate to http://echoecho.com,Capture the first group of radio buttons(Milk,Butter and Cheese)Check their default status.
WebDriver driver;
		
	
			@BeforeTest
			public void setUp()
			{

				System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://echoecho.com/htmlforms10.htm");
				driver.manage().window().maximize();
			}
			@Test
			public void radioButtonsTest()
			{
				WebElement block=driver.findElement(By.xpath("html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
				for(int k=1;k<=2;k++)
				{
					List<WebElement>radio=block.findElements(By.name("group"+k));
					for(int i=0;i<radio.size();i++)
					{
						radio.get(i).click();
						for(int j=0;j<radio.size();j++)
						{
							if(radio.get(j).isSelected())
							{
							System.out.println(radio.get(j).getAttribute("value")+" is selected");
							}
							else
							{
						System.out.println(radio.get(j).getAttribute("value")+" is not selected");
							}
						}
						System.out.println("################################");
					}
				}
			}
}
			




