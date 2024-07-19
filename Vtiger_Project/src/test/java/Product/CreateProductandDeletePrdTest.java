package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_utility;
import objectRepository.CreateProductPage;
import objectRepository.DeletePrdValidationPage;
import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;

public class CreateProductandDeletePrdTest extends BaseClass{

	@Test
public void createProductandDeletePrdTest()	 throws Throwable {
		
		 HomePage home = new HomePage(driver);
		home.clickProductLink();
	
	   CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();
		
		int ranNumber = jlib.getRandomNumber();
	
 	  String productData = elib.readExcelDataUsingDataFormatter("Product", 1, 1)+ranNumber;
 //	 driver.findElement(By.name("productname")).sendKeys(productData);
 	prdPage.enterProductName(productData);
	
 //	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();    
 	prdPage.clickSaveButton();
	
 //	driver.findElement(By.linkText("Products")).click(); 
 	home.clickProductLink();
//	 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
	    
 	DeletePrdValidationPage prdValidate = new DeletePrdValidationPage(driver);
	// driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+productData+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	 prdValidate.deleteProduct(driver, productData);
	 
	// driver.findElement(By.xpath("//input[@value='Delete']")).click();
	 prdValidate.clickOnDeleteButton(wlib, driver);
	
	 prdValidate.validateProductDeleted(driver, productData);
Thread.sleep(1000);
	}

}
