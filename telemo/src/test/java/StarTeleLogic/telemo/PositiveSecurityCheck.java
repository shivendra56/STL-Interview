package StarTeleLogic.telemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveSecurityCheck {

	
	WebDriver driver;
	String errorMessage;
	
	@BeforeMethod
	public void Prerequist() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://mycc.telemo.io/");
		
		
	}
	@Test
	public void LoginwithincorrectDetails() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("admin@sparrow.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("qwerty");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		// Validate the successful login
		String newcurrentURL = "https://mycc.telemo.io/dashboard"; 
	    String newcurrentURL1 = driver.getCurrentUrl();
		
	    // Assert that the current URL matches the expected URL
		Assert.assertEquals(newcurrentURL, newcurrentURL, "Login Successful");
		
		Thread.sleep(3000);
}
	
	@AfterMethod
	public void EndofTest() {
		driver.quit();
	}
}
