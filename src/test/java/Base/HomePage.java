package Base;

import Base.base;
import Object_Repositary.HomePagePO;
import Object_Repositary.LoginPage;
import Object_Repositary.MainPage;
import junit.framework.Assert;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(HomePage.class.getName());
	@BeforeTest (enabled=false)
	public void Initialse() throws IOException
	{
		driver = initializeDriver();
		Log.info("Driver is Initialized");
		driver.manage().window().maximize();
		Log.info("Browser is Maximized");
	}
	@Test(dataProvider="getData",enabled=false)

	public void firstPageNavigation(String User,String Password) throws IOException, InterruptedException {
		
		
		driver.get(super.mainURL());
		SoftAssert softAssert = new SoftAssert();
		HomePagePO le = new HomePagePO(driver);
		
		softAssert.assertEquals(le.HomeTitle().getText(),"Practice Page");
		le.getHome().click();
		Log.info("Home Page is opened");
	

		MainPage les = new MainPage(driver);
       Thread.sleep(10000);
		les.getLogin().click();
		Log.info("Login Page is opened");
		LoginPage lesq = new LoginPage(driver);
		lesq.IDSender().sendKeys(User);
		lesq.PassSender().sendKeys(Password);
		//lesq.ClickLogin().click();
		
		
		Assert.assertEquals(lesq.LoginTitle().getText(),"Log In to Rahul Shetty Academy");
		Log.info("Assertion is passed : Login page opened successfully .");
	  //  softAssert.assertAll();
	    
	}
	
	@AfterTest (enabled=false)
	public void  closeTest()
	{
		driver.close();
		Log.info("Browser is Closed");

	}
	
	@DataProvider
	public Object getData()
	{
		
		Object[][] data =new Object[3][2];
		data[0][0]="use1@user.in";
		data[0][1]="pass1";
		data[1][0]="use2@user.in";
		data[1][1]="pass2";
		data[2][0]="use3@user.in";
		data[2][1]="pass3";
		return data;
	}
	

}