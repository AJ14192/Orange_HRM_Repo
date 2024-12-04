package ObjectRepository;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {
	
	WebDriver driver;
	
	public MyInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Info']")
	private WebElement myInfoMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Contact Details']")
	private WebElement contactDetails;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[10]")
	private WebElement workEmail;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;
	
	public WebElement myInfoMenu() {
		return myInfoMenu;	
	}

	public WebElement contactDetails() {
		return contactDetails;	
	}
	
	public WebElement workEmail() {
		return workEmail;	
	}
	
	public WebElement saveButton() {
		return saveButton;	
	}
	
	
	public String generateRandomEmail() {
	       String emailPrefix = "Sam";
	       String emailDomain = "@yopmail.com";
	       int randomNum = new Random().nextInt(1000);
	       return emailPrefix + randomNum + emailDomain;
	   }

}
