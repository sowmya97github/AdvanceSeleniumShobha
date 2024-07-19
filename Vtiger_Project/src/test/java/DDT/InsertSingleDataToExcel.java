package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcel {

	public static void main(String[] args) throws Throwable {
		
		//step1:- path connections
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\ExcelTestData.xlsx");
			   
		       //step2:-open workbook in read mode
			Workbook book = WorkbookFactory.create(fis);
			
			  //step3:-get the control of the Sheet
			Sheet sheet = book.getSheet("Sheet1");
			  
			//step4:-
			Row row = sheet.createRow(2);
			
			Cell cell = row.createCell(5);
			
			cell.setCellValue("2024");
			
			FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\ExcelTestData.xlsx");
			book.write(fos);
			book.close();
			
	}

}
