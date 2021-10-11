package Base;

import Base.base;
import Object_Repositary.HomePagePO;
import Object_Repositary.LoginPage;
import Object_Repositary.MainPage;
import junit.framework.Assert;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataValidation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TableValidation extends base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(TableValidation.class.getName());

	@BeforeTest
	public void Initialse() throws IOException {
		driver = initializeDriver();
		Log.info("Driver is Initialized");
		driver.manage().window().maximize();
		Log.info("Test5.TableValidation.Browser is Maximized");
	}

	@Test(enabled = true)

	public void firstPageNavigation() throws IOException, InterruptedException {

		driver.get(super.mainURL());
		Log.info("Test5.TableValidation.URL Hit");
		SoftAssert softAssert = new SoftAssert();
		HomePagePO le = new HomePagePO(driver);
		DataValidator le2 =new DataValidator();

		for (int i = 2; i <= 10; i++)

		{
			for (int j = 2; j <= 3; j++) {
				le.Table1_Str1(i, j);
			String String_Value=le.Table1_Str1(i, j);
				le2.DataValidationExcel("C:\\Users\\saura\\OneDrive\\Desktop\\MyCode\\Data_Validator.xlsx","For_Table_1","String_Value", "null");
			
				
				
				
				
			}

		}
		Log.info("Test5.TableValidation.Assertion is passed : Login page opened successfully .");
		// softAssert.assertAll();

	}

	@AfterTest
	public void closeTest() {
		driver.close();
		Log.info("Test5.TableValidation.Browser is Closed");

	}
	/*
	 * @DataProvider public Object getData() {
	 * 
	 * Object[][] data = new Object[3][2]; data[0][0] = "use1@user.in"; data[0][1] =
	 * "pass1"; data[1][0] = "use2@user.in"; data[1][1] = "pass2"; data[2][0] =
	 * "use3@user.in"; data[2][1] = "pass3"; return data; }
	 */

}