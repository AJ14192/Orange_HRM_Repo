package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

	
	WebDriver driver;
	
	public RecruitmentPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(xpath = "//h5[normalize-space()='Vacancies']")
	private WebElement vacanciesTitle;

	@FindBy(xpath = "//span[normalize-space()='Recruitment']")
	private WebElement recruitmentMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Vacancies']")
	private WebElement vacancies;

	public WebElement vacanciesTitle(){
		return vacanciesTitle;
	}
	
	public WebElement recruitmentMenu() {
		return recruitmentMenu;
	}
	
	public WebElement vacancies() {
		return vacancies;
	}
}
