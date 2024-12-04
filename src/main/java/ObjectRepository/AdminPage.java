package ObjectRepository;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenu;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;

    @FindBy(xpath = "(//div[text()='-- Select --'])[1]")
    private WebElement selectUserRole;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    private WebElement selectStatus;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameField;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement usernameField;

    @FindBy(xpath = "(//input[@autocomplete='off' and @type='password'])[1]")
    private WebElement passwordField;

    @FindBy(xpath = "(//input[@autocomplete='off' and @type='password'])[2]")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    // Other existing methods...

    public WebElement adminMenu() {
        return adminMenu;
    }

    public WebElement addButton() {
        return addButton;
    }
    
    public WebElement selectUserRole() {
    	return selectUserRole;
    }

    public WebElement selectStatus() {
    	return selectStatus;
    }
    
    public WebElement employeeNameField() {
        return employeeNameField;
    }

    public WebElement usernameField() {
        return usernameField;
    }

    public WebElement passwordField() {
        return passwordField;
    }

    public WebElement confirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement saveButton() {
        return saveButton;
    }

    // New method to select from custom dropdowns
    public void selectCustomDropdown(WebElement dropdownElement, String optionText) {
        // Click the dropdown to reveal options
        dropdownElement.click();

        // Find the option by visible text or use XPath or CSS selector to locate the option
        WebElement option = driver.findElement(By.xpath("//div[@role='option'][normalize-space()='" + optionText + "']"));
        option.click();  // Select the option
    }

    // Random data generators (existing methods)
    public String generateRandomFName() {
        String[] firstNames = {"John", "Jane", "Alex", "Emily", "Michael", "Sarah"};
        Random random = new Random();
        return firstNames[random.nextInt(firstNames.length)];
    }

    public String generateRandomLName() {
        String[] lastNames = {"Doe", "Smith", "Johnson", "Williams", "Jones", "Brown"};
        Random random = new Random();
        return lastNames[random.nextInt(lastNames.length)];
    }

    public String generateRandomUName() {
        String[] firstThreeLatter = {"Jam", "Don", "Leo", "Sam", "Kat", "Ron", "Ann"};
        String[] lastThreeLatter = {"sir", "nic", "joe", "dam", "rat", "mat", "lat"};
        Random random = new Random();
        return firstThreeLatter[random.nextInt(firstThreeLatter.length)] + lastThreeLatter[random.nextInt(lastThreeLatter.length)];
    }
}
