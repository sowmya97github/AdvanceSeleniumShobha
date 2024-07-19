package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;

public class BaseClass {

	public static WebDriver sDriver;
	public WebDriver driver;
	public File_Utility flib = new File_Utility();
	public WebDriver_utility wlib = new WebDriver_utility();
	public Java_Utility jlib = new Java_Utility();
	public Excel_Utility elib = new Excel_Utility();
	public DataBaseUtility dlib = new DataBaseUtility();

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void bs() throws Throwable {
		dlib.dataBaseConnection(driver);
		System.out.println("DataBase Connection");
	}

	@BeforeTest(groups = { "smokeTest", "regressionTest" })
	public void bt() {
		System.out.println("parallel execution");
	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void bc() throws Throwable {
	
		//reading browser value from cmd line
	//	String BROWSER = System.getProperty("browser");
	//	System.out.println(BROWSER);
		
		String BROWSER = flib.getKeyAndValueData("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			
			driver = new ChromeDriver();
		}
		System.out.println("Browser launched");
		sDriver = driver;
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void bm() throws Throwable {
//		
		String URL = flib.getKeyAndValueData("url");
   	String USERNAME = flib.getKeyAndValueData("username");
      String PASSWORD = flib.getKeyAndValueData("password");

		//reading parameters from cmd
//		String URL = System.getProperty("url");
//		String USERNAME = System.getProperty("username");
//		String PASSWORD = System.getProperty("password");
		
		
		wlib.maximizeWindow(driver);
		wlib.waitForElementToLoad(driver);

		driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		System.out.println("login to Application");
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void am() {

		HomePage home = new HomePage(driver);
		home.logOut(driver);
		System.out.println("logout from application");
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void ac() {
		driver.quit();
		System.out.println("close browser");
	}

	@AfterTest(groups = { "smokeTest", "regressionTest" })
	public void at() {
		System.out.println("parallel execution done");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void as() throws Throwable {
		dlib.dataBaseClose();
		System.out.println("close database");
	}
}
