package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;
import factory.DataProviderFactory;

public class DataProviderFactoryTest 
{

	@Test
	public void getConfigObject()
	{
		
	ConfigDataProvider config=DataProviderFactory.getConfig();
	
	Assert.assertTrue(config!=null);
		
	}
	
	@Test
	public void getExcelObject()
	{
		
	ExcelDataProvider excel=DataProviderFactory.getExcel();
		
	Assert.assertTrue(excel!=null);
	}
	
	
}
