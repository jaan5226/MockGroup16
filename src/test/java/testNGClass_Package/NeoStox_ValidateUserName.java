package testNGClass_Package;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseClass_Package.NeoStox_BaseClass;
import neoStox_POMClasses.NeoStox_HomePage;
import neoStox_POMClasses.NeoStox_SignUpPage;
import neoStox_POMClasses.NeoStox_PasswordPage;
import neoStox_POMClasses.NeoStox_LogInPage;
import utillity_Package.CommonMethod_Class;

public class NeoStox_ValidateUserName extends NeoStox_BaseClass
{
  NeoStox_SignUpPage signIn;
  NeoStox_LogInPage logIn;
  NeoStox_PasswordPage pass;
  NeoStox_HomePage home;
  
  @BeforeClass
  private void launchBrowser() throws IOException
  {
	openNeoStox();
	CommonMethod_Class.wait(driver, 1000);
	signIn=new NeoStox_SignUpPage(driver);
	logIn=new NeoStox_LogInPage(driver);
	pass=new NeoStox_PasswordPage(driver);
	home=new NeoStox_HomePage(driver);
  }
  
  @BeforeMethod
  private void pu() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	signIn.clickOnSignInButton(driver);
	CommonMethod_Class.wait(driver, 1000);
//	logIn.enterMobileNumber(driver, CommonMethod_Class.readDataFromExcel(0, 0));
	logIn.enterMobileNumber(driver, CommonMethod_Class.readDataFromPropertyFile("mobNo"));
	CommonMethod_Class.wait(driver, 1000);
	logIn.clickOnSignInButton(driver);
	CommonMethod_Class.wait(driver, 1000);
//	pass.enterPassword(driver, CommonMethod_Class.readDataFromExcel(0, 1));
	pass.enterPassword(driver, CommonMethod_Class.readDataFromPropertyFile("pass"));
	CommonMethod_Class.wait(driver, 1000);
	pass.clickOnSubmitButton(driver);
	Thread.sleep(5000);
	home.handlePopUp(driver);
  }
  
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
  {
//	Assert.assertEquals(home.getUserName(driver), CommonMethod_Class.readDataFromExcel(0, 2));
	Assert.assertEquals(home.getUserName(driver), CommonMethod_Class.readDataFromPropertyFile("userName"));
	Reporter.log("TC is passed, Actual and expected user name is matched...", true);  
  }
  
  @AfterMethod
  public void logoutFromNeostox() 
  {
	home.clickOnLogOutButton(driver);
	Reporter.log("Loggingout from NeoStox...", true);
  }
  
  @AfterClass
  public void closingBrowser()
  {
	  Reporter.log("Closing browser...", true);
	  driver.close();
  }
}
