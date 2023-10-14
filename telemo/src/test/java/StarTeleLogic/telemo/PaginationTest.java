package StarTeleLogic.telemo;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaginationTest {
	
	 WebDriver driver;

	    @BeforeClass
	    public void setup() {
	        // Set up the WebDriver and open the initial page
	        driver = new ChromeDriver();
	        driver.get("https://mycc.telemo.io/");
	    }
	    @Test
	    public void login() throws InterruptedException {
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

	    @Test(dependsOnMethods = "login")
	    public void automatePagination() throws InterruptedException {
	    	String urlToNavigate = "https://mycc.telemo.io/agentandteam;menu=agent";
	    	driver.navigate().to(urlToNavigate);
	    	System.out.println("Navigating To Product");
	    	String currentUrl = driver.getCurrentUrl();
	    	System.out.println("Current URL is: " + currentUrl);
	    	String title = driver.getTitle();
	    	System.out.println("Title of the page is= " + title);
	    	
	    	Thread.sleep(2000);
	    	
	    

	    	        // Click the "Next" button to navigate to the next page
	    	        WebElement NextPageButton = driver.findElement(By.xpath("//a[normalize-space()='1']"));
	    	        NextPageButton.click();
	    	   	 int totalPages = 5; // Set the total number of pages to navigate
		    	    for (int page = 1; page <= totalPages; page++) {
		    	    	
		    	    }
	    	    
	    	}
//		private void clickNextPageButton() {		
//		}

		
		@AfterClass
		public void teardown() throws InterruptedException {
			Thread.sleep(3000);
			driver.quit();
		}
}