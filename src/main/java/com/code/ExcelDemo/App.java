package com.code.ExcelDemo;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class App 
{
	//private static WebDriver driver;
	
	static File resultFile = new File("C:\\Users\\fidel\\eclipse-workspace\\ExcelDemo\\Data\\Zencanatestdata.xlsx");
	
	
   public static DataFormatter formatter = new DataFormatter();
    
    /*@BeforeSuite
    public void openBrowser() throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\fidel\\eclipse-workspace\\ExcelDemo\\Driver\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.get("http://qa.zencanna.io");
	     Thread.sleep(10000);
	 
    }*/
	
	
	@DataProvider
	  public static Object[][] readExcel(String sheetname) throws IOException 
	{
		
	 FileInputStream fis= new FileInputStream(resultFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
	
        XSSFSheet sh = wb.getSheet(sheetname);

        
        int RowNum = sh.getPhysicalNumberOfRows();
        int ColNum = sh.getRow(0).getPhysicalNumberOfCells();

        Object[][] xlData = new String[RowNum-1][ColNum];

        
        for (int i = 0; i < RowNum; i++) 
        {
            XSSFRow row = sh.getRow(i + 1);
            for (int j = 0; j < ColNum; j++) 
            {
                if (row == null)
                    xlData[i][j] = "";
                else {
                    XSSFCell cell = row.getCell(j);                 
                    if (cell == null)
                        xlData[i][j] = ""; 
                    else {
                        String value = formatter.formatCellValue(cell);
                       // xlData[i][j] = sh.getRow(i+1).getCell(j).toString(); 
                        xlData[i][j] = value;
                    }
                }
            }
        }       
        return xlData;
    }   
}
	
	
		



	
	 

	 

  
