package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LeavePage {

	WebDriver driver;
	
	public LeavePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[normalize-space()='Leave']")
	private WebElement leaveMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Apply']")
	private WebElement applyButton;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private WebElement selectLeaveType;
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	private WebElement familyType;
	
	@FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]")
	private WebElement formDate;
	
	@FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[2]")
	private WebElement toDate;
	
	@FindBy(xpath = "//button[normalize-space()='Apply']")
	private WebElement submitButton;
	
	
	
	public WebElement leaveMenu() {
		return leaveMenu;
	}
	
	public WebElement applyButton() {
		return applyButton;
	}
	
	public WebElement selectLeaveType() {
		return selectLeaveType;
	}
	
	public WebElement familyType() {
		return familyType;
	}
	
	public WebElement formDate() {
		return formDate;
	}
	
	public WebElement toDate() {
		return toDate;
	}
	
	public WebElement submitButton() {
		return submitButton;
	}
	
	

}


