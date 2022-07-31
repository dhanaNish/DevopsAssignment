package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class searchInAmazon {
	public WebDriver driver;
	public WebElement element;


	@Given("^user is on homepage$")
	public void homepage() throws IOException
	{
		//Chrome driver implementation
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Webdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		/*
		//Close new tab
		String currHandle = driver.getWindowHandle();
		String winHandle = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(winHandle);
        driver.close();
		driver.switchTo().window(currHandle);
		*/
		
		//Navigate to homepage
		driver.get("https://www.amazon.in/");
		//System.out.println("User is on homepage");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
							
	}
	
	@When("user checks for Today's Deals menu in top of homepage")
	public void checkTodayDeals()
	{
		element = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));	
		
	}
	
	@Then("Today's Deals menu is present in homepage header section")
	public void todayDealsMenu()
	{
		
		String s = element.getText();
		
		Assert.assertEquals("Verification failed: Today's Deals menu has a different name","Today's Deals", s);
		driver.quit();
	}
	
	@When("user clicks on Prime menu")
	public void clickPrime()
	{
		driver.findElement(By.xpath("//*[@id='nav-link-prime']")).click();		
	}
	
	@Then("user is navigated to Amazon Prime details page")
	public void navPrime()
	{
		String primeUrl= "https://www.amazon.in/amazonprime?ref_=nav_cs_primelink_nonmember";
		String currUrl= driver.getCurrentUrl();
		Assert.assertEquals("Verification failed : User is not navigated to prime details page",currUrl, primeUrl);
		String text = driver.findElement(By.xpath("//*[@id='primeDetailPage']/div[1]/div[2]/h1")).getText();
		Assert.assertEquals("Verification failed: Amazon Prime details page has a different heading","Unlimited FREE fast delivery, videos, music, gaming & more", text);
		text = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/div[2]/span/span/a")).getText();
		Assert.assertEquals("Verification failed: Amazon Prime details page does not have 'Login to join Prime' button","Login to join Prime", text);
		driver.quit();
	}


	
}

