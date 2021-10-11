package Object_Repositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage {
	public WebDriver driver;
	By IDSender = By.xpath("//*[@id='user_email']");
	By PassSender = By.xpath("//*[@id='user_password']");
	
	By LoginError=By.xpath("//*[text()='Invalid email or password']");
	
	By ClickLogin=By.xpath("//input[@value='Log In']");

	By LoginTitle=By.xpath("//*[text()[contains(.,'Log In to Rahul Shetty Academy')]]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement IDSender() {
		return driver.findElement(IDSender);
	}

	public WebElement PassSender() {
		return driver.findElement(PassSender);
	}
	
	public WebElement ClickLogin() {
		return driver.findElement(ClickLogin);
	}
	public WebElement LoginError() {
		return driver.findElement(LoginError);
	}
	public WebElement LoginTitle() {
		return driver.findElement(LoginTitle);
	}
	

}
