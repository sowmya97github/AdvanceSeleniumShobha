package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelUsingDataFormatter {

	public static void main(String[] args) throws Throwable {
		//step1:- path connections
FileInputStream fis = new FileInputStream("./src\\test\\resources\\ExcelTestData.xlsx");
	   
       //step2:-open workbook in read mode
	Workbook book = WorkbookFactory.create(fis);
	
	  //step3:-get the control of the Sheet
	Sheet sheet = book.getSheet("Sheet1");
	
	//step4:- get control of the row
	Row row = sheet.getRow(0);
	
	//step5:- get control of the cell
	Cell cell = row.getCell(0);
	
	//String ExcelData = cell.getStringCellValue();
	//System.out.println(ExcelData);
    DataFormatter format = new DataFormatter();
    String ExcelData = format.formatCellValue(cell);
	System.out.println(ExcelData);
	
	}

}
