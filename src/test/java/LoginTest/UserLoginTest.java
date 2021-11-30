package LoginTest;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Driver.DriverManager;
import PageObject.LoginPage;
import Utility.Screenshot;

public class UserLoginTest extends DriverManager{
	
	public static String testName;
	public static String title;
	
	
	@BeforeTest
	public void BrowserSetup() throws IOException
	{
		
		DriverManager.getdriver().get(prop.getProperty("url"));
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test
	public void userLogin()
	{
		LoginPage lp = new LoginPage();
		lp.title="Login";
		lp.testName="UserLoginTest";
		lp.username().sendKeys("rahulshettyacademy");
		lp.password().sendKeys("learning");
		lp.term().click();
		lp.signin().click();
		Screenshot.captureScreen(driver, title, testName);
	}
}
