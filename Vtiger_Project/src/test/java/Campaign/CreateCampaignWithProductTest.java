package Campaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateCampaignsPage;
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigerLoginPage;
import objectRepository.WindowSwitingToProductPage;

@Test(groups = "regressionTest")
public class CreateCampaignWithProductTest extends BaseClass{

	public void createCampaignWithProductTest() throws Throwable {
		
        int ranNumber = jlib.getRandomNumber();
        HomePage home = new HomePage(driver);
        home.clickProductLink();
       CreateProductPage prdPage = new CreateProductPage(driver);
        prdPage.clickOnPlusSign();
      String productData = elib.getExcelData("Product", 0, 0)+ranNumber;
	  prdPage.enterProductName(productData);
	  prdPage.clickSaveButton();
      home.clickMoreLink();
      home.clickCampaignLink();
      CreateCampaignsPage campPage = new CreateCampaignsPage(driver);
      campPage.clickCampPlusSign();
      String campaignData = elib.getExcelData("Campaign", 0, 0)+ranNumber;
         campPage.enterCampName(campaignData);
         campPage.clickProductPlusSign();
         wlib.switchingWindows(driver, "Products&action");
         WindowSwitingToProductPage campPrdPage = new WindowSwitingToProductPage(driver);
         campPrdPage.enterProductName(productData);
         campPrdPage.searchPrdName();
         campPrdPage.prdNamePresent(driver, productData);
         wlib.switchingWindows(driver, "Campaigns&action");
         campPage.clickOnSaveButton();
    ValidationAndVerification campProdValidation = new ValidationAndVerification(driver);
   campProdValidation.campData(driver, campaignData);
   campProdValidation.productInCamp(driver, productData);

	}

}
