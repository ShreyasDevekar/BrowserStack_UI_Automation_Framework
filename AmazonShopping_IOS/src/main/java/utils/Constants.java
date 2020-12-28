package utils;

import java.io.File;

public interface Constants 
{
	// file paths
	
	String capabilityPath = System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"propertyFiles"+File.separator+"capability.properties";
    String reportPath = System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"Automation_Report.html";
    String testDataFilePath = System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"testData"+File.separator+"Datasheet.xlsx";
    String passTestSnipsPath = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"PassTestSnips"+File.separator;
    String failTestSnipsPath = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"FailedTestSnips"+File.separator;
    String testEventSnips = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"TestEventSnips"+File.separator;
    String sheetName = "Sheet1";
    
}
