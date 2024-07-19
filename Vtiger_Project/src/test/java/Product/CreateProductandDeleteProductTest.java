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

import Generic_Utilities.BaseClass;

public class CreateProductandDeleteProductTest extends BaseClass {

	public void createProductandDeleteProductTest()throws Throwable {
		
		 WebDriver driver=new ChromeDriver();
		 FileInputStream fis = new FileInputStream("./src/test/resources/CommonData10am.properties");
	     Properties pro = new Properties();
	     pro.load(fis);
	    
	    String URL = pro.getProperty("url");
	   String USERNAME = pro.getProperty("username");
	   String PASSWORD = pro.getProperty("password");
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
       
        Random ranNum = new Random();
        int ranNumber = ranNum.nextInt(1000);
       
        driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		//step1:- path connections
FileInputStream fis1 = new FileInputStream("./src/test/resources/ExcelSheet10am.xlsx");
	   
       //step2:-open workbook in read mode
	Workbook book = WorkbookFactory.create(fis1);
	
	  //step3:-get the control of the Sheet
	Sheet sheet = book.getSheet("Product");
	
	//step4:- get control of the row
	Row row = sheet.getRow(0);
	
	//step5:- get control of the cell
	Cell cell = row.getCell(0);
	
	String productData = cell.getStringCellValue()+ranNumber;
	
	System.out.println(productData);
    driver.findElement(By.name("productname")).sendKeys(productData);
 
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

    driver.findElement(By.linkText("Products")).click();
    
  //  driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td/input[@type='checkbox']")).click();
	
    driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+productData+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
	
	driver.findElement(By.xpath("//input[@value='Delete']")).click();
	
	driver.switchTo().alert().accept();
	
	List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
	
 boolean flag=false;
	 
	 for(WebElement prdName:productList)
	 {
		String actData = prdName.getText();
		if(actData.contains(productData))
		{
			flag=true;
			break;
		}
	 }
	if(flag)
	{
		System.out.println("product data is deleted");
	}
	else
	{
		System.out.println("product data not deleted");
	}
	
	 Thread.sleep(2000);
     driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
     driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
