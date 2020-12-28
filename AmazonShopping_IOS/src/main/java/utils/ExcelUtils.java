package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	/* Description: This constructor initializes workbook and sheet. 
	 * Created By: Shreyas Devekar
	 * Parameters : filePath - test data file path
	 *              sheetName - sheet name of test data.
	 */
	
	public ExcelUtils(String filePath,String sheetName)
	{
		try 
		{
			workbook = new XSSFWorkbook(filePath);
			sheet = workbook.getSheet(sheetName);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			ReportGeneration.logger.info("Excel file cannot be initialized");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
		}
	}
	
	/* Description: This method returns row count of sheet.
	 * Created By: Shreyas Devekar
	 */
	
	public static int rowCount()
	{
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
	
	/* Description: This method returns cell data in string format. 
	 * Created By: Shreyas Devekar
	 * Parameters : rowNumber - row number of test data
	 *              colNumber - column number of test data.
	 */
	
	public static String getStringCellData(int rowNumber, int colNumber)
	{
		String cellData = sheet.getRow(rowNumber).getCell(colNumber).getStringCellValue();
		return cellData;
	}
	
	/* Description: This method returns cell data in numeric format. 
	 * Created By: Shreyas Devekar
	 * Parameters : rowNumber - row number of test data
	 *              colNumber - column number of test data.
	 */
	
	public double getNumericCellData(int rowNumber, int colNumber)
	{
		double cellData = sheet.getRow(rowNumber).getCell(colNumber).getNumericCellValue();
		return cellData;
	}

}
