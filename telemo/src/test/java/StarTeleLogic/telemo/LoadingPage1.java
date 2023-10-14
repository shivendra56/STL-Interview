package StarTeleLogic.telemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadingPage1 {
	
	WebDriver driver;
	
	//Load testing of page via invocation count to test the Loading of page.
	
	@Test(invocationCount = 3)
	public void LoadTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://mycc.telemo.io/");
		driver.getCurrentUrl();
		System.out.println("Page Title is: " + driver.getTitle());
		
		
		// Validating title of the page
		Assert.assertEquals("Login | Telemo- Telemo", driver.getTitle());
		
		
		driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("admin@sparrow.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("qwerty");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		// Validate the successful login
		String newcurrentURL = "https://mycc.telemo.io/dashboard"; 
	    String newcurrentURL1 = driver.getCurrentUrl();
		
	    // Assert that the current URL matches the expected URL
		Assert.assertEquals(newcurrentURL, newcurrentURL, "Login Successful");
		
	}

	

}
