package Project.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	public static String Log_URL = "https://sandbox.2checkout.com/sandbox";
	static By username = By.cssSelector("#va_login > div:nth-child(1) > input[type=text]");
	static By pass = By.id("password");
	static By submit = By.cssSelector("#va_login > input");
	WebDriver driver;
	
/*	public Login() {
		this.driver = driver;
	}
	*/
	
	
	public void usernamelog(WebDriver driver) {
		WebElement element1 = driver.findElement(username);
		element1.click();
		element1.sendKeys("Jovan");
	}
	
	public void passlog(WebDriver driver) {
		WebElement element2 = driver.findElement(pass);
		element2.click();
		element2.sendKeys("proba123");
	}
	
	public void submitlog(WebDriver driver) {
		WebElement element3 = driver.findElement(submit);
		element3.click();
	}
	
	
	public void inputUsername(WebDriver driver) {
		WebElement element1 = driver.findElement(username);
		element1.click();
		element1.sendKeys("rfrth01rfrsyth01");
	}
	
	public void inputPassword(WebDriver driver) {
		WebElement element2 = driver.findElement(pass);
		element2.click();
		element2.sendKeys("owkqgN3333");
	}
	
	public void clickSub(WebDriver driver) {
		WebElement element3 = driver.findElement(submit);
		element3.click();
	}
}
