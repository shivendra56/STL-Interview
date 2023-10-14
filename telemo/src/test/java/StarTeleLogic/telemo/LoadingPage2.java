package StarTeleLogic.telemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadingPage2 {
	
WebDriver driver;
	
	//Load testing of page via invocation count and threadPoolSize to test the Loading of page.
	
	@Test(invocationCount = 2, threadPoolSize = 3)
	public void LoadTest() {
		driver = new ChromeDriver();
		driver.get("https://mycc.telemo.io/");
		driver.getCurrentUrl();
		System.out.println("Page Title is: " + driver.getTitle());
		System.out.printf("ThreadId: %s%n", Thread.currentThread().getId());
		
		// Validating title of the page
		Assert.assertEquals("Login | Telemo- Telemo", driver.getTitle());
	}
}

