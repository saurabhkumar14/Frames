package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class base {

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\saura\\eclipse-workspace\\FramewORK\\src\\main\\java\\Base\\data.properties");

		prop.load(fis);
		String BrowserName = prop.getProperty("browser");
		String headstate = prop.getProperty("headless");
		// String mainURL=prop.getProperty("mainURL");

		if (BrowserName.equals("chrome") && headstate.equals("false")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\My_Drive\\Automation_Data\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (BrowserName.equals("chrome") && headstate.equals("true")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\My_Drive\\Automation_Data\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);

		}

		else if (BrowserName.equals("firefox") && headstate.equals("false")) {
			System.out.println("Test firefox block");
			System.setProperty("webdriver.gecko.driver",
					"C:\\My_Drive\\Automation_Data\\geckodriver-v0.29.1-win64\\geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (BrowserName.equals("firefox") && headstate.equals("true")) {
			System.setProperty("webdriver.gecko.driver",

					"C:\\My_Drive\\Automation_Data\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			FirefoxBinary firefoxBin = new FirefoxBinary();
			firefoxBin.addCommandLineOptions("--headless");
			FirefoxOptions fo = new FirefoxOptions();
			fo.setBinary(firefoxBin);

			driver = new FirefoxDriver(fo);

		}

		else if (BrowserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\My_Drive\\Automation_Data\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
		} else if (BrowserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\My_Drive\\Automation_Data\\edgedriver_win32\\msedgedriver.exe");

			driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver;

	}

	public String mainURL() throws IOException {
		Properties propurl = new Properties();
		FileInputStream fisurl = new FileInputStream(
				"C:\\Users\\saura\\eclipse-workspace\\FramewORK\\src\\main\\java\\Base\\data.properties");

		propurl.load(fisurl);
		String mainurl = propurl.getProperty("mainURL");

		return mainurl;
	}

	public void getScreenShotPath(String testName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFiles = System.getProperty("user.dir") + "\\reports\\" + testName + ".png";
		FileUtils.copyFile(source, new File(destinationFiles));

	}

	public void DataValidationExcel(String path_for_data, String Sheet_Name, String field_1, String field_2)
			throws IOException {

		FileInputStream exfl = new FileInputStream(path_for_data);
		XSSFWorkbook workbook = new XSSFWorkbook(exfl);
		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i <= sheets - 1; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(Sheet_Name)) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();

				Iterator<Cell> ce = firstrow.cellIterator();

				// System.out.println(getStringCellValue);
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase(field_1)) {
						System.out.println(value.getStringCellValue());
						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(field_2)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							System.out.println(cv.next().getStringCellValue());
						}

					}
				}

			}
		}

	}
}
