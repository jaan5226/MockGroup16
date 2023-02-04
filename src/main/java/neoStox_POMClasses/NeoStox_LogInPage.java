package neoStox_POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utillity_Package.CommonMethod_Class;

public class NeoStox_LogInPage 
{
	@FindBy (id = "MainContent_signinsignup_txt_mobilenumber") private WebElement mobNumber;
	@FindBy (id = "lnk_signup1") private WebElement signInButton;
	
	public NeoStox_LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileNumber(WebDriver driver, String mobNo) 
	{
		mobNumber.sendKeys(mobNo);
		CommonMethod_Class.wait(driver, 1000);
		Reporter.log("Enter mobile number...", true);
	}
	
	public void clickOnSignInButton(WebDriver driver) 
	{
		signInButton.click();
		CommonMethod_Class.wait(driver, 1000);
		Reporter.log("Click on sign in button...", true);
	}
}
