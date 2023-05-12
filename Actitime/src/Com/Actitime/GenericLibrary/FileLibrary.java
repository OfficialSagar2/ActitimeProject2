package Com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This is generic class used to read the data from generic method
 * @throws IOException
 */

public class FileLibrary {
/**
 * This is generic method used to read the data from property file
 * @throws IOException
 */
	public String ReadDataFromPropertyFile(String key) throws  IOException {
	
	FileInputStream F=new FileInputStream("./TestData/NewData.property");
    Properties P=new Properties();
    P.load(F);
    String value = P.getProperty(key);
    return value;
   
} 
	/**
	 * This is generic method used to read the data from excel file
	 * @throws IOException
	 */	
	public String ReadDataFromExcelFile(String sheetname,int row,int cell) throws InterruptedException, IOException {
    	
    	FileInputStream F1=new FileInputStream("./TestData/testData.xlsx");
    	Workbook Book = WorkbookFactory.create(F1);
    	String Data = Book.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();  
		return Data;
              
}
}
