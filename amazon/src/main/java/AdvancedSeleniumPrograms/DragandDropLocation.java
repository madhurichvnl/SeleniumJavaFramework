package AdvancedSeleniumPrograms;


	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	public class DragandDropLocation {
		WebDriver driver;
		@BeforeTest
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://www.snapdeal.com/products/mens-tshirts-polos?sort=plrty&q=Price%3A2601%2C8199|");
			driver.manage().window().maximize();
		}
		
		@Test
		public void sliderTest()
		{
			Actions action=new Actions(driver);
			WebElement slider=driver.findElement(By.xpath("//*[@id='content_wrapper']/div[7]/div[1]/div/div/div[2]/div[3]/div[3]/div/div[1]/div"));
			int x=slider.getLocation().x;
			int y=slider.getLocation().y;
			System.out.println(x+"---"+y);
			action.dragAndDropBy(slider,x,59).build().perform();
		}
	}





