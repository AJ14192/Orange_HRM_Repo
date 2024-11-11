package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement usernameField;
	
	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//p[normalize-space()='Invalid credentials']")
	private WebElement errorMessage;
	
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement userDropdown;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement logout;
	
	public WebElement usernameField() {
		return usernameField;
	}
	
	public WebElement passwordField() {
		return passwordField;
	}
	
	public WebElement loginButton() {
		return loginButton;
	}
	
	public WebElement forgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement errormessage() {
		return errorMessage;
	}
	
	public WebElement userDropdown() {
		return userDropdown;
	}
	
	public WebElement logout() {
		return logout;
	}
	
	
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.usernameField().sendKeys("Admin");
		loginPage.passwordField().sendKeys("admin123");
		loginPage.loginButton().click();
	}
	
	
}
