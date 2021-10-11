package Object_Repositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import Base.base;

public class HomePagePO {

	public WebDriver driver;

	By FreeAxis = By.linkText("https://rahulshettyacademy.com/#/documents-request");

	By HomeNavigate = By.xpath("//*[text()='Home']");
	By PracticeNavigate = By.xpath("//*[text()='Practice']");
	By LoginNavigate = By.xpath("//*[text()='Login']");
	By SignNavigate = By.xpath("//*[text()='Signup']");

	By HomeTitle = By.xpath("(//*[text()='Practice Page'])[2]");

	By WebTable = By.xpath("//*[text()='Web Table Example']");

	By DropDetails = By.id("dropdown-class-example");

	// By Table1_Str1 =By.xpath("//table[@name='courses']/tbody/tr[5]/td[3]\r\n"+
	// "");
	String Table1_Str1 = "//table[@name='courses']/tbody/tr[";
	String Table1_Str2 = "]/td[";
	String Table1_Str3 = "]";

	public HomePagePO(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFreeAxis() {
		return driver.findElement(FreeAxis);
	}

	public WebElement getHome() {
		return driver.findElement(HomeNavigate);
	}

	public WebElement getPractice() {
		return driver.findElement(PracticeNavigate);
	}

	public WebElement getLogin() {
		return driver.findElement(LoginNavigate);
	}

	public WebElement getSignup() {
		return driver.findElement(SignNavigate);
	}

	public WebElement HomeTitle() {
		return driver.findElement(HomeTitle);
	}

	public WebElement WebTable() {
		return driver.findElement(WebTable);
	}

	public WebElement DropDetails() {

		// Select dropOptions = new
		return driver.findElement(DropDetails);
	}

	public String Table1_Str1(int i, int j) {

		//String Total_Table1 = Table1_Str1 + i + Table1_Str2 + j + Table1_Str3;
		
		String Total_Table1 =driver.findElement(By.xpath(Table1_Str1 + i + Table1_Str2 + j + Table1_Str3)).getText();
		
		System.out.println(Total_Table1);

		return Total_Table1;

	}
}
