package ProjectTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Project.pageObjects.ReadCustomerData;
import Project.pageObjects.Registration;
import Project.pageObjects.RegistrationOneUser;


public class RegOneUserTest extends LoginTest {
	JavascriptExecutor js;
	RegistrationOneUser reg;
	
	
	@Test(priority=3)
	public void oneUserRegTest() {
		SoftAssert sa = new SoftAssert();
		String registerUsername = RegistrationOneUser.generateS();
		driver.navigate().to(RegistrationOneUser.REG_URL);
		reg = new RegistrationOneUser();
		//registration user with random username
		reg.regEmail(driver);
		RegistrationOneUser.inputUSERNAME(driver, String.valueOf(registerUsername));
		reg.regPass(driver);
		reg.regConfPass(driver);
		reg.regSubmit(driver);	
		//after registering the created user we delete
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/acct/list_usernames");
		driver.findElement(By.cssSelector("#user-management > tbody > tr.content > td:nth-child(10) > a")).click();
		driver.findElement(By.cssSelector("#disable_users > input.btn.orange")).click();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://sandbox.2checkout.com/sandbox/acct/disable_users";
		Assert.assertTrue(actualUrl.contains(expectedUrl));
	}
	
//Test of the number 4 to number 7,checks what will happen if we skip some of a step when registering a user
	
	@Test(priority=4)
	public void getUsernameIsNull() {
		//whether a message appears if we leave the username blank
		driver.navigate().to(reg.REG_URL);
		reg = new RegistrationOneUser();
		reg.regEmail(driver);
		reg.regPass(driver);
		reg.regConfPass(driver);
		reg.regSubmit(driver);
		
		String actual_error = driver.findElement(By.className("form_invalid")).getText();
		String expected_error = "Invalid Username";
		Assert.assertEquals(actual_error, expected_error);
	}
	
	@Test(priority=5)
	public void getEmailIsNull() {
		//whether a message appears if we leave the email blank
		driver.navigate().to(reg.REG_URL);
		reg = new RegistrationOneUser();
		reg.regUsername(driver);
		reg.regPass(driver);
		reg.regConfPass(driver);
		reg.regSubmit(driver);
		
		String actual_error = driver.findElement(By.className("form_invalid")).getText();
		String expected_error = "Invalid Email Address";
		Assert.assertEquals(actual_error, expected_error);
	}
	
	@Test(priority=6)
	public void getPassIsNull() {
		//whether a message appears if we leave the password blank
		driver.navigate().to(reg.REG_URL);
		reg = new RegistrationOneUser();
		reg.regUsername(driver);
		reg.regEmail(driver);
		reg.regConfPass(driver);
		reg.regSubmit(driver);

		String actual_error = driver.findElement(By.className("form_invalid")).getText();
		String expected_error = "Invalid Password: Passwords must be:\n" + 
				"• A minimum of 8 characters\n" + 
				"• Contain at least one letter and one number\n" + 
				"• Contain at least one capital letter";
		Assert.assertEquals(actual_error, expected_error);
	}
	
	@Test(priority=7)
	public void getConfPassIsNull() {
		//whether a message appears if we leave the conf.password blank
		driver.navigate().to(reg.REG_URL);
		reg = new RegistrationOneUser();
		reg.regUsername(driver);
		reg.regEmail(driver);
		reg.regPass(driver);
		reg.regSubmit(driver);

		
		String actual_error = driver.findElement(By.className("form_invalid")).getText();
		String expected_error = "Passwords did not match.";
		Assert.assertEquals(actual_error, expected_error);
	}
	



}

