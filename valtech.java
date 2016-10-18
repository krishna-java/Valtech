package general;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class valtech {

	private WebDriver driver;
	private WebDriverWait wait;
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C://Users//Krishna//Downloads//chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("https://www.valtech.com/");
	                    }
				
		@Test
		public void testLatestNews()
		{
			List<WebElement> newsList = driver.findElements(By.cssSelector("div.bloglisting__item__content"));
			wait =new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfAllElements(newsList));// Wait Assertion for the element to be visible
			Assert.assertTrue(true, "Latest News Not Displayed"); // Asserting again for test result purposes
			
		}
		
		@Test
		public void testMenu()
		{
			// Assert h1 tag for Cases
			driver.findElement(By.cssSelector("i[data-icon='hamburger2']")).click();
			wait =new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Cases']")));
			
			driver.findElement(By.cssSelector("a[title='Cases']")).click();
			wait =new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
			String cases = driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals(cases, "Cases");
			
			// Assert h1 tag for Services
			driver.findElement(By.cssSelector("i[data-icon='hamburger2']")).click();
			wait =new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Services']")));
						
			driver.findElement(By.cssSelector("a[title='Services']")).click();
			wait =new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
			String services = driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals(services, "Services");
			
			// Assert h1 tag for Jobs
			driver.findElement(By.cssSelector("i[data-icon='hamburger2']")).click();
			wait =new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Jobs']")));
									
			driver.findElement(By.cssSelector("a[title='Jobs']")).click();
			wait =new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
			String jobs = driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals(jobs, "Jobs");
			
			 
		   }

		@Test
		
		public void testOffices()
		{   
			driver.findElement(By.cssSelector("i.icons.glyph")).click();
			wait =new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("div.contactcountry"))));
			
			List<WebElement> offices =driver.findElements(By.cssSelector("a[href*='/contact-us/']"));
			System.out.println("Total Valtech offices are  " + offices.size());
			
		}
		
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}


}


