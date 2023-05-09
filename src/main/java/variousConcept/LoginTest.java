package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
	}

	@Test
	public void loginTest() {
//		These are call Element Library
		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id=\'username\']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@type='password']"));
		WebElement SUBMIT_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@type='submit']"));
		
		USER_NAME_ELEMENT.clear(); //This will clear the box if there something exist
		USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");	
		SUBMIT_BUTTON_ELEMENT.click(); 
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
		driver.quit();

	}

}
