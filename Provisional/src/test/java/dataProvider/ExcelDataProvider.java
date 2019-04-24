package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{

	 XSSFWorkbook wb;
	 XSSFSheet sh1;
	 
	
	
	public ExcelDataProvider()
	{
		
		
		File src=new File("C:\\ToolsQA\\eclipse_workspace\\com.Brics.Framework1\\TestData\\Data.xlsx");
		
		
		
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		}
		catch (Exception e) {
			
		}
		
	}
	
	
	
	public String getData(int sheetindex,int rownumber,int columnnumber)
	{
		
	 String data=wb.getSheetAt(sheetindex).getRow(rownumber).getCell(columnnumber).getStringCellValue();
		
	 
	 return data;
	}



	public int getRowCount(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
