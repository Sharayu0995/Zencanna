package com.code.ExcelDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Zencannalogin extends App
{
	WebDriver driver=null;
	
	 @BeforeSuite
	    public void openBrowser() throws InterruptedException
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\fidel\\eclipse-workspace\\ExcelDemo\\Driver\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	driver.manage().window().maximize();
	    	 driver.get("http://qa.zencanna.io");
		     //Thread.sleep(10000);
	    } 
	
    
   @DataProvider(name="getLog")
    public static Object[][] getLog() throws Exception
    {
	   Object[][] data = App.readExcel("C:\\Users\\fidel\\eclipse-workspace\\ExcelDemo\\Data\\Zencanatestdata.xlsx","Sheet1");
       return data;
         
	}
  
   @Parameters("openBrowser")
    @Test
	  public void setdata(String sUsername, String sPassword) throws Exception
	{
	  
      
		 driver.findElement(By.xpath("//input[@id='emailaddress']")).sendKeys(sUsername);

			System.out.println(sUsername);

	        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(sPassword);

			System.out.println(sPassword);

	        driver.findElement(By.xpath("//a[@class='btn pull-right greenoutline btn-border-radius-base']")).click();

	        System.out.println(" Login Successfully.");

	        driver.findElement(By.xpath("//span[@class='material-icons power_settings_new rubix-icon']")).click();
	        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
       }
	     
  /*  @AfterMethod
    public void close()
    {
    	 driver.close();
    }*/
}

