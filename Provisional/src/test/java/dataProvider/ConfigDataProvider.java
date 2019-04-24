package dataProvider;



import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider 
{
	
	Properties pro;

	
	public ConfigDataProvider()
	{
		
		File src=new File("C:\\Users\\BasitM\\eclipse-workspace\\millCloud20\\src\\test\\resources\\Configuration\\config.properties");
		
		
		try 
		{
			
			FileInputStream fis=new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis);
			
		} 
		catch (Exception e) {
			
		}
		
	}
	
	
	public String getChromePath()
	{
		  
   	return pro.getProperty("ChromePath");
		
	}
	
	
	 public String getIEPath()
	 {
		 
		String ie_driver_path= pro.getProperty("IEpath");
		
		 return ie_driver_path;
	 }
	
	
}


