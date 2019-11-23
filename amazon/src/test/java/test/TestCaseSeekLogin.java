package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCaseSeekLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\madhuri\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
   
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCaseSeekLogin() throws Exception {
    driver.get("https://www.google.com/search?q=seek&oq=se&aqs=chrome.0.69i59j69i57j69i59j69i60l2j69i61j69i60l2.1077j0j7&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Web result with site links'])[1]/following::span[1]")).click();
    driver.findElement(By.id("keywords-input")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='selenium'])[1]/following::span[2]")).click();
    driver.findElement(By.id("keywords-input")).clear();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.id("keywords-input")).sendKeys("selenium test analyst");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hide classifications'])[1]/following::label[1]")).click();
    driver.findElement(By.linkText("Information & Communication Technology")).click();
    driver.findElement(By.linkText("Testing & Quality Assurance")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='What'])[1]/following::label[1]")).click();
    driver.findElement(By.id("SearchBar__Where")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='RECENT'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Where'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Show date listed refinements.'])[1]/following::span[1]")).click();
    driver.findElement(By.linkText("Last 7 days")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
