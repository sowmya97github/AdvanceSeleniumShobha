package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_utility;
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;

public class CreateProductTest extends BaseClass {
	@Test(retryAnalyzer = Generic_Utilities.RetryImplementation.class)
	public void createProductTest() throws Throwable {
	   
		int ranNum = jlib.getRandomNumber();
    
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	
	
	String productData = elib.getExcelData("Product", 0, 0)+ranNum;
	
	CreateProductPage prdPage = new CreateProductPage(driver);
//	driver.findElement(By.name("productname")).sendKeys(productData);
	prdPage.enterProductName(productData);
  
 //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	prdPage.clickSaveButton();
    
	}

}
