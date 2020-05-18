package Project.pageObjects;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {

	public static final String REGISTRATION_URL = "https://sandbox.2checkout.com/sandbox/signup";
	
	WebDriverWait wait;
	
	static By regUsern = By.xpath("//*[@id=\"create_username\"]/div[1]/div[1]/div/div[2]/input");
	static By regMail = By.xpath("//*[@id=\"create_username\"]/div[1]/div[1]/div/div[1]/input");
	static By regPassword = By.xpath("//*[@id=\"create_username\"]/div[1]/div[1]/div/div[3]/input");
	static By regConfP =  By.xpath("//*[@id=\"create_username\"]/div[1]/div[1]/div/div[4]/input");
	static By Submit = By.cssSelector("#create_username > div:nth-child(2) > div > div > div");
	static By loguser = By.xpath("//*[@id=\"va_login\"]/div[1]/input");
	static By logpass = By.id("password");
	static By loginBtn = By.xpath("//*[@id=\"va_login\"]/input");
	static By user = By.id("account-avatar");
	static By productname = By.xpath("//*[@id=\"create-edit-product\"]/form/div[2]/div[1]/div/div[1]/input");
	static By productId = By.xpath("//*[@id=\"create-edit-product\"]/form/div[2]/div[1]/div/div[2]/input");
	static By price = By.xpath("//*[@id=\"create-edit-product\"]/form/div[2]/div[1]/div/div[5]/input");
	static By saveBtn = By.xpath("//*[@id=\"create-edit-product\"]/form/div[3]/div/input[1]");
    static By viewBtn = By.xpath("//*[@id=\"sub-nav\"]/ul/li[1]/a");
    static By addProduct = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/a");
    static By profil = By.id("vendor");
    static By edit1 = By.xpath("//form[@id='update_bulk']/table/tbody/tr[2]/td/a");
    static By edit2 = By.xpath("//form[@id='update_bulk']/table/tbody/tr[3]/td/a");
    static By edit3 = By.xpath("//form[@id='update_bulk']/table/tbody/tr[4]/td/a");
    static By edit4 = By.xpath("//form[@id='update_bulk']/table/tbody/tr[5]/td/a");
    static By edit5 = By.xpath("//form[@id='update_bulk']/table/tbody/tr[6]/td/a");


	public void UsernameRegistration(WebDriver driver, String create_account_username) {
		WebElement regUsername = driver.findElement(regUsern);
		regUsername.clear();
		regUsername.sendKeys(create_account_username);	
	}
	
	public void mailRegistration(WebDriver driver, String create_account_email) {
		WebElement regAMail = driver.findElement(regMail);
		regAMail.clear();
		regAMail.sendKeys(create_account_email);	
	}
	
	public void PassRegistration(WebDriver driver, String create_account_pass) {
		WebElement regPasw = driver.findElement(regPassword);
		regPasw.clear();
		regPasw.sendKeys(create_account_pass);	
	}
	
	public void ConfRegistration(WebDriver driver, String create_account_confpass) {
		WebElement confPasw = driver.findElement(regConfP);
		confPasw.clear();
		confPasw.sendKeys(create_account_confpass);	
		WebElement submitBtn = driver.findElement(Submit);
		submitBtn.click();
	}
	
	
	public static void inputUsername(WebDriver driver, String username) {
		WebElement usernameField = driver.findElement(regUsern);
		usernameField.clear();
		usernameField.sendKeys(username);
	}
	
	public static void inputMail(WebDriver driver, String mail) {
		WebElement mailField = driver.findElement(regMail);
		mailField.clear();
		mailField.sendKeys(mail);
	}
	
	public static void inputPass(WebDriver driver, String pas) {
		WebElement pasField = driver.findElement(regPassword);
		pasField.clear();
		pasField.sendKeys(pas);
	}
	
	public static void inputconfPass(WebDriver driver, String confpas) {
		WebElement confpasField = driver.findElement(regConfP);
		confpasField.clear();
		confpasField.sendKeys(confpas);
	}
	
	public static void SubBtn(WebDriver driver) {
		WebElement submBtn = driver.findElement(Submit);
		submBtn.click();
	}
	public static void SubmitBtn(WebDriver driver) {
		WebElement submBtn = driver.findElement(Submit);
		submBtn.click();
	}
	
	public static void Avatar(WebDriver driver) {
		WebElement userAvatar = driver.findElement(user);
		userAvatar.click();
	}
	
	public static void clickSignOut(WebDriver driver) {
		WebElement element = driver.findElement(By.id("logout"));
		element.click();
	}
	
	
	public static void inputLogUserName(WebDriver driver,String logusername) {
		WebElement logUsernm = driver.findElement(loguser);	
		logUsernm.clear();
		logUsernm.sendKeys(logusername);
	}
	
	public static void inputLogPass(WebDriver driver,String logpassword) {
		WebElement logPas = driver.findElement(logpass);
		logPas.clear();
		logPas.sendKeys(logpassword);
	}
	
	
	public static void clickLogin(WebDriver driver) {
		WebElement Log = driver.findElement(loginBtn);
		Log.click();
	}
	
	public static void InputName(WebDriver driver,String ProductName) {
		WebElement product = driver.findElement(productname);
		product.sendKeys(ProductName);
		}
	
	public static void InputId(WebDriver driver,String Id)
	{
		WebElement prodId = driver.findElement(productId);
		prodId.sendKeys(Id);
	}
	
	public static void InputPrice(WebDriver driver,String CustPrice)
	{
		WebElement priceProd = driver.findElement(price);
		priceProd.sendKeys(CustPrice);
		
	}
	
	public static void save(WebDriver driver) {
		WebElement btn = driver.findElement(saveBtn);
		btn.click();
	}
	
	public static void view(WebDriver driver) {
		WebElement vw = driver.findElement(viewBtn);
		vw.click();
	}
	
	public static void add(WebDriver driver) {
		WebElement newProd = driver.findElement(addProduct);
		newProd.click();
	}
	
	public static void prof(WebDriver driver) {
		WebElement userProfil = driver.findElement(profil);
		userProfil.click();
	}
	
	
	public static void edit1(WebDriver driver) {
		WebElement ed = driver.findElement(edit1);
		ed.click();
	}

	public static void edit2(WebDriver driver) {
		WebElement ed2 = driver.findElement(edit2);
		ed2.click();
	}
	
	public static void edit3(WebDriver driver) {
		WebElement ed3 = driver.findElement(edit3);
		ed3.click();
	}
	
	public static void edit4(WebDriver driver) {
		WebElement ed4 = driver.findElement(edit4);
		ed4.click();
	}
	
	public static void edit5(WebDriver driver) {
		WebElement ed5 = driver.findElement(edit5);
		ed5.click();
	}
	
	public static void changePrice(WebDriver driver, String newPrice) {
		WebElement nwPrice = driver.findElement(price);
		nwPrice.clear();
		nwPrice.sendKeys(newPrice);
	}
	
	
	
	
	
	
}
