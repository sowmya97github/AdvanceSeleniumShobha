package testNg;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;

public class DataProviderEx4 {

	@Test(dataProvider="getdata")
	public void data(String orgName, String phno, String email) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
	    driver.findElement(By.id("submitButton")).click();
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    Random ranNum = new Random();
		int ranNumber = ranNum.nextInt(1000);
	    driver.findElement(By.name("accountname")).sendKeys(orgName+ranNumber);
	    driver.findElement(By.id("phone")).sendKeys(phno);
	    driver.findElement(By.id("email1")).sendKeys(email);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    Thread.sleep(1000);
	    driver.quit();
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable
	{
	Excel_Utility elib = new Excel_Utility();	
	Object[][] values = elib.readDataUsingDataProvider("DataProvider");
	return values;
		
	}
}
