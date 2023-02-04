package neoStox_POMClasses;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utillity_Package.CommonMethod_Class;

public class NeoStox_HomePage 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	@FindBy(xpath = "(//a[@id='navbarDropdown']//span)[3]") private WebElement userName;
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown')]//input") private WebElement darkTheme;	
	@FindBy(xpath = "//span[@id='lbl_curbalancetop']") private WebElement availablefunds;
	@FindBy(id = "navbarDropdown") private WebElement dropDownButton;
	@FindBy(id = "lnk_logout") private WebElement logOutButton;
	
	public NeoStox_HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//use for combo test Ng class where we declared validate userName as well accBalance
	public void handlePopUp(WebDriver driver)
	{
		if(okButton.isDisplayed())
		{
			CommonMethod_Class.wait(driver, 1000);
			okButton.click();
			Reporter.log("clicking on ok button...", true);
			CommonMethod_Class.wait(driver, 1000);
//			closeButton.click();
//			Reporter.log("clicking on close button...", true);
		}
		else
		{
			CommonMethod_Class.wait(driver, 1000);
			Reporter.log("Pop-Up not display so just wait for few ms...", false);
		}
	}
	
	public String getUserName(WebDriver driver) throws IOException
	{
		String actUserName = userName.getText();
		CommonMethod_Class.scrollIntoView(driver, userName);
		CommonMethod_Class.wait(driver, 1000);
		String actualUserName = actUserName.substring(3);
		CommonMethod_Class.takeScreenshot(driver, actualUserName);
		Reporter.log("getting actual user name...", true);
		return actUserName;
	}
	
	public String getAvailableFunds(WebDriver driver) throws IOException 
	{
		CommonMethod_Class.scrollIntoView(driver, availablefunds);
		CommonMethod_Class.wait(driver, 1000);
		CommonMethod_Class.takeScreenshot(driver, "NeostoxAccBal");
		String accBalance = availablefunds.getText();
		Reporter.log("getting available fund is "+accBalance+"...", true);
		return accBalance;
	}
	
	public void clickonDarkTheme() throws InterruptedException 
	{
		userName.click();
		Thread.sleep(1000);
		darkTheme.click();
	}
	
	public void clickOnLogOutButton(WebDriver driver) 
	{
		CommonMethod_Class.wait(driver, 1000);
		dropDownButton.click();
		CommonMethod_Class.wait(driver, 1000);
		logOutButton.click();
		Reporter.log("clicking on logout button...", true);
	}

}
