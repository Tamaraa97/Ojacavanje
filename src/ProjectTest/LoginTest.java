package ProjectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Project.pageObjects.Login;

public class LoginTest {
WebDriver driver;
Login log;
	
	@BeforeClass
	public void openBrowser() {
		  System.setProperty(".webdriverchrome.driver", "chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	//log in if the user registration step has been skipped
	public void login() {
		driver.navigate().to(log.Log_URL);
		log = new Login();
		log.usernamelog(driver);
		log.passlog(driver);
		log.submitlog(driver);
		
		//we check if a message appears when we enter data with which we have not previously registered a user
		String actual_error = driver.findElement(By.id("login-error")).getText();
		String expected_error = "Incorrect username or password.";
		Assert.assertEquals(actual_error, expected_error);
		
		
	}
	
	
	@Test(priority=2)
	public void validLogin() {
		//we log in with one correct user, so that we can register all the others
		driver.navigate().to(log.Log_URL);
		log = new Login();
		log.inputUsername(driver);
		log.inputPassword(driver);
		log.clickSub(driver);
	}
}
