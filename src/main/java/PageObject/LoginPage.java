package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Driver.DriverManager;

public class LoginPage extends DriverManager{
	
	public static String testName;
	public static String title;
	
	//User Name
	public WebElement username()
	{
		return driver.findElement(By.id("username"));
	}
	
	//Passsword
	public WebElement password()
	{
		return driver.findElement(By.id("password"));
	}
	
	//Terms and Condition check box
	public WebElement term()
	{
		return driver.findElement(By.id("terms"));
	}
	
	//Signin Button
	public WebElement signin()
	{
		return driver.findElement(By.id("signInBtn"));
	}

}
