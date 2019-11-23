package webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public  class gumtreelogin {
	WebDriver driver=null;
	By gumtree_signin=By.linkText("Sign In");
	By emailid=By.id("login-email");
	By pswd=By.id("login-password");
	By login_button=By.id("btn-submit-login");
	public By message_button=By.xpath("//*[@class='svg svg-my-gumtree_messages header__message-center-image']");
	public  gumtreelogin(WebDriver driver) {
		this.driver=driver;
	}
	public void setGumtree_signin() {
		driver.findElement(gumtree_signin).click();
	}
	public void setemailid(String text)
	{
		driver.findElement(emailid).sendKeys(text);
	}
	public void setpswd(String text1)
	{
		driver.findElement(pswd).sendKeys(text1);
	}
	public void setLogin_button() {
		driver.findElement(login_button).click();
	}
	public void setMessage_button() {
		driver.findElement(message_button).click();
	}
}
