package StarTeleLogic.telemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationofPages {
	WebDriver driver;
	
	@BeforeMethod
	public void Pre_requisit(){
		
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			String baseUrl = "https://mycc.telemo.io/";
			driver.get(baseUrl);
	}
	@Test
	public void navigation() throws InterruptedException {
		
	String title = driver.getTitle();
	System.out.println("Title of the page is= " + title);
	
	String currentUrl = driver.getCurrentUrl();
	System.out.println("Current URL is: " + currentUrl);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("admin@sparrow.com");
	driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("qwerty");
	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	
	// Validate the successful login
	String newcurrentURL = "https://mycc.telemo.io/dashboard"; 
    String newcurrentURL1 = driver.getCurrentUrl();
	
    // Assert that the current URL matches the expected URL
	Assert.assertEquals(newcurrentURL, newcurrentURL, "Login Successful");
	Thread.sleep(5000);
	
	
	String urlToNavigate = "https://mycc.telemo.io/agentandteam;menu=agent";
	driver.navigate().to(urlToNavigate);
	System.out.println("Navigating To Product");
	currentUrl = driver.getCurrentUrl();
	System.out.println("Current URL is: " + currentUrl);
	String title2 = driver.getTitle();
	System.out.println("Title of the page is= " + title);
	
	Thread.sleep(2000);
	
	driver.navigate().back();
	System.out.println("Navigate Back");
	currentUrl = driver.getCurrentUrl();
	System.out.println("Current URL is: " + currentUrl);
	
	Thread.sleep(2000);
	
	driver.navigate().forward();
	System.out.println("Navigate Forward");
	currentUrl = driver.getCurrentUrl();
	System.out.println("Current URL is: " + currentUrl);
	
	
	Thread.sleep(2000);
	
	driver.navigate().refresh();
	System.out.println("Navigate Refresh");
	driver.get(currentUrl);
	System.out.println("Navigate Refresh");
	Thread.sleep(2000);

	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

