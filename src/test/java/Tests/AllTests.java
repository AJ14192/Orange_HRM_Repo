package Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ObjectRepository.AdminPage;
import ObjectRepository.BuzzPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.ForgotPasswordPage;
import ObjectRepository.LeavePage;
import ObjectRepository.LoginPage;
import ObjectRepository.MyInfoPage;
import ObjectRepository.PerformancePage;
import ObjectRepository.RecruitmentPage;
import resources.Base;

public class AllTests extends Base {
	
	WebDriver driver;
    WebDriverWait wait;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		driver = initializeDriver();
        driver.get(prop.getProperty("url"));  // Ensure this points to a valid URL
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@Test(dataProvider = "loginData")
	public void OHRM001Test(String username, String password) {
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.usernameField().sendKeys(username);
		loginPage.passwordField().sendKeys(password);
		loginPage.loginButton().click();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.dashboard().isDisplayed();
		
	}
	
	@Test(dataProvider = "invalidLoginData")
	public void OHRM002Test(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.usernameField().sendKeys(username);
		loginPage.passwordField().sendKeys(password);
		loginPage.loginButton().click();
		loginPage.errormessage().isDisplayed();		
		
	}
	
	@Test(dataProvider = "username")
	public void OHRM003Test(String username) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.forgotPasswordLink().click();
		
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.username().sendKeys(username);
		forgotPasswordPage.resetPasswordButton().click();	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement validationMessage = forgotPasswordPage.validationMessage();
		    
		wait.until(ExpectedConditions.visibilityOf(validationMessage));		  		
		
	}
	
	@Test(dataProvider = "loginData")
	public void OHRM004Test(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();

	    AdminPage adminPage = new AdminPage(driver);
	    adminPage.adminMenu().click();
	    adminPage.addButton().click();

	    adminPage.selectCustomDropdown(adminPage.selectUserRole(), "Admin");
	    adminPage.selectCustomDropdown(adminPage.selectStatus(), "Enabled");

	    adminPage.employeeNameField().sendKeys("James Butler");
	    adminPage.usernameField().sendKeys(adminPage.generateRandomUName());
	    adminPage.passwordField().sendKeys("admin123");
	    adminPage.confirmPasswordField().sendKeys("admin123");
	    adminPage.saveButton().click();
		
	}
	
	@Test
	public void OHRM005Test() {
		
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.login();

	    LeavePage leavePage = new LeavePage(driver);
	    leavePage.leaveMenu().click();
	    leavePage.applyButton().click();
	    leavePage.selectLeaveType().click();
	    leavePage.familyType().sendKeys(Keys.DOWN);
	    leavePage.familyType().sendKeys(Keys.ENTER);
	    leavePage.formDate().sendKeys("2026-02-02");
	    leavePage.formDate().sendKeys(Keys.TAB);
	    leavePage.submitButton().click();
	   
	}
	
	@Test
	public void OHRM006Test() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
	
		MyInfoPage myInfoPage = new MyInfoPage(driver);
		myInfoPage.myInfoMenu().click();
		myInfoPage.contactDetails().click();
		myInfoPage.workEmail().sendKeys(myInfoPage.generateRandomEmail());
		myInfoPage.workEmail().sendKeys(Keys.TAB);
		myInfoPage.workEmail().sendKeys(Keys.ENTER);
	}
	
	@Test
	public void OHRM007Test() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
		
		PerformancePage performancePage = new PerformancePage(driver);
		performancePage.performanceMenu().click();
		performancePage.performanceText().isDisplayed();
		
	}
	
	@Test
	public void OHRM008Test() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
		
		RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
		recruitmentPage.recruitmentMenu().click();
		recruitmentPage.vacancies().click();
		
	}
	
	@Test
	public void OHRM009Test() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
		
		BuzzPage buzzPage = new BuzzPage(driver);
		buzzPage.buzzMenu().click();
		buzzPage.postArea().sendKeys("Hello all, I am Ram new QA Automation Engineer");
		buzzPage.postButton().click();
		driver.navigate().refresh();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void OHRM010Test() throws IOException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
		
		BuzzPage buzzPage = new BuzzPage(driver);
		buzzPage.buzzMenu().click();
		buzzPage.selectPhotoButton().click();
		buzzPage.addText().sendKeys("Hello all, I am sharing this image");
		buzzPage.addPhotos().click();
		buzzPage.executeAutoItScript();
		buzzPage.shareButton.click();
		driver.navigate().refresh();
		
		
	}

	@Test
	public void OHRM011Test() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
		
		BuzzPage buzzPage = new BuzzPage(driver);
		buzzPage.buzzMenu().click();
		buzzPage.sharevideoButton().click();
		buzzPage.pastVideoUrl().sendKeys("https://youtu.be/kBESOqobduE?si=Yvycd0W9LWq2-DN2");
		buzzPage.shareVideoButton.click();
		
	}
	
	@Test
	public void OHRM012Test() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
		loginPage.userDropdown().click();
		loginPage.logout().click();
	}
		

	 @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	
	
	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] {
			{"Admin", "admin123"},
			
		};
	}
	
	@DataProvider(name = "invalidLoginData")
	public Object[][] invalidLoginData() {
		return new Object[][] {			
			{"Admin", "james789"}  
		};
	}
	
	@DataProvider(name = "username")
	public Object[] usernameData() {
		return new Object[][] {			
			{"Admin"}
		};
	}
		
}
