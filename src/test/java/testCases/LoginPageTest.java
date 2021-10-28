package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import page.DataBasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpageObj;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void setup() {
	initializeDriver();
	loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test(priority=1)
	public  void LoginTest() throws ClassNotFoundException, SQLException, InterruptedException, IOException  {
	//loginpageObj.insertUserName("Demo@techfios.com");
	loginpageObj.insertUserName(DataBasePage.getData("username"));
	String UserName =DataBasePage.getData("username");
	System.out.println("username: "+  UserName); 
    Thread.sleep(2000);
	
    //loginpageObj.insertPassword("abc123");
	loginpageObj.insertPassword(DataBasePage.getData("password"));
	String pass=DataBasePage.getData("password");
	System.out.println("password: "+ pass); 
	Thread.sleep(2000);
	loginpageObj.clickOnSigninButton();
	
	takeScreenshotAtEndOfTest(driver);
	}
	
	
	@Test(priority=2)
	public void LoginPageTitleTest() throws ClassNotFoundException, SQLException, InterruptedException  {
	loginpageObj.insertUserName(DataBasePage.getData("username"));
	Thread.sleep(2000);
	loginpageObj.insertPassword(DataBasePage.getData("password"));
	Thread.sleep(2000);
	loginpageObj.clickOnSigninButton();
	
	String expectedTitle="Dashboard- iBilling";
	String actualTitle=loginpageObj.getPageTitle();
	Assert.assertEquals(expectedTitle, actualTitle);
//softAssert.assertEquals(expectedTitle, actualTitle);
	//System.out.println(actualTitle);
	}
	

	
	@AfterMethod
	public void tearDown() {
	driver.close();
	driver.quit();
}
}