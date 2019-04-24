package dataProvider;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class DataDrivenExcelFile{
 
 public static void main(String[] args) { 
 
        WebDriver driver = new FirefoxDriver();
 
        driver.get("http://www.google.com");
 
        driver.manage().window().maximize();  
       
        WebElement searchbox = driver.findElement(By.name("q"));
 
 try {
    
			FileInputStream file = new FileInputStream(
					new File("C:\\Users\\tester2\\eclipse-workspace\\millCloud20\\src\\test\\resources\\data\\testdata.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
 
			XSSFSheet sheet = workbook.getSheet("form");// XSSFSheetat.(0); Following code is to initialize the excel
															// sheet of the workbook. Here 0 (zero) refers to the first
															// sheet of the workbook.
 
for (int i=1; i <= sheet.getLastRowNum(); i++){
 
        String keyword = sheet.getRow(i).getCell(0).getStringCellValue();
 
        searchbox.sendKeys(keyword);
 
        searchbox.submit();       
  
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
 
}
 
  workbook.close();
  file.close();
 
 } catch (FileNotFoundException fnfe) {
  fnfe.printStackTrace();
 } catch (IOException ioe) {
  ioe.printStackTrace();
 }
 }
}