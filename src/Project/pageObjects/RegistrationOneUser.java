package Project.pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationOneUser {
	WebDriver driver;
	//public static String REG_URL = "https://sandbox.2checkout.com/sandbox/acct/create_username";
	public static String REG_URL = "https://sandbox.2checkout.com/sandbox/acct/create_username";
	static By regUsername = By.xpath("//*[@id=\"create_username\"]/div[1]/div[1]/div/div[2]/input");
	static By regEmail = By.xpath("//*[@id=\"create_username\"]/div[1]/div[1]/div/div[1]/input");
	static By regPass = By.xpath("//*[@id=\"create_username\"]/div[1]/div[1]/div/div[3]/input");
	static By regConfPass =  By.xpath("//*[@id=\"create_username\"]/div[1]/div[1]/div/div[4]/input");
	static By regSubmit = By.cssSelector("#create_username > div:nth-child(2) > div > div > div");
	static By viewUser = By.xpath("//a[contains(text(),'User Management')]");
	static By delete = By.xpath("//*[@id=\"user-management\"]/tbody/tr[3]/td[10]/a");
	static By confDelete = By.xpath("//*[@id=\"disable_users\"]/input[2]");
	
	public void regEmail(WebDriver driver) {
		WebElement element2 = driver.findElement(regEmail);
		element2.sendKeys("marijana123@yahoo.com");
	}
	
	public void regUsername(WebDriver driver) {
		WebElement element1 = driver.findElement(regUsername);
		//this username set different
		element1.sendKeys("sjsjdjdj123");

	}
	
	public void regPass(WebDriver driver) {
		WebElement element3 = driver.findElement(regPass);
		element3.sendKeys("Marijana123");
	}
	
	
	public void regConfPass(WebDriver driver) {
		WebElement element4 = driver.findElement(regConfPass);
		element4.sendKeys("Marijana123");
	}
	
	/*public void about(WebDriver driver) {
		WebElement element5 = driver.findElement(aboutyou);
		Select select = new Select(element5);
		select.selectByVisibleText("I don't have a website");
		
	}*/
	
	public void regSubmit(WebDriver driver) {

		WebElement element5 = driver.findElement(regSubmit);
		element5.click();
	}
	
	public void regNewUserView(WebDriver driver) {
		WebElement element6 = driver.findElement(viewUser);
		element6.click();
	}
	
	
	public void regDelete(WebDriver driver) {
		WebElement element7 = driver.findElement(delete);
		element7.click();
	}
	
	public void regConfDelete(WebDriver driver) {
		WebElement element8 = driver.findElement(confDelete);
		element8.click();
	}
	
	
	
	public static String generateS() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    return generatedString;
	}
	

	public static void inputUSERNAME(WebDriver driver, String data) {
		WebElement element1 = driver.findElement(regUsername);
		element1.sendKeys(data);
	}

	

	
	
}
