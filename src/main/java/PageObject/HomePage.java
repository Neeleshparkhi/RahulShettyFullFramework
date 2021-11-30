package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Driver.DriverManager;

public class HomePage extends DriverManager{

	//Total number of mobile available
	public List<WebElement> mobileOptions()
	{
		return driver.findElements(By.xpath("//*[@class='card-title']"));
	}
	
	//Mobile selection button
	public List<WebElement> addButton()
	{
		return driver.findElements(By.xpath("//div/button[contains(text(),'Add')]"));
	}
	
	//Check out button
	public WebElement checkout()
	{
		return driver.findElement(By.xpath("//*[@class='nav-link btn btn-primary']"));
	}
	
	//mobile price
	public WebElement mobileprice()
	{
		return driver.findElement(By.xpath("(//tr/td/strong)[2]"));
	}
	
	//Total price
	public WebElement totalprice()
	{
		return driver.findElement(By.xpath("//td/h3/strong"));
	}
	
	//Checkout button
	public WebElement finalcheckout()
	{
		return driver.findElement(By.xpath("(//*[@type=\"button\"])[4]"));
	}
	
	//Type Country
	public WebElement typecountry()
	{
		return driver.findElement(By.id("country"));
	}
	
	//Select the country
	public WebElement countries()
	{
		return driver.findElement(By.xpath("//div[@class='suggestions']/ul/li/a"));
	}
	
	//DropDown country
	
	By dropdowncountry = By.xpath("//*[@class='suggestions']/ul");
	
	public WebElement dropdownCountry()
	{
		return driver.findElement(By.xpath("//*[@class='suggestions']/ul"));
	}
	
	By checkbox2 = By.id("checkbox2");

	//terms and condition checkbox
	public WebElement checkboxatpurchase()
	{
		return driver.findElement(By.id("checkbox2"));
	}
	
	//purchase button
	public WebElement purchaseBt()
	{
		return driver.findElement(By.xpath("//*[@type=\"submit\"]"));
	}
	
	public WebElement successmsg()
	{
		return driver.findElement(By.xpath("//*[contains(text(),'Success!')]"));
	}
}
