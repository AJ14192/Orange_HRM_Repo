package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PerformancePage {
	
WebDriver driver;
	
	public PerformancePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[normalize-space()='Performance']")
	private WebElement performanceMenu;
	
	@FindBy(xpath = "//h6[normalize-space()='Performance']")
	private WebElement performanceText;
	
	
	
	public WebElement performanceMenu() {
		return performanceMenu;
	}

	public WebElement performanceText() {
		return performanceText;
	}
}
