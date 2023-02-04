package baseClass_Package;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import utillity_Package.CommonMethod_Class;

public class NeoStox_BaseClass 
{
	protected WebDriver driver;
	
	public void openNeoStox() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://neostox.com/");
		driver.get(CommonMethod_Class.readDataFromPropertyFile("C:\\Users\\Jaber Khan\\eclipse-workspace\\MyMaven_Project\\src\\main\\resources\\CommonData.properties", "url"));
		CommonMethod_Class.wait(driver, 1000);
		Reporter.log("Launch browser and open NeoStox...", true);
	}
}
