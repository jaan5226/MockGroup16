package utillity_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class CommonMethod_Class 
{
	//1. Common method use for wait
	public static void wait(WebDriver driver, int waitTime) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("Wait for "+waitTime+"ms...", true);
	}
	
	//2. Common method for screenshot 
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException 
	{
		//create object of file class by casting
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//give path for save screenshot in system and store in variable
		File dest=new File("D:\\Selenium\\ScreenShots_Selenium\\"+fileName+".png");
		
		//copy src to dest by FileHandler class
		FileHandler.copy(src, dest);
		Reporter.log("take screenshot of "+fileName+"...", true);
	}

	//3. Common method for scrolling
	public static void scrollIntoView(WebDriver driver, WebElement element) 
	{
		//create object of JavaScripExecutor interface by casting
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("Scrolling into view at "+element+"...", true);
	}
	
	//4. Common method for data read from excel sheet
	public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException 
	{
//		//create object of file class and specify path of file location
//		File myFile=new File("D:\\Selenium\\Excel reading through Selenium\\"+fileName+".xlsx");
		File myFile=new File("D:\\Selenium\\Excel reading through Selenium\\Mock Group 16.xlsx");
		
		//use of workbook factory
//		String value = WorkbookFactory.create(myFile).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		String value = WorkbookFactory.create(myFile).getSheet("Neostox").getRow(row).getCell(cell).getStringCellValue();
		
		Reporter.log("Read data from excelsheet...", true);
		
		return value;
	}
	
	//5. Common method use for data read from properties file
	public static String readDataFromPropertyFile(String filePath, String key) throws IOException 
	{
		//create object of properties class
		Properties prop=new Properties();
		
		//create obj of FileInputStream and pass properties file path
//		FileInputStream file=new FileInputStream("C:\\Users\\Jaber Khan\\eclipse-workspace\\MyMaven_Project\\src\\main\\resources\\CommonData.properties");
		FileInputStream file=new FileInputStream(filePath);
		
		//load file object in properties
		prop.load(file);
		
		//get value from property file
		String value = prop.getProperty(key);
		Reporter.log("Read data from properties file...", true);
		return value;
	}
}
