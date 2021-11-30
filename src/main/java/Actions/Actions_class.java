package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Actions_class {
	
	public WebDriver driver;
	public WebDriverWait wait;
	static final int TIMEOUT = 40;
	static final int POLLING = 100;
	
	public Actions_class(WebDriver driver)
	{
		this.driver= driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}
	
	public void WebDriverWait(By element)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Element is not available");
		}
	}

	
	public void highLightElement(By elementBy) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style','border: 5px solid red;');", driver.findElement(elementBy));
			//sleepTime(3);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(elementBy), "");
		} catch (Exception e) {
			System.out.println(elementBy + "Is not HighLighting");// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
