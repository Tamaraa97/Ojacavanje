package ProjectTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Project.pageObjects.Login;
import Project.pageObjects.ReadCustomerData;
import Project.pageObjects.Registration;
import Project.pageObjects.RegistrationOneUser;
public class RegistLoginTest extends RegOneUserTest{
	RegistrationOneUser rou;
	JavascriptExecutor js;

	@Test(priority=8)
	public void test30UsersReg() {
	ReadCustomerData.findExcelSheet();
	//with this test, we signup 30 users with data obtained from an excel file
	
	SoftAssert sa = new SoftAssert();
	
	
	for(int i = 1; i<ReadCustomerData.getRowNumber(); i++) {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("https://sandbox.2checkout.com/sandbox/acct/create_username");
	
	String registerUsername = ReadCustomerData.generateS();
	Registration.inputMail(driver, ReadCustomerData.EMail(i));
	RegistrationOneUser.inputUSERNAME(driver, String.valueOf(registerUsername));
	Registration.inputPass(driver, ReadCustomerData.Password(i));
	Registration.inputconfPass(driver, ReadCustomerData.ConfPassword(i));
	Registration.SubBtn(driver);
	}
	
	ReadCustomerData.closeFis();
	}
	
	
	/*@Test(priority=9)
	public void test30UsersLogin() {
		ReadCustomerData.findExcelSheet();
		SoftAssert sa = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for(int i = 1; i<ReadCustomerData.getRowNumber(); i++) {
			driver.navigate().to("https://sandbox.2checkout.com/sandbox/home/dashboard");
			Registration.Avatar(driver);
			Registration.clickSignOut(driver);
			Registration.inputLogUserName(driver, ReadCustomerData.UserName(i));
			Registration.inputLogPass(driver, ReadCustomerData.Password(i));
			Registration.clickLogin(driver);
		}
		ReadCustomerData.closeFis();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		Assert.assertTrue(actualUrl.contains(expectedUrl));
	}*/

	
	@Test(priority=10)
	public void deleteRegisteredUser1() {
	
		js = (JavascriptExecutor) driver;
		for(int i=1;i<20;i++) {
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/acct/list_usernames");
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.cssSelector(".content:nth-child(3) > td:nth-child(10) img")).click();
		driver.findElement(By.cssSelector("#disable_users > input.btn.orange")).click();
	}
	}
	
	@Test(priority=11)
	public void deleteRegisteredUser2() {
	//Creates a new test to delete registered users so that one automatically registered can be skipped and the test would not fail
		js = (JavascriptExecutor) driver;
		for(int i=1;i<12;i++) {
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/acct/list_usernames");
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.cssSelector(".content_alt:nth-child(4) > td:nth-child(10) img")).click();
		driver.findElement(By.cssSelector("#disable_users > input.btn.orange")).click();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://sandbox.2checkout.com/sandbox/acct/disable_users";
		Assert.assertTrue(actualUrl.contains(expectedUrl));
	}
	}

}
