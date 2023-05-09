package variousConcept;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest_UsingByClass {
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
	}

	@Test
	public void loginTest() {
		
//These are call Element Library
		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id=\'username\']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@type='password']"));
		WebElement SUBMIT_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@type='submit']"));
		
//WebElement Library using ByClass
		By USER_NAME_FIELD = By.xpath("//input[@id=\'username\']");
		By PASSWORD_FIELD = By.xpath("//input[@type='password']");
		By SUBMIT_BUTTON_FIELD = By.xpath("//button[@type='submit']");	
		By DASHBOARD_TITLE_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");
		
//Using ByClass
		USER_NAME_ELEMENT.clear();
		USER_NAME_ELEMENT.sendKeys("demo@techfios.com");		
//Here 'password' intentionally typed incorrect to make it TestCase FAIL	
		PASSWORD_ELEMENT.sendKeys("abc123444");
		driver.findElement(SUBMIT_BUTTON_FIELD).click();
		
		boolean pasgeTitleDisplayStatus;
		
		try {
			WebElement DASHBOARD_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
			pasgeTitleDisplayStatus = true;
			
		}catch(Exception e) {
			pasgeTitleDisplayStatus = false;
			e.printStackTrace();
		}

//	Explicit wait	
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_TITLE_FIELD));	
		Assert.assertTrue("DASHBOARD NOT FOUND !", pasgeTitleDisplayStatus);
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.close();
		driver.quit();

	}
}
