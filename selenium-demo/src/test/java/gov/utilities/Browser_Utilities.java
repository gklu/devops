package gov.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
public class Browser_Utilities extends Driver{
	
	
//public static void waitfor(WebElement by) {
//		
//		WebDriverWait wait = new WebDriverWait(driver, 40);
//		ExpectedCondition<WebElement> con = ExpectedConditions.visibilityOf(by);
//		wait.until(con);
//		
//		
//	}
		
		
	
		public static void calendarTodayDate() {
			DateFormat dateFormat2 = new SimpleDateFormat("dd"); 
			Date date2 = new Date();
			String today = dateFormat2.format(date2); 
			WebElement dateWidget = driver.findElement(By.cssSelector("#ui-datepicker-div"));  
			List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

			for (WebElement cell : columns)
			{
			   if (cell.getText().equals(today))
			   {
			      cell.click();
			      break;
			   }
				
			}

	
}
	
	
	
		
		public static String getlocation(String expectedValue) {
			int rows = driver.findElements(By.xpath("//Tbody/tr")).size();
			int columns = driver.findElements(By.xpath("//tbody/tr[1]/td")).size();
			for (int row = 0; row<rows; row++) {
				for (int column = 0 ; column < columns ; column++) {
					String cellValue = getCellValue(row, column);
					if (cellValue.equals(expectedValue)) {
						return row + ":" + column;
					}
				}
			}
			return null;
			
		}
		
		public static String getCellValue (int row, int column) {
			String xpath = "//tbody/tr[" + row+ "]/td[" + column + "]";
			return driver.findElement(By.xpath(xpath)).getText();
			
			
		}

		
		public static boolean check (WebElement element, boolean check) {
			if (check = true) {
				if (!element.isSelected()) {
					element.click();
				}
			}else {
				if(element.isSelected()) {
					element.click();
				}
			}
			return check;
		}	
			
			
			public static boolean uncheck (WebElement element, boolean uncheck) {
				if (uncheck = true) {
					if(element.isSelected()) {
						element.click();
					}
			}
				return uncheck;
			}
		
			public static boolean checkOptions(String string){
			   Select dropdown = new Select(driver.findElement(By.className("selectize-dropdown-content")));
			   List<WebElement> options = dropdown.getOptions();
			   int k = 0;
			    for (WebElement opt : options){
			        if (opt.getText().equals(string)){
			            return true;
			        }  
			        k = k + 1;	    
			}
				return false;
		
			
		}

}
