package neoStox_POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utillity_Package.CommonMethod_Class;

public class NeoStox_SignUpPage 
{
	@FindBy (xpath = "(//a[text()='Sign In'])[1]") private WebElement signIn;
	
	public NeoStox_SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignInButton(WebDriver driver) 
	{
		signIn.click();
		CommonMethod_Class.wait(driver, 1000);
		Reporter.log("Click on sign in button...", true);
	}
}
