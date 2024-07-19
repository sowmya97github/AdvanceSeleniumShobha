package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertingDataToProperties_File {

	public static void main(String[] args) throws Throwable {
		
		//writting data to property_file
		Properties pro = new Properties();
		pro.setProperty("username", "standard_user");
		pro.setProperty("password", "secret_sauce");
		pro.setProperty("url", "https://www.saucedemo.com/v1/");
		
	FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\FileCommomData.properties");
	pro.store(fos, "CommonData");
	System.out.println("Data written Successfully");
	
	//-----------------------------------------------------------------------------------------------------------------------
	//read data from property_file
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
    
 FileInputStream fis1 = new FileInputStream("./src\\test\\resources\\FileCommomData.properties");
    
  //step2:-Create an object to properties class to load all the keys
 Properties pro1 = new Properties();
 pro1.load(fis1);
 
 //step3:-
String URL = pro.getProperty("url");
String USERNAME = pro.getProperty("username");
String PASSWORD = pro.getProperty("password");
	
driver.get(URL);
driver.findElement(By.id("user-name")).sendKeys(USERNAME);
driver.findElement(By.id("password")).sendKeys(PASSWORD);
driver.findElement(By.id("login-button")).click();
	}

}
