package LoginTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Actions.Actions_class;
import Driver.DriverManager;
import PageObject.HomePage;
import PageObject.LoginPage;

public class SelectMobileTest extends DriverManager{

	@BeforeTest
	public void BrowserSetup() throws IOException
	{
		
		DriverManager.getdriver().get(prop.getProperty("url"));
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test(priority=0)
	public void userLogin()
	{
		LoginPage lp = new LoginPage();
		lp.username().sendKeys("rahulshettyacademy");
		lp.password().sendKeys("learning");
		lp.term().click();
		lp.signin().click();
	}
	
	@Test(priority=1)
	public void mobileSelection() throws InterruptedException
	{
		HomePage hp = new HomePage();
		int count = hp.mobileOptions().size();
		String mobileN = "iphone X, Blackberry";
//		List<String> mobileList = Arrays.asList(mobileN.split(",\\s*"));
		for(int i=0;i<count; i++)
		{
			String mobilename = hp.mobileOptions().get(i).getText();
			if(mobilename.equalsIgnoreCase(prop.getProperty("mobilephone")))
			
			{
				hp.addButton().get(i).click();
			}
		}
		
		hp.checkout().click();
		String str = hp.mobileprice().getText();
		String pr[] = str.split(" ");
		System.out.println(pr[1]);
		String totalP = hp.totalprice().getText();
		String tp[]	=	totalP.split(" ");
		if(pr[1].equals(tp[1]))
		{
			System.out.println("Prise is matched");
			hp.finalcheckout().click();
		}
		hp.typecountry().sendKeys(prop.getProperty("country"));
		Thread.sleep(10000);
		String text = hp.countries().getText();
		System.out.println(text);
		Actions_class act = new Actions_class(driver);
		By dropdowncountry = By.xpath("//*[@class='suggestions']");
		act.WebDriverWait(dropdowncountry);
		act.highLightElement(dropdowncountry);
		//driver.findElement(By.xpath("//html")).click();
		//wait(ExpectedConditions.elementToBeClickable(By.xp));
		Actions action = new Actions(driver);
		action.moveToElement(hp.dropdownCountry()).click().build().perform();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", hp.checkboxatpurchase());
		//action.click().build().perform();
//		action.sendKeys(dropdowncountry, Keys.ENTER).
		//driver.findElement(elementBy).sendKeys(Keys.ENTER);
		//hp.dropdownCountry().sendKeys(Keys.ENTER);
		//hp.countries().sendKeys(Keys.DOWN)
		//hp.dropdownCountry().click();
		//hp.checkboxatpurchase().click();
		hp.purchaseBt().click();	
		String Actualmessage = hp.successmsg().getText();
		Assert.assertEquals(Actualmessage, "Success!");
	
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.close();
	}
}
