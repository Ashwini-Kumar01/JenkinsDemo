package dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.*;


public class ConfigFileReader {

	
	private Properties prop;

	private final String propertyFilePath= "Config//configuration.properties";
	 
	public ConfigFileReader() throws IOException
	{
		BufferedReader reader=new BufferedReader(new FileReader(propertyFilePath));
		prop=new Properties();
		prop.load(reader);
		reader.close();
	}
	
	public String getDriverPath(){
		 String driverPath = prop.getProperty("driverPath");
		 if(driverPath!= null) return driverPath;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }
	
	public DriverType getBrowser() {
		 String browserName = prop.getProperty("browser");
		 if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		 else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		 else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		 else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
		 }
		 
	public EnvironmentType getEnvironment() {
		 String environmentName = prop.getProperty("environment");
		 if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		 else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		 else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
		 }
}
