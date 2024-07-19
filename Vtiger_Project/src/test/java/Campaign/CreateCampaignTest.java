package Campaign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateCampaignsPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigerLoginPage;


public class CreateCampaignTest extends BaseClass {


	//pass
	@Test(groups = "smokeTest")
	public void createCampaignTest() throws Throwable {
		HomePage home = new HomePage(driver);
        home.clickMoreLink();
         home.clickCampaignLink();
     
   //	 Assert.assertEquals(false, true);	   
        CreateCampaignsPage campPage = new CreateCampaignsPage(driver);
        campPage.clickCampPlusSign();
        int ranNum = jlib.getRandomNumber();
        
        String campaginName = elib.readExcelDataUsingDataFormatter("Campaign", 0, 0)+ranNum;
        campPage.enterCampName(campaginName);
        
          campPage.clickOnSaveButton();

//        ValidationAndVerification campvalidate = new ValidationAndVerification(driver);
//        campvalidate.campData(driver, campaginName);

  String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
  
   //Assert.assertEquals(actData, campaginName);
      
  Assert.assertTrue(actData.contains(campaginName));
  
 // Assert.assertTrue(actData.contains(campaginName),campaginName+"campaign name is not verified");
  
//  SoftAssert soft = new SoftAssert();
//  soft.assertEquals(actData, campaginName);
//  soft.assertAll();
	
	}

}
