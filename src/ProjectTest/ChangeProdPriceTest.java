package ProjectTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Project.pageObjects.Login;
import Project.pageObjects.ReadCustomerData;
import Project.pageObjects.Registration;

public class ChangeProdPriceTest extends RegistLoginTest {
	JavascriptExecutor js;
Login log;
	
	@Test(priority=12)
	public void productadd() {
		ReadCustomerData.findExcelSheet();
		js = (JavascriptExecutor) driver;
		//we check if we can log in after registering all users
		//for(int i = 1; i<ReadCustomerData.getRowNumber(); i++) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_product");
		//we add 5 products to each user with data obtained from an excel file
		
		/*Registration.InputName(driver, ReadCustomerData.UserName(i));
		Registration.InputId(driver, ReadCustomerData.id(i));
		Registration.InputPrice(driver, "25");
		Registration.save(driver);
		Registration.view(driver);*/
		
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_product");
		Registration.InputName(driver, "abc");
		Registration.InputId(driver, "1");
		Registration.InputPrice(driver, "25");
		Registration.save(driver);
		Registration.view(driver);
		
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_product");
		Registration.InputName(driver, "abcd");
		Registration.InputId(driver, "2");
		Registration.InputPrice(driver, "25");
		Registration.save(driver);
		Registration.view(driver);
		
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_product");
		Registration.InputName(driver, "abcde");
		Registration.InputId(driver, "3");
		Registration.InputPrice(driver, "25");
		Registration.save(driver);
		Registration.view(driver);
		
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_product");
		Registration.InputName(driver, "abcdef");
		Registration.InputId(driver, "4");
		Registration.InputPrice(driver, "25");
		Registration.save(driver);
		Registration.view(driver);
		
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_product");
		Registration.InputName(driver, "abcdefg");
		Registration.InputId(driver, "5");
		Registration.InputPrice(driver, "25");
		Registration.save(driver);
		Registration.view(driver);
		
		//we change the price of the  product by deleting the old one first, all prices need to increase by 100
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_products");
		js.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Registration.edit1(driver);
		Registration.changePrice(driver, "125");
		js.executeScript("window.scrollBy(0,500)");
		Registration.save(driver);
		
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_products");
		js.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Registration.edit2(driver);
		Registration.changePrice(driver, "125");
		js.executeScript("window.scrollBy(0,500)");
		Registration.save(driver);
		
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_products");
		js.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Registration.edit3(driver);
		Registration.changePrice(driver, "125");
		js.executeScript("window.scrollBy(0,500)");
		Registration.save(driver);
		
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_products");
		js.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Registration.edit4(driver);
		Registration.changePrice(driver, "125");
		js.executeScript("window.scrollBy(0,500)");
		Registration.save(driver);
		
		driver.navigate().to("https://sandbox.2checkout.com/sandbox/products/edit_products");
		js.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Registration.edit5(driver);
		Registration.changePrice(driver, "125");
		js.executeScript("window.scrollBy(0,500)");
		Registration.save(driver);
		Registration.view(driver);
		//after all we used, need to log out the user the whole process is repeated 30 times
		Registration.prof(driver);
		Registration.clickSignOut(driver);
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://sandbox.2checkout.com/sandbox";
		Assert.assertTrue(actualUrl.contains(expectedUrl));

		}
	//	ReadCustomerData.closeFis();

		


}




