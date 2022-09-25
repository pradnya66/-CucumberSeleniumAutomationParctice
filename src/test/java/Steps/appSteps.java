package Steps;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.pages.LaunchPage;
import pom.pages.SearchPage;
import pom.pages.SignInPage;

public class appSteps {
	
	public WebDriver driver;
	public String browser = "Chrome";
	public String url = "http://automationpractice.com/index.php";
	//public String emailID = "test126@test217.com";
	
	public SearchPage searchObj = null;
	public LaunchPage launchObj = null;
	public SignInPage signInObj = null;
	
	
	
	@Before
	public void launchBrowser() throws Exception  {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
				
		if(browser.equalsIgnoreCase("Edge")){
			driver = new EdgeDriver();
		}
		else {
			 driver = new ChromeDriver();
		}
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(10000);
		driver.get(url);
		driver.manage().window().maximize();
		
		searchObj = PageFactory.initElements(driver, SearchPage.class);
		launchObj = PageFactory.initElements(driver, LaunchPage.class);
		signInObj = PageFactory.initElements(driver, SignInPage.class);
		
	}
	@Given("Launch Browser With URL {string}")
	public void launch_browser_with_url(String string) {
		
		System.out.println("Launch URL");
	    
	}
	@When("Enter Search String {string}")
	public void enter_search_string(String string) throws Exception {
				
		boolean retFlag = searchObj.search(string);
		assertTrue(retFlag, "Search page fails");
	}
	@Then("Summer Dresses search page should appear")
	public void summer_dresses_search_page_should_appear() throws Exception {
		String retMsg = searchObj.clickDresses();
		assertTrue(retMsg.isEmpty(), retMsg);
//		driver.quit();  
	}
	@Given("Click on Sign in")
	public void click_on_sign_in() throws Exception {
		boolean retFlag = signInObj.launchSignin("p336@mail.com");
		assertTrue(retFlag, "Launch SignPage failed");
	}
	@When("Enter Email Id On create User")
	public void enter_email_id_on_create_user() throws Exception {
		boolean retFlag = signInObj.registerUser("p336@mail.com");
		assertTrue(retFlag, "Failed to register user");
		
	 
	}
	@When("Enter User details and click on Register user")
	public void enter_user_details_and_click_on_register_user() throws Exception {
		System.out.println("Unused When");
	}
	@Then("User creation should be successful")
	public void user_creation_should_be_successful() {
		
			driver.quit();
	}

}
