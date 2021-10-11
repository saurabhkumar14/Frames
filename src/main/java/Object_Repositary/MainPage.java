package Object_Repositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainPage {
	public WebDriver driver;
	By RegiserNavigate = By.xpath("//*[text()='Register']");
	By LoginNavigate = By.xpath("//*[text()='Login']");

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRegister() {
		return driver.findElement(RegiserNavigate);
	}

	public WebElement getLogin() {
		return driver.findElement(LoginNavigate);
	}

}
