package ObjectRepository;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuzzPage {
	
	WebDriver driver;
	
	public BuzzPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-title orangehrm-buzz-newsfeed-title']")
	private WebElement buzzNewsfeedText;

	@FindBy(xpath = "//span[normalize-space()='Buzz']")
	private WebElement buzzMenu;
	
	@FindBy(xpath = "//textarea[@placeholder=\"What's on your mind?\"]")
	private WebElement postArea;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement postButton;

	@FindBy(xpath = "//button[normalize-space()='Share Photos']")
	private WebElement selectPhotoButton;
	
	@FindBy(xpath = "//button[normalize-space()='Share Video']")
	private WebElement sharevideoButton;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-images orangehrm-photo-upload-icon']")
	private WebElement addPhotos;
	
	@FindBy(xpath = "(//textarea[@placeholder=\"What's on your mind?\"])[2]")
	public WebElement addText;
	
	@FindBy (xpath = "(//div[@role='dialog']//form[@class='oxd-form']//button[1])[3]")
	public WebElement shareButton;
	
	@FindBy(xpath = "//textarea[@placeholder='Paste Video URL']")
	public WebElement pastVideoUrl;
	
	@FindBy(xpath = "//div[@role='dialog']//form[@class='oxd-form']//button[1]")
	public WebElement shareVideoButton;

	public WebElement buzzNewsfeedText(){
		return buzzNewsfeedText;
	}
	
	public WebElement buzzMenu() {
		return buzzMenu;
	}
	
	public WebElement postArea() {
		return postArea;
	}
	
	public WebElement postButton() {
		return postButton;
	}
	
	public WebElement selectPhotoButton() {
		return selectPhotoButton;
	}
	
	public WebElement sharevideoButton() {
		return sharevideoButton;
	}
	
	public WebElement addPhotos() {
		return addPhotos;
	}
	
	public WebElement addText() {
		return addText;
	}
	
	public WebElement shareButton() {
		return shareButton;
	}
	
	public WebElement pastVideoUrl() {
		return pastVideoUrl;
	}
	
	public WebElement shareVideoButton() {
		return shareVideoButton;
	}

	public void executeAutoItScript() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        
        // Corrected file path with single backslashes
        processBuilder.command("C:\\Users\\Ankit\\eclipse-workspace\\Orange_HRM\\AutoItExecutableFile\\BrowseImage1.exe");
        
        try {
            // Start the AutoIt process
            Process process = processBuilder.start();
            
            // Wait for the process to finish
            int exitCode = process.waitFor();
            
            // Optionally, print the exit code of the process for debugging
            System.out.println("AutoIt script executed with exit code: " + exitCode);
            
        } catch (IOException | InterruptedException e) {
            // Handle IOException or InterruptedException
            e.printStackTrace();
        }
	}
}
