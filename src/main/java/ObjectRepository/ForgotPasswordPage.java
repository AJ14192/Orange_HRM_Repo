package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(css = "button[type='submit']")
	private WebElement resetPasswordButton;
	
	@FindBy(xpath ="//h6[normalize-space()='Reset Password link sent successfully']")
	private WebElement validationMessage;
	
	
	public WebElement username() {
		return username;
	}
	
	public WebElement resetPasswordButton() {
		return resetPasswordButton;
	}
	
	public WebElement validationMessage() {
		return validationMessage;
	}

}
