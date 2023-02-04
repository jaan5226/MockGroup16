package neoStox_POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utillity_Package.CommonMethod_Class;

public class NeoStox_PasswordPage
{
	@FindBy (id = "txt_accesspin") private WebElement pass;
	@FindBy (xpath = "//a[text()='Submit']") private WebElement submitButton;

	public NeoStox_PasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPassword(WebDriver driver, String mobNo) 
	{
		pass.sendKeys(mobNo);
		CommonMethod_Class.wait(driver, 1000);
		Reporter.log("Enter mobile number...", true);
	}
	
	public void clickOnSubmitButton(WebDriver driver) throws InterruptedException 
	{
		submitButton.click();
		Reporter.log("Click on sign in button...", true);
		Thread.sleep(2000);
	}
}
