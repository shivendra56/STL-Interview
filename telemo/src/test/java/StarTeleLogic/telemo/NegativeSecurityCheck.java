package StarTeleLogic.telemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeSecurityCheck {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void Prerequist() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://mycc.telemo.io/");
		
		
	}
	// Login with incorrect credentials so to check no other user can login with different credentials.
	@Test
	public void LoginwithincorrectDetails() {
		driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("admin@sparrow.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("abc");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		// Validation point of the error message
		Assert.assertEquals("Your Userid and password is not correct", "Your Userid and password is not correct");
	}
	
	@AfterMethod
	public void EndofTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
