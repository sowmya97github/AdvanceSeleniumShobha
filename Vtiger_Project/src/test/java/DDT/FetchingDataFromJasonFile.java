package DDT;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingDataFromJasonFile {

	public static void main(String[] args) throws Throwable {
		
		File file = new File("./src\\test\\resources\\JsonFile.json");
       
		ObjectMapper jsonData = new ObjectMapper();
        JsonNode data = jsonData.readTree(file);
        
       String URL = data.get("url").asText();
       String USERNAME = data.get("username").asText();
		
       WebDriver driver=new ChromeDriver();
       driver.get(URL);
       
	}

}
